package com.litsynp.monitor.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdateRequestDto {

    private String description;
    private Boolean completed;
    private LocalDateTime dueBy;

    public TodoUpdateServiceDto toServiceDto() {
        return TodoUpdateServiceDto.builder()
                .description(description)
                .completed(completed)
                .dueBy(dueBy)
                .build();
    }
}
