package com.autel.great.mqtt.model.log;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class FileUploadStartParam {

    @NotNull
    @Size(min = 1, max = 2)
    private List<@Valid FileUploadStartFile> files;

    public FileUploadStartParam() {
    }

    @Override
    public String toString() {
        return "FileUploadStartParam{" +
                "files=" + files +
                '}';
    }

    public List<FileUploadStartFile> getFiles() {
        return files;
    }

    public FileUploadStartParam setFiles(List<FileUploadStartFile> files) {
        this.files = files;
        return this;
    }
}
