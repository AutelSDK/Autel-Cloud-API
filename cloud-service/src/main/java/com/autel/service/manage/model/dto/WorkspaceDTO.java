package com.autel.service.manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkspaceDTO {

    private Integer id;

    private String workspaceId;

    private String workspaceName;

    private String workspaceDesc;

    private String platformName;

    private String bindCode;
}