package com.autel.great.mqtt.model.map;

import com.autel.great.mqtt.enums.map.OfflineMapSyncReasonEnum;
import com.autel.great.mqtt.enums.map.OfflineMapSyncStatusEnum;

public class OfflineMapSyncProgress {

    /**
     * Sync status
     */
    private OfflineMapSyncStatusEnum status;

    /**
     * Result code
     */
    private OfflineMapSyncReasonEnum reason;

    /**
     * Offline map file information
     */
    private OfflineMapSyncFile file;

    public OfflineMapSyncProgress() {
    }

    @Override
    public String toString() {
        return "OfflineMapSyncProgress{" +
                "status=" + status +
                ", reason=" + reason +
                ", file=" + file +
                '}';
    }

    public OfflineMapSyncStatusEnum getStatus() {
        return status;
    }

    public OfflineMapSyncProgress setStatus(OfflineMapSyncStatusEnum status) {
        this.status = status;
        return this;
    }

    public OfflineMapSyncReasonEnum getReason() {
        return reason;
    }

    public OfflineMapSyncProgress setReason(OfflineMapSyncReasonEnum reason) {
        this.reason = reason;
        return this;
    }

    public OfflineMapSyncFile getFile() {
        return file;
    }

    public OfflineMapSyncProgress setFile(OfflineMapSyncFile file) {
        this.file = file;
        return this;
    }
}
