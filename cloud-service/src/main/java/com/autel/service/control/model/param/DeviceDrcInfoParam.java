package com.autel.service.control.model.param;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class DeviceDrcInfoParam {

    @Range(min = 1, max = 30)
    private Integer osdFrequency = 10;

    @Range(min = 1, max = 30)
    private Integer hsiFrequency = 1;
}
