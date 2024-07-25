package com.autel.service.wayline.model.param;

import com.autel.great.mqtt.enums.wayline.OutOfControlActionEnum;
import com.autel.great.mqtt.enums.wayline.TaskTypeEnum;
import com.autel.great.mqtt.enums.wayline.WaylineTypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateJobParam {

    @NotBlank
    private String name;

    @NotBlank
    private String fileId;

    @NotBlank
    private String dockSn;

    @NotNull
    private WaylineTypeEnum waylineType;

    @NotNull
    private TaskTypeEnum taskType;

    @Range(min = 20, max = 500)
    @NotNull
    private Integer rthAltitude;

    @NotNull
    private OutOfControlActionEnum outOfControlAction;

    @Range(min = 50, max = 90)
    private Integer minBatteryCapacity;

    private Integer minStorageCapacity;

    private List<Long> taskDays;

    private List<List<Long>> taskPeriods;
}
