package com.autel.service.manage.model.param;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DeviceQueryParam {

    private String deviceSn;

    private String workspaceId;

    private Integer deviceType;

    private Integer subType;

    private List<Integer> domains;

    private String childSn;

    private Boolean boundStatus;

    private boolean orderBy;

    private boolean isAsc;
}