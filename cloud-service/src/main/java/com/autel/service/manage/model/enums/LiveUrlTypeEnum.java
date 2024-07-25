package com.autel.service.manage.model.enums;

public enum LiveUrlTypeEnum {

    AGORA(0),

    RTMP(1),

    RTSP(2),

    GB28181(3),

    UNKNOWN(-1);

    private int val;

    LiveUrlTypeEnum(int val) {
        this.val = val;
    }

    public static LiveUrlTypeEnum find(Integer val) {
        if (AGORA.val == val) {
            return AGORA;
        }
        if (RTMP.val == val) {
            return RTMP;
        }
        if (RTSP.val == val) {
            return RTSP;
        }
        if (GB28181.val == val) {
            return GB28181;
        }
        return UNKNOWN;
    }
}
