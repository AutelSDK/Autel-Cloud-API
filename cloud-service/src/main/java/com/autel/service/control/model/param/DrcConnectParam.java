package com.autel.service.control.model.param;

import com.autel.great.redis.RedisConst;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class DrcConnectParam {

    private String clientId;

    @Range(min = 1800, max = 86400)
    private long expireSec = RedisConst.DRC_MODE_ALIVE_SECOND;
}
