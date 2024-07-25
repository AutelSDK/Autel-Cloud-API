package com.autel.great.mqtt.enums.map;

import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.model.map.ElementGeometryType;
import com.autel.great.mqtt.model.map.ElementLineStringGeometry;
import com.autel.great.mqtt.model.map.ElementPointGeometry;
import com.autel.great.mqtt.model.map.ElementPolygonGeometry;

import java.util.Optional;

public enum ElementTypeEnum {

    POINT(ElementResourceTypeEnum.POINT),

    LINE_STRING(ElementResourceTypeEnum.LINE_STRING),

    POLYGON(ElementResourceTypeEnum.POLYGON);

    private ElementResourceTypeEnum typeEnum;

    ElementTypeEnum(ElementResourceTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public static Optional<ElementGeometryType> findType(int val) {
        if (POINT.typeEnum.getType() == val) {
            return Optional.of(new ElementPointGeometry());
        }

        if (LINE_STRING.typeEnum.getType() == val) {
            return Optional.of(new ElementLineStringGeometry());
        }

        if (POLYGON.typeEnum.getType() == val) {
            return Optional.of(new ElementPolygonGeometry());
        }

        return Optional.empty();
    }

    public String getDesc() {
        return typeEnum.getTypeName();
    }

    public static int findVal(String desc) {
        if (POINT.typeEnum.getTypeName().equals(desc)) {
            return POINT.typeEnum.getType();
        }

        if (LINE_STRING.typeEnum.getTypeName().equals(desc)) {
            return LINE_STRING.typeEnum.getType();
        }

        if (POLYGON.typeEnum.getTypeName().equals(desc)) {
            return POLYGON.typeEnum.getType();
        }

        throw new CloudSDKException("unknown type:" + desc);
    }
}
