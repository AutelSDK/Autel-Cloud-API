package com.autel.great.mqtt.model.wayline;


import com.autel.great.mqtt.enums.wayline.FlighttaskStatusEnum;

public class FlighttaskProgress {

    private FlighttaskProgressExt ext;

    private FlighttaskProgressData progress;

    private FlighttaskStatusEnum status;

    public FlighttaskProgress() {
    }

    @Override
    public String toString() {
        return "FlighttaskProgress{" +
                "ext=" + ext +
                ", progress=" + progress +
                ", status=" + status +
                '}';
    }

    public FlighttaskProgressExt getExt() {
        return ext;
    }

    public FlighttaskProgress setExt(FlighttaskProgressExt ext) {
        this.ext = ext;
        return this;
    }

    public FlighttaskProgressData getProgress() {
        return progress;
    }

    public FlighttaskProgress setProgress(FlighttaskProgressData progress) {
        this.progress = progress;
        return this;
    }

    public FlighttaskStatusEnum getStatus() {
        return status;
    }

    public FlighttaskProgress setStatus(FlighttaskStatusEnum status) {
        this.status = status;
        return this;
    }
}
