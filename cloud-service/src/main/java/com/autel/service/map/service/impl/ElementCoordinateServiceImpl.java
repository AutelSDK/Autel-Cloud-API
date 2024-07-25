package com.autel.service.map.service.impl;

import com.autel.great.mqtt.model.map.ElementCoordinate;
import com.autel.service.map.dao.IElementCoordinateMapper;
import com.autel.service.map.model.entity.ElementCoordinateEntity;
import com.autel.service.map.service.IElementCoordinateService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ElementCoordinateServiceImpl implements IElementCoordinateService {

    @Autowired
    private IElementCoordinateMapper mapper;

    @Override
    public List<ElementCoordinate> getCoordinateByElementId(String elementId) {
        return mapper.selectList(
                new LambdaQueryWrapper<ElementCoordinateEntity>()
                        .eq(ElementCoordinateEntity::getElementId, elementId))
                .stream()
                .map(this::entityConvertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveCoordinate(List<ElementCoordinate> coordinateList, String elementId) {
        for (ElementCoordinate coordinate : coordinateList) {
            ElementCoordinateEntity entity = this.dtoConvertToEntity(coordinate);
            entity.setElementId(elementId);

            int insert = mapper.insert(entity);
            if (insert <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean deleteCoordinateByElementId(String elementId) {
        return mapper.delete(new LambdaUpdateWrapper<ElementCoordinateEntity>()
                .eq(ElementCoordinateEntity::getElementId, elementId)) > 0;
    }

    private ElementCoordinate entityConvertToDto(ElementCoordinateEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ElementCoordinate()
                .setLongitude(entity.getLongitude())
                .setLatitude(entity.getLatitude())
                .setAltitude(entity.getAltitude());
    }

    private ElementCoordinateEntity dtoConvertToEntity(ElementCoordinate coordinate) {
        ElementCoordinateEntity.ElementCoordinateEntityBuilder builder = ElementCoordinateEntity.builder();
        if (coordinate == null) {
            return builder.build();
        }

        return builder
                .altitude(coordinate.getAltitude())
                .latitude(coordinate.getLatitude())
                .longitude(coordinate.getLongitude())
                .build();
    }
}
