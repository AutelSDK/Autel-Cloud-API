package com.autel.service.manage.service;

import com.autel.service.manage.model.dto.CapacityVideoDTO;
import com.autel.service.manage.model.receiver.CapacityVideoReceiver;

/**
 * @author sean.zhou
 * @date 2021/11/19
 * @version 0.1
 */
public interface ICameraVideoService {

    /**
     * Convert the received lens capability object into lens data transfer object.
     * @param receiver
     * @return  data transfer object
     */
    CapacityVideoDTO receiver2Dto(CapacityVideoReceiver receiver);
}
