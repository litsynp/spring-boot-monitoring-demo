package com.litsynp.monitor.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean completed;

    private LocalDateTime dueBy;

    private LocalDateTime createdOn;

    @Builder
    public Todo(String description, Boolean completed, LocalDateTime dueBy) {
        this.description = description;
        this.completed = completed;
        this.dueBy = dueBy;
        this.createdOn = LocalDateTime.now();
    }

    public void update(String description, Boolean completed, LocalDateTime dueBy) {
        this.description = description;
        this.completed = completed;
        this.dueBy = dueBy;
    }
}
