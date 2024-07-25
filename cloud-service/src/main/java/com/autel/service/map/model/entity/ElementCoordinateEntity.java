package com.autel.service.map.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "map_element_coordinate")
public class ElementCoordinateEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("element_id")
    private String elementId;

    @TableField("longitude")
    private Double longitude;

    @TableField("latitude")
    private Double latitude;

    @TableField("altitude")
    private Double altitude;

}
