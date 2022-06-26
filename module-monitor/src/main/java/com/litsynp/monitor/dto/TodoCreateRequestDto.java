package com.litsynp.monitor.dto;

import com.litsynp.monitor.domain.Todo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoCreateRequestDto {

    private String description;
    private Boolean completed;
    private LocalDateTime dueBy;

    public Todo toEntity() {
        return Todo.builder()
                .description(description)
                .completed(completed)
                .dueBy(dueBy)
                .build();
    }
}
