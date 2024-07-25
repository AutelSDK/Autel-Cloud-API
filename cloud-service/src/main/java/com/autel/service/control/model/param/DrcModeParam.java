package com.autel.service.control.model.param;

import com.autel.great.redis.RedisConst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrcModeParam {

    @NotBlank
    private String clientId;

    @NotBlank
    private String dockSn;

    @Range(min = 1800, max = 86400)
    @Builder.Default
    private long expireSec = RedisConst.DRC_MODE_ALIVE_SECOND;

    @Valid
    @Builder.Default
    private DeviceDrcInfoParam deviceInfo = new DeviceDrcInfoParam();
}
