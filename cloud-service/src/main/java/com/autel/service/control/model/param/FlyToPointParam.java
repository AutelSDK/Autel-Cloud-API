package com.autel.service.control.model.param;

import com.autel.great.mqtt.model.control.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlyToPointParam {

    private String flyToId;

    @Range(min = 1, max = 15)
    @NotNull
    private Integer maxSpeed;

    /**
     * The M30 series only support one point.
     */
    @Size(min = 1)
    @NotNull
    private List<@Valid Point> points;
}
