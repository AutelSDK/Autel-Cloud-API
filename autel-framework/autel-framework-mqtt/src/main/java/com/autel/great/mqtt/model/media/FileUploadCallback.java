package com.autel.great.mqtt.model.media;

public class FileUploadCallback {

    private Integer result;

    private Integer progress;

    private FileUploadCallbackFile file;

    public FileUploadCallback() {
    }

    @Override
    public String toString() {
        return "FileUploadCallback{" +
                "result=" + result +
                ", progress=" + progress +
                ", file=" + file +
                '}';
    }

    public Integer getResult() {
        return result;
    }

    public FileUploadCallback setResult(Integer result) {
        this.result = result;
        return this;
    }

    public Integer getProgress() {
        return progress;
    }

    public FileUploadCallback setProgress(Integer progress) {
        this.progress = progress;
        return this;
    }

    public FileUploadCallbackFile getFile() {
        return file;
    }

    public FileUploadCallback setFile(FileUploadCallbackFile file) {
        this.file = file;
        return this;
    }
}
