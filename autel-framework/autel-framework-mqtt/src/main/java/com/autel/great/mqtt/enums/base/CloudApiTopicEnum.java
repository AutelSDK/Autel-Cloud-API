package com.autel.great.mqtt.enums.base;


import com.autel.great.mqtt.constant.TopicConst;
import com.autel.great.mqtt.constant.ChannelName;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum CloudApiTopicEnum {

    STATUS(Pattern.compile("^" + TopicConst.BASIC_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.STATUS_SUF + "$"), ChannelName.INBOUND_STATUS),

    STATE(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.STATE_SUF + "$"), ChannelName.INBOUND_STATE),

    SERVICE_REPLY(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.SERVICES_SUF + TopicConst._REPLY_SUF + "$"), ChannelName.INBOUND_SERVICES_REPLY),

    OSD(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.OSD_SUF + "$"), ChannelName.INBOUND_OSD),

    REQUESTS(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.REQUESTS_SUF + "$"), ChannelName.INBOUND_REQUESTS),

    EVENTS(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.EVENTS_SUF + "$"), ChannelName.INBOUND_EVENTS),

    PROPERTY_SET_REPLY(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.PROPERTY_SUF + TopicConst.SET_SUF + TopicConst._REPLY_SUF + "$"), ChannelName.INBOUND_PROPERTY_SET_REPLY),

    DRC_UP(Pattern.compile("^" + TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + TopicConst.REGEX_SN + TopicConst.DRC + TopicConst.UP + "$"), ChannelName.INBOUND_DRC_UP),

    UNKNOWN(Pattern.compile("^.*$"), ChannelName.DEFAULT);

    private final Pattern pattern;

    private final String beanName;

    CloudApiTopicEnum(Pattern pattern, String beanName) {
        this.pattern = pattern;
        this.beanName = beanName;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getBeanName() {
        return beanName;
    }

    public static CloudApiTopicEnum find(String topic) {
        return Arrays.stream(CloudApiTopicEnum.values()).filter(topicEnum -> topicEnum.pattern.matcher(topic).matches()).findAny().orElse(UNKNOWN);
    }
}
