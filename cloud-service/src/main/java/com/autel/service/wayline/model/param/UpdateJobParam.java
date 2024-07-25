package com.autel.service.wayline.model.param;

import com.autel.service.wayline.model.enums.WaylineTaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJobParam {

    private WaylineTaskStatusEnum status;

}
