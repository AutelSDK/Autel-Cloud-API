package com.autel.service.manage.service;


import com.autel.service.manage.model.dto.WorkspaceDTO;

import java.util.Optional;

public interface IWorkspaceService {

    Optional<WorkspaceDTO> getWorkspaceByWorkspaceId(String workspaceId);

    Optional<WorkspaceDTO> getWorkspaceNameByBindCode(String bindCode);

}
