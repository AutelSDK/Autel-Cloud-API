package com.autel.service.manage.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LiveDTO {

    private String url;

    private String username;

    private String password;
}