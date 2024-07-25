package com.autel.service.manage.model.receiver;

import lombok.Data;

@Data
public class WirelessLinkStateReceiver {

    private Integer downloadQuality;

    private Double frequencyBand;

    private Integer upwardQuality;

}