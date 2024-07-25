package com.autel.great.mqtt.model.log;

import java.util.List;

public class FileUploadProgressExt {

    private List<FileUploadProgressFile> files;

    public FileUploadProgressExt() {
    }

    @Override
    public String toString() {
        return "FileUploadProgressExt{" +
                "files=" + files +
                '}';
    }

    public List<FileUploadProgressFile> getFiles() {
        return files;
    }

    public FileUploadProgressExt setFiles(List<FileUploadProgressFile> files) {
        this.files = files;
        return this;
    }
}
