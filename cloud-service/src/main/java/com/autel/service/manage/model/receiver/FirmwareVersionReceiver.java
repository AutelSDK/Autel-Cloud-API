package com.autel.service.manage.model.receiver;
import com.autel.great.context.enums.device.DeviceDomainEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FirmwareVersionReceiver {

    private String firmwareVersion;

    private Integer compatibleStatus;

    private Integer firmwareUpgradeStatus;

    private String sn;

    private DeviceDomainEnum domain;
}
