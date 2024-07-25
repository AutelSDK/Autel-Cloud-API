package com.autel.api.device;

import com.autel.great.context.annotations.CloudSDKVersion;
import com.autel.great.context.enums.version.CloudSDKVersionEnum;
import com.autel.great.context.enums.version.GatewayTypeEnum;
import com.autel.great.mqtt.core.consume.MqttReply;
import com.autel.great.mqtt.constant.ChannelName;
import com.autel.great.mqtt.model.device.*;
import com.autel.great.mqtt.model.property.DockDroneCommanderFlightHeight;
import com.autel.great.mqtt.model.property.DockDroneCommanderModeLostAction;
import com.autel.great.mqtt.model.property.DockDroneRthMode;
import com.autel.great.mqtt.handle.osd.TopicOsdRequest;
import com.autel.great.mqtt.handle.state.TopicStateRequest;
import com.autel.great.mqtt.handle.state.TopicStateResponse;
import com.autel.great.mqtt.handle.status.TopicStatusRequest;
import com.autel.great.mqtt.handle.status.TopicStatusResponse;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHeaders;

public class AbstractDeviceService {

    @ServiceActivator(inputChannel = ChannelName.INBOUND_OSD_DOCK)
    public void osdDock(TopicOsdRequest<OsdDock> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdDock not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_OSD_DOCK_DRONE)
    public void osdDockDrone(TopicOsdRequest<OsdDockDrone> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdDockDrone not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_OSD_RC)
    public void osdRemoteControl(TopicOsdRequest<OsdRemoteControl> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdRemoteControl not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_OSD_RC_DRONE)
    public void osdRcDrone(TopicOsdRequest<OsdRcDrone> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("osdRcDrone not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATUS_ONLINE, outputChannel = ChannelName.OUTBOUND_STATUS)
    public TopicStatusResponse<MqttReply> updateTopoOnline(TopicStatusRequest<UpdateTopo> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("updateTopoOnline not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATUS_OFFLINE, outputChannel = ChannelName.OUTBOUND_STATUS)
    public TopicStatusResponse<MqttReply> updateTopoOffline(TopicStatusRequest<UpdateTopo> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("updateTopoOffline not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_FIRMWARE_VERSION)
    public void dockFirmwareVersionUpdate(TopicStateRequest<DockFirmwareVersion> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_RC_AND_DRONE_FIRMWARE_VERSION)
    public void rcAndDroneFirmwareVersionUpdate(TopicStateRequest<FirmwareVersion> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("rcAndDroneFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_CONTROL_SOURCE)
    public void dockControlSourceUpdate(TopicStateRequest<DockDroneControlSource> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockControlSourceUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_RC_CONTROL_SOURCE)
    public void rcControlSourceUpdate(TopicStateRequest<RcDroneControlSource> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("rcControlSourceUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_LIVE_STATUS)
    public void dockLiveStatusUpdate(TopicStateRequest<DockLiveStatus> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockLiveStatusUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_RC_LIVE_STATUS)
    public void rcLiveStatusUpdate(TopicStateRequest<RcLiveStatus> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("rcLiveStatusUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_RC_PAYLOAD_FIRMWARE)
    public void rcPayloadFirmwareVersionUpdate(TopicStateRequest<PayloadFirmwareVersion> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("rcPayloadFirmwareVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_WPMZ_VERSION)
    public void dockWpmzVersionUpdate(TopicStateRequest<DockDroneWpmzVersion> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockWpmzVersionUpdate not implemented");
    }

    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_THERMAL_SUPPORTED_PALETTE_STYLE)
    public void dockThermalSupportedPaletteStyle(TopicStateRequest<DockDroneThermalSupportedPaletteStyle> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockThermalSupportedPaletteStyle not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_RTH_MODE, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneRthMode(TopicStateRequest<DockDroneRthMode> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockRthMode not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_CURRENT_RTH_MODE, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneCurrentRthMode(TopicStateRequest<DockDroneCurrentRthMode> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockCurrentRthMode not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_COMMANDER_MODE_LOST_ACTION, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneCommanderModeLostAction(TopicStateRequest<DockDroneCommanderModeLostAction> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockDroneCommanderModeLostAction not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_CURRENT_COMMANDER_FLIGHT_MODE, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneCurrentCommanderFlightMode(TopicStateRequest<DockDroneCurrentCommanderFlightMode> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockDroneCurrentCommanderFlightMode not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_COMMANDER_FLIGHT_HEIGHT, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneCommanderFlightHeight(TopicStateRequest<DockDroneCommanderFlightHeight> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockDroneCommanderFlightHeight not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_DRONE_MODE_CODE_REASON, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockDroneModeCodeReason(TopicStateRequest<DockDroneModeCodeReason> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockDroneModeCodeReason not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_1, include = GatewayTypeEnum.DOCK2)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_AND_DRONE_DONGLE_INFOS, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dongleInfos(TopicStateRequest<DongleInfos> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dongleInfos not implemented");
    }

    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_2, include = GatewayTypeEnum.DOCK)
    @ServiceActivator(inputChannel = ChannelName.INBOUND_STATE_DOCK_SILENT_MODE, outputChannel = ChannelName.OUTBOUND_STATE)
    public TopicStateResponse<MqttReply> dockSilentMode(TopicStateRequest<DockSilentMode> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("dockSilentMode not implemented");
    }

}
