package com.autel.service.manage.model.enums;

public enum LiveVideoQualityEnum {

    AUTO (0),

    SMOOTH(1),

    STANDARD_DEFINITION(2),

    HIGH_DEFINITION(3),

    ULTRA_HD(4),

    UNKNOWN(-1);

    private int val;

    LiveVideoQualityEnum(int val) {
        this.val = val;
    }

    public static LiveVideoQualityEnum find(int val) {
        if (AUTO.val == val) {
            return AUTO;
        }

        if (SMOOTH.val == val) {
            return SMOOTH;
        }

        if (STANDARD_DEFINITION.val == val) {
            return STANDARD_DEFINITION;
        }

        if (HIGH_DEFINITION.val == val) {
            return HIGH_DEFINITION;
        }

        if (ULTRA_HD.val == val) {
            return ULTRA_HD;
        }

        return UNKNOWN;
    }
}
