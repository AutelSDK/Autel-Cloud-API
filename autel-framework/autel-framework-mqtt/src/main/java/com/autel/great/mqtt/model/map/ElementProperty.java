package com.autel.great.mqtt.model.map;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Schema(description = "properties of the element")
public class ElementProperty {

    @NotNull
    @Schema(description = "element color", example = "#2D8CF0")
    @Pattern(regexp = "^#[0-9a-fA-F]{6}$")
    private String color;

    @JsonProperty("clampToGround")
    @Schema(description = "Whether it is on the ground.")
    private Boolean clampToGround;

    public ElementProperty() {
    }

    @Override
    public String toString() {
        return "ElementProperty{" +
                "color='" + color + '\'' +
                ", clampToGround=" + clampToGround +
                '}';
    }

    public String getColor() {
        return color;
    }

    public ElementProperty setColor(String color) {
        this.color = color;
        return this;
    }

    public Boolean getClampToGround() {
        return clampToGround;
    }

    public ElementProperty setClampToGround(Boolean clampToGround) {
        this.clampToGround = clampToGround;
        return this;
    }
}
