package com.autel.service.media.service.impl;

import com.autel.great.context.enums.device.DeviceEnum;
import com.autel.great.context.page.Pagination;
import com.autel.great.context.page.PaginationData;
import com.autel.great.mqtt.enums.media.MediaSubFileTypeEnum;
import com.autel.great.mqtt.model.media.MediaUploadCallbackRequest;
import com.autel.great.oss.model.OssConfiguration;
import com.autel.great.oss.service.impl.OssServiceContext;
import com.autel.service.manage.model.dto.DeviceDictionaryDTO;
import com.autel.service.manage.service.IDeviceDictionaryService;
import com.autel.service.media.dao.IFileMapper;
import com.autel.service.media.model.MediaFileDTO;
import com.autel.service.media.model.MediaFileEntity;
import com.autel.service.media.service.IFileService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class FileServiceImpl implements IFileService {

    @Autowired
    private IFileMapper mapper;

    @Autowired
    private IDeviceDictionaryService deviceDictionaryService;

    @Autowired
    private OssServiceContext ossService;

    private Optional<MediaFileEntity> getMediaByFingerprint(String workspaceId, String fingerprint) {
        MediaFileEntity fileEntity = mapper.selectOne(new LambdaQueryWrapper<MediaFileEntity>()
                .eq(MediaFileEntity::getWorkspaceId, workspaceId)
                .eq(MediaFileEntity::getFingerprint, fingerprint));
        return Optional.ofNullable(fileEntity);
    }

    private Optional<MediaFileEntity> getMediaByFileId(String workspaceId, String fileId) {
        MediaFileEntity fileEntity = mapper.selectOne(new LambdaQueryWrapper<MediaFileEntity>()
                .eq(MediaFileEntity::getWorkspaceId, workspaceId)
                .eq(MediaFileEntity::getFileId, fileId));
        return Optional.ofNullable(fileEntity);
    }

    @Override
    public Boolean checkExist(String workspaceId, String fingerprint) {
        return this.getMediaByFingerprint(workspaceId, fingerprint).isPresent();
    }

    @Override
    public Integer saveFile(String workspaceId, MediaUploadCallbackRequest file) {
        MediaFileEntity fileEntity = this.fileUploadConvertToEntity(file);
        fileEntity.setWorkspaceId(workspaceId);
        fileEntity.setFileId(UUID.randomUUID().toString());
        return mapper.insert(fileEntity);
    }

    @Override
    public List<MediaFileDTO> getAllFilesByWorkspaceId(String workspaceId) {
        return mapper.selectList(new LambdaQueryWrapper<MediaFileEntity>()
                        .eq(MediaFileEntity::getWorkspaceId, workspaceId))
                .stream()
                .map(this::entityConvertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaginationData<MediaFileDTO> getMediaFilesPaginationByWorkspaceId(String workspaceId, long page, long pageSize) {
        Page<MediaFileEntity> pageData = mapper.selectPage(
                new Page<MediaFileEntity>(page, pageSize),
                new LambdaQueryWrapper<MediaFileEntity>()
                        .eq(MediaFileEntity::getWorkspaceId, workspaceId)
                        .orderByDesc(MediaFileEntity::getId));
        List<MediaFileDTO> records = pageData.getRecords()
                .stream()
                .map(this::entityConvertToDto)
                .collect(Collectors.toList());

        return new PaginationData<MediaFileDTO>(records, new Pagination(pageData.getCurrent(), pageData.getSize(), pageData.getTotal()));
    }

    @Override
    public URL getObjectUrl(String workspaceId, String fileId) {
        Optional<MediaFileEntity> mediaFileOpt = getMediaByFileId(workspaceId, fileId);
        if (mediaFileOpt.isEmpty()) {
            throw new IllegalArgumentException("{} doesn't exist.");
        }

        return ossService.getObjectUrl(OssConfiguration.bucket, mediaFileOpt.get().getObjectKey());
    }

    @Override
    public List<MediaFileDTO> getFilesByWorkspaceAndJobId(String workspaceId, String jobId) {
        return mapper.selectList(new LambdaQueryWrapper<MediaFileEntity>()
                        .eq(MediaFileEntity::getWorkspaceId, workspaceId)
                        .eq(MediaFileEntity::getJobId, jobId))
                .stream()
                .map(this::entityConvertToDto).collect(Collectors.toList());
    }

    private MediaFileEntity fileUploadConvertToEntity(MediaUploadCallbackRequest file) {
        MediaFileEntity.MediaFileEntityBuilder builder = MediaFileEntity.builder();

        if (file != null) {
            builder.fileName(file.getName())
                    .filePath(file.getPath())
                    .fingerprint(file.getFingerprint())
                    .objectKey(file.getObjectKey())
                    .subFileType(Optional.ofNullable(file.getSubFileType()).map(MediaSubFileTypeEnum::getType).orElse(null))
                    .isOriginal(file.getExt().getOriginal())
                    .jobId(file.getExt().getFileGroupId())
                    .drone(file.getExt().getSn())
                    .tinnyFingerprint(file.getExt().getTinnyFingerprint())
                    .payload(file.getExt().getPayloadModelKey().getDevice());

            DeviceEnum payloadModelKey = file.getExt().getPayloadModelKey();
            Optional<DeviceDictionaryDTO> payloadDict = deviceDictionaryService
                    .getOneDictionaryInfoByTypeSubType(payloadModelKey.getDomain().getDomain(),
                            payloadModelKey.getType().getType(), payloadModelKey.getSubType().getSubType());
            payloadDict.ifPresent(payload -> builder.payload(payload.getDeviceName()));
        }
        return builder.build();
    }

    private MediaFileDTO entityConvertToDto(MediaFileEntity entity) {
        MediaFileDTO.MediaFileDTOBuilder builder = MediaFileDTO.builder();

        if (entity != null) {
            builder.fileName(entity.getFileName())
                    .fileId(entity.getFileId())
                    .filePath(entity.getFilePath())
                    .isOriginal(entity.getIsOriginal())
                    .fingerprint(entity.getFingerprint())
                    .objectKey(entity.getObjectKey())
                    .tinnyFingerprint(entity.getTinnyFingerprint())
                    .payload(entity.getPayload())
                    .createTime(LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(entity.getCreateTime()), ZoneId.systemDefault()))
                    .drone(entity.getDrone())
                    .jobId(entity.getJobId());

        }

        return builder.build();
    }

}
