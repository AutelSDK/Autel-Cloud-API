package com.autel.great.mqtt.model.property;

import com.autel.great.context.base.BaseModel;
import com.autel.great.mqtt.enums.device.UserExperienceImprovementEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class UserExperienceImprovementSet extends BaseModel {

    @NotNull
    @JsonProperty("user_experience_improvement")
    private UserExperienceImprovementEnum userExperienceImprovement;

    public UserExperienceImprovementSet() {
    }

    @Override
    public String toString() {
        return "UserExperienceImprovementSet{" +
                "userExperienceImprovement=" + userExperienceImprovement +
                '}';
    }

    public UserExperienceImprovementEnum getUserExperienceImprovement() {
        return userExperienceImprovement;
    }

    public UserExperienceImprovementSet setUserExperienceImprovement(UserExperienceImprovementEnum userExperienceImprovement) {
        this.userExperienceImprovement = userExperienceImprovement;
        return this;
    }
}
