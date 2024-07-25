package com.autel.service.map.model.param;

import com.autel.service.map.model.dto.FlightAreaContent;
import lombok.Data;

@Data
public class PutFlightAreaParam {

    private String name;

    private FlightAreaContent content;

    private Boolean status;

}
