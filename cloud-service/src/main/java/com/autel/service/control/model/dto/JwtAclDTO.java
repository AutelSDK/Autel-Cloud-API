package com.autel.service.control.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAclDTO {

    private List<String> sub;

    private List<String> pub;

    private List<String> all;
}
