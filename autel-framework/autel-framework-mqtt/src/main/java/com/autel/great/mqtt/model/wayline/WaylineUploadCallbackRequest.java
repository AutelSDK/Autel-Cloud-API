package com.autel.great.mqtt.model.wayline;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(description = "The data class of the upload result callback")
public class WaylineUploadCallbackRequest {

    @NotNull
    @Schema(description = "The key of the object in the bucket", example = "wayline/waylineFile.kmz")
    @JsonProperty("object_key")
    private String objectKey;

    @NotNull
    @Schema(description = "wayline file name", example = "waylineFile")
    private String name;

    @Valid
    @NotNull
    @Schema(description = "wayline file metadata")
    private WaylineUploadCallbackMetadata metadata;

    public WaylineUploadCallbackRequest() {
    }

    @Override
    public String toString() {
        return "WaylineUploadCallbackRequest{" +
                "objectKey='" + objectKey + '\'' +
                ", name='" + name + '\'' +
                ", metadata=" + metadata +
                '}';
    }

    public String getObjectKey() {
        return objectKey;
    }

    public WaylineUploadCallbackRequest setObjectKey(String objectKey) {
        this.objectKey = objectKey;
        return this;
    }

    public String getName() {
        return name;
    }

    public WaylineUploadCallbackRequest setName(String name) {
        this.name = name;
        return this;
    }

    public WaylineUploadCallbackMetadata getMetadata() {
        return metadata;
    }

    public WaylineUploadCallbackRequest setMetadata(WaylineUploadCallbackMetadata metadata) {
        this.metadata = metadata;
        return this;
    }
}
