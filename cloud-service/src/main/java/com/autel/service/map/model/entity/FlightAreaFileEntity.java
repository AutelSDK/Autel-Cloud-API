package com.autel.service.map.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("flight_area_file")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightAreaFileEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("file_id")
    private String fileId;

    @TableField("workspace_id")
    private String workspaceId;

    @TableField("name")
    private String name;

    @TableField("object_key")
    private String objectKey;

    @TableField("sign")
    private String sign;

    @TableField("size")
    private Integer size;

    @TableField("latest")
    private Boolean latest;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;
}
