package com.litsynp.monitor.api;

import com.litsynp.monitor.domain.Todo;
import com.litsynp.monitor.dto.TodoCreateRequestDto;
import com.litsynp.monitor.dto.TodoResponseDto;
import com.litsynp.monitor.dto.TodoUpdateRequestDto;
import com.litsynp.monitor.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(TodoCreateRequestDto dto) {
        Todo created = todoService.create(dto.toEntity());
        TodoResponseDto response = TodoResponseDto.from(created);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TodoResponseDto>> list(
            @PageableDefault(sort = "createdOn", direction = Direction.DESC) Pageable pageable) {
        Page<TodoResponseDto> response = todoService.search(pageable).map(TodoResponseDto::from);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> detail(@PathVariable Long id) {
        Todo found = todoService.findById(id);
        TodoResponseDto response = TodoResponseDto.from(found);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable Long id, TodoUpdateRequestDto dto) {
        Todo found = todoService.update(id, dto.toServiceDto());
        TodoResponseDto response = TodoResponseDto.from(found);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
