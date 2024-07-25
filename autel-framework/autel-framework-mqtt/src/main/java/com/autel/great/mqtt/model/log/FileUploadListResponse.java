package com.autel.great.mqtt.model.log;

import java.util.List;

public class FileUploadListResponse {

    private List<FileUploadListFile> files;

    public FileUploadListResponse() {
    }

    @Override
    public String toString() {
        return "FileUploadListResponse{" +
                "files=" + files +
                '}';
    }

    public List<FileUploadListFile> getFiles() {
        return files;
    }

    public FileUploadListResponse setFiles(List<FileUploadListFile> files) {
        this.files = files;
        return this;
    }
}
