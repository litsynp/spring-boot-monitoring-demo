package com.litsynp.monitor.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoUpdateServiceDto {

    private String description;
    private Boolean completed;
    private LocalDateTime dueBy;
}
