package com.autel.great.mqtt.model.wayline;

import com.autel.great.mqtt.enums.wayline.ExecutionStepEnum;

public class FlighttaskProgressData {

    /**
     * Execution step
     */
    private ExecutionStepEnum currentStep;

    /**
     * Progress value
     */
    private Integer percent;

    public FlighttaskProgressData() {
    }

    @Override
    public String toString() {
        return "FlighttaskProgressData{" +
                "currentStep=" + currentStep +
                ", percent=" + percent +
                '}';
    }

    public ExecutionStepEnum getCurrentStep() {
        return currentStep;
    }

    public FlighttaskProgressData setCurrentStep(ExecutionStepEnum currentStep) {
        this.currentStep = currentStep;
        return this;
    }

    public Integer getPercent() {
        return percent;
    }

    public FlighttaskProgressData setPercent(Integer percent) {
        this.percent = percent;
        return this;
    }
}
