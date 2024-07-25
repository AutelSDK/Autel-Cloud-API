package com.autel.great.mqtt.model.device;

import com.autel.great.mqtt.enums.device.HeatStateEnum;
import com.autel.great.mqtt.enums.device.MaintenanceStateEnum;

import java.util.List;

public class DroneBatteryMaintenanceInfo {

    private List<DroneBatteryMaintenance> batteries;

    private MaintenanceStateEnum maintenanceState;

    private Integer maintenanceTimeLeft;

    private HeatStateEnum heatState;

    public DroneBatteryMaintenanceInfo() {
    }

    @Override
    public String toString() {
        return "DroneBatteryMaintenanceInfo{" +
                "batteries=" + batteries +
                ", maintenanceState=" + maintenanceState +
                ", maintenanceTimeLeft=" + maintenanceTimeLeft +
                ", heatState=" + heatState +
                '}';
    }

    public List<DroneBatteryMaintenance> getBatteries() {
        return batteries;
    }

    public DroneBatteryMaintenanceInfo setBatteries(List<DroneBatteryMaintenance> batteries) {
        this.batteries = batteries;
        return this;
    }

    public MaintenanceStateEnum getMaintenanceState() {
        return maintenanceState;
    }

    public DroneBatteryMaintenanceInfo setMaintenanceState(MaintenanceStateEnum maintenanceState) {
        this.maintenanceState = maintenanceState;
        return this;
    }

    public Integer getMaintenanceTimeLeft() {
        return maintenanceTimeLeft;
    }

    public DroneBatteryMaintenanceInfo setMaintenanceTimeLeft(Integer maintenanceTimeLeft) {
        this.maintenanceTimeLeft = maintenanceTimeLeft;
        return this;
    }

    public HeatStateEnum getHeatState() {
        return heatState;
    }

    public DroneBatteryMaintenanceInfo setHeatState(HeatStateEnum heatState) {
        this.heatState = heatState;
        return this;
    }
}
