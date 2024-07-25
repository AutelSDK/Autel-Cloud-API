package com.autel.service.wayline.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaylineQueryParam {

    private boolean favorited;

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int pageSize = 10;

    private String orderBy;

    private Integer[] templateType;
}
