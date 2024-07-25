package com.autel.service.map.service;

import com.autel.great.mqtt.model.map.CreateMapElementRequest;
import com.autel.great.mqtt.model.map.MapGroupElement;
import com.autel.great.mqtt.model.map.UpdateMapElementRequest;
import com.autel.service.map.model.dto.GroupElementDTO;

import java.util.List;
import java.util.Optional;
public interface IGroupElementService {

    List<MapGroupElement> getElementsByGroupId(String groupId);

    Boolean saveElement(String groupId, CreateMapElementRequest elementCreate);

    Boolean updateElement(String elementId, UpdateMapElementRequest elementUpdate, String username);

    Boolean deleteElement(String elementId);

    Optional<GroupElementDTO> getElementByElementId(String elementId);
}
