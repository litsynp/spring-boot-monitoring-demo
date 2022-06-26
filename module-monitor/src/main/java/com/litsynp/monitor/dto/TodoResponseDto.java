package com.litsynp.monitor.dto;

import com.litsynp.monitor.domain.Todo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoResponseDto {

    private Long id;
    private String description;
    private Boolean completed;
    private LocalDateTime dueBy;
    private LocalDateTime createdOn;

    public static TodoResponseDto from(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .description(todo.getDescription())
                .completed(todo.getCompleted())
                .dueBy(todo.getDueBy())
                .createdOn(todo.getCreatedOn())
                .build();
    }
}
