package com.autel.service.map.service.impl;

import com.autel.great.mqtt.enums.map.GroupTypeEnum;
import com.autel.great.mqtt.model.map.GetMapElementsResponse;
import com.autel.service.map.dao.IGroupMapper;
import com.autel.service.map.model.entity.GroupEntity;
import com.autel.service.map.service.IGroupElementService;
import com.autel.service.map.service.IGroupService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private IGroupMapper mapper;

    @Autowired
    private IGroupElementService groupElementService;

    @Override
    public List<GetMapElementsResponse> getAllGroupsByWorkspaceId(String workspaceId, String groupId, Boolean isDistributed) {

        return mapper.selectList(
                        new LambdaQueryWrapper<GroupEntity>()
                                .eq(GroupEntity::getWorkspaceId, workspaceId)
                                .eq(StringUtils.hasText(groupId), GroupEntity::getGroupId, groupId)
                                .eq(isDistributed != null, GroupEntity::getIsDistributed, isDistributed))
                .stream()
                .map(this::entityConvertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GetMapElementsResponse> getCustomGroupByWorkspaceId(String workspaceId) {
        return Optional.ofNullable(mapper.selectOne(
                        Wrappers.lambdaQuery(GroupEntity.class)
                                .eq(GroupEntity::getWorkspaceId, workspaceId)
                                .eq(GroupEntity::getGroupType, GroupTypeEnum.CUSTOM.getType())
                                .last(" limit 1")))
                .map(this::entityConvertToDto);
    }

    /**
     * Convert database entity objects into group data transfer object.
     *
     * @param entity
     * @return
     */
    private GetMapElementsResponse entityConvertToDto(GroupEntity entity) {
        if (entity == null) {
            return null;
        }

        return new GetMapElementsResponse()
                .setId(entity.getGroupId())
                .setName(entity.getGroupName())
                .setType(GroupTypeEnum.find(entity.getGroupType()))
                .setLock(entity.getIsLock());
    }
}
