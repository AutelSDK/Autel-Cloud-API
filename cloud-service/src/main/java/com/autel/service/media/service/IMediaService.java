package com.autel.service.media.service;



import com.autel.great.mqtt.model.media.MediaUploadCallbackRequest;

import java.util.List;

public interface IMediaService {

    Boolean fastUpload(String workspaceId, String fingerprint);

    Integer saveMediaFile(String workspaceId, MediaUploadCallbackRequest file);

    List<String> getAllTinyFingerprintsByWorkspaceId(String workspaceId);

    List<String> getExistTinyFingerprints(String workspaceId, List<String> tinyFingerprints);

}
