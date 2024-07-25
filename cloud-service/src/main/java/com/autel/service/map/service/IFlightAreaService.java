package com.autel.service.map.service;

import com.autel.service.map.model.dto.FlightAreaDTO;
import com.autel.service.map.model.dto.FlightAreaFileDTO;
import com.autel.service.map.model.param.PostFlightAreaParam;
import com.autel.service.map.model.param.PutFlightAreaParam;

import java.util.List;
import java.util.Optional;

public interface IFlightAreaService {

    Optional<FlightAreaDTO> getFlightAreaByAreaId(String areaId);

    List<FlightAreaDTO> getFlightAreaList(String workspaceId);

    void createFlightArea(String workspaceId, String username, PostFlightAreaParam param);

    void syncFlightArea(String workspaceId, List<String> deviceSns);

    FlightAreaFileDTO packageFlightArea(String workspaceId);

    void deleteFlightArea(String workspaceId, String areaId);

    void updateFlightArea(String workspaceId, String areaId, PutFlightAreaParam param);

}
