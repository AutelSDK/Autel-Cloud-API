package com.autel.service.manage.model.dto;

public class FirmwareFileProperties {

    private FirmwareFileProperties() {

    }

    public static final String FIRMWARE_FILE_SUFFIX = ".zip";
    public static final String FIRMWARE_UAV_FILE_SUFFIX = ".uav";

    public static final String FIRMWARE_SIG_FILE_SUFFIX = ".sig";

    public static final String FIRMWARE_CONFIG_FILE_SUFFIX = ".cfg";

    public static final String FIRMWARE_FILE_DELIMITER = "_";
    public static final String FIRMWARE_FILE_BAR = "-";

    public static final int FILENAME_VERSION_INDEX = 2;

    public static final int FILENAME_RELEASE_DATE_INDEX = 3;

    public static final String FILENAME_RELEASE_DATE_FORMAT = "yyyyMMdd";

}
