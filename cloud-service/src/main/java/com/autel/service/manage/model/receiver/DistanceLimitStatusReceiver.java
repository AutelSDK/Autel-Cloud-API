package com.autel.service.manage.model.receiver;

import com.autel.great.mqtt.enums.device.SwitchActionEnum;
import com.autel.great.mqtt.model.device.DockDistanceLimitStatus;
import com.autel.great.mqtt.model.device.OsdDockDrone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceLimitStatusReceiver extends BasicDeviceProperty {

    private SwitchActionEnum state;

    private Integer distanceLimit;

    private static final int DISTANCE_MAX = 8000;

    private static final int DISTANCE_MIN = 15;

    @Override
    public boolean valid() {
        if (Objects.isNull(state) && Objects.isNull(distanceLimit)) {
            return false;
        }
        if (Objects.nonNull(distanceLimit)) {
            return distanceLimit >= DISTANCE_MIN && distanceLimit <= DISTANCE_MAX;
        }
        return true;
    }

    @Override
    public boolean canPublish(OsdDockDrone osd) {
        DockDistanceLimitStatus distanceLimitStatus = osd.getDistanceLimitStatus();
        return (Objects.nonNull(distanceLimitStatus.getState()) && distanceLimitStatus.getState() != this.state)
                || (Objects.nonNull(distanceLimitStatus.getDistanceLimit())
                        && distanceLimitStatus.getDistanceLimit().intValue() != this.distanceLimit);
    }
}
