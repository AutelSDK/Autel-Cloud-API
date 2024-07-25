package com.autel.great.mqtt.model.control;

import com.autel.great.mqtt.enums.wayline.FlighttaskStatusEnum;

public class CameraPhotoTakeProgress {

    private PhotoTakeProgressExt ext;

    private PhotoTakeProgressData progress;

    private FlighttaskStatusEnum status;

    public CameraPhotoTakeProgress() {
    }

    @Override
    public String toString() {
        return "CameraPhotoTakeProgress{" +
                "ext=" + ext +
                ", progress=" + progress +
                ", status=" + status +
                '}';
    }

    public PhotoTakeProgressExt getExt() {
        return ext;
    }

    public CameraPhotoTakeProgress setExt(PhotoTakeProgressExt ext) {
        this.ext = ext;
        return this;
    }

    public PhotoTakeProgressData getProgress() {
        return progress;
    }

    public CameraPhotoTakeProgress setProgress(PhotoTakeProgressData progress) {
        this.progress = progress;
        return this;
    }

    public FlighttaskStatusEnum getStatus() {
        return status;
    }

    public CameraPhotoTakeProgress setStatus(FlighttaskStatusEnum status) {
        this.status = status;
        return this;
    }
}
