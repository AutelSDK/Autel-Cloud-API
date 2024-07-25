package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.enums.device.SwitchActionEnum;
import com.autel.great.mqtt.model.device.ObstacleAvoidance;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class ObstacleAvoidanceReceiver extends BasicDeviceProperty {

    private SwitchActionEnum horizon;

    private SwitchActionEnum upside;

    private SwitchActionEnum downside;

    public boolean valid() {
        return Objects.nonNull(this.horizon) || Objects.nonNull(this.upside) || Objects.nonNull(this.downside);
    }

    @Override
    public boolean canPublish(OsdDockDrone osd) {
        ObstacleAvoidance obstacleAvoidance = osd.getObstacleAvoidance();
        return (Objects.nonNull(obstacleAvoidance.getHorizon()) && horizon != obstacleAvoidance.getHorizon())
                || (Objects.nonNull(obstacleAvoidance.getUpside()) && upside != obstacleAvoidance.getUpside())
                || (Objects.nonNull(obstacleAvoidance.getDownside()) && downside != obstacleAvoidance.getDownside());
    }
}
