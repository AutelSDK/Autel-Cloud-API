package com.autel.service.manage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceFirmwareNoteDTO {

    private String deviceName;

    private String productVersion;

    private String releaseNote;

    private LocalDate releasedTime;
}
