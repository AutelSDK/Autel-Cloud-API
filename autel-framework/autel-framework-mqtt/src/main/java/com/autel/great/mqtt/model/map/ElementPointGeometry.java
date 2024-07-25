package com.autel.great.mqtt.model.map;

import com.autel.great.context.exception.CloudSDKErrorEnum;
import com.autel.great.context.exception.CloudSDKException;
import com.autel.great.mqtt.enums.map.ElementResourceTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Schema(description = "point geometry")
public class ElementPointGeometry extends ElementGeometryType {

    @Schema(example = "Point")
    @NotNull
    private final String type = ElementResourceTypeEnum.POINT.getTypeName();

    @Schema(example = "[113.943109, 22.577378]")
    @NotNull
    @Size(min = 2, max = 3)
    private Double[] coordinates;

    public ElementPointGeometry() {
        super();
    }

    @Override
    public List<ElementCoordinate> convertToList() {
        List<ElementCoordinate> coordinateList = new ArrayList<>();
        coordinateList.add(new ElementCoordinate()
                .setLongitude(this.coordinates[0])
                .setLatitude(this.coordinates[1])
                .setAltitude(this.coordinates.length == 3 ? this.coordinates[2] : null));
        return coordinateList;
    }

    @Override
    public void adapterCoordinateType(List<ElementCoordinate> coordinateList) {
        if (CollectionUtils.isEmpty(coordinateList)) {
            throw new CloudSDKException(CloudSDKErrorEnum.INVALID_PARAMETER);
        }
        this.coordinates = new Double[]{
                coordinateList.get(0).getLongitude(),
                coordinateList.get(0).getLatitude(),
                coordinateList.get(0).getAltitude()
        };
    }

    @Override
    public String toString() {
        return "ElementPointGeometry{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public ElementPointGeometry setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public String getType() {
        return type;
    }
}
