package com.litsynp.monitor.service;

import com.litsynp.monitor.dao.TodoRepository;
import com.litsynp.monitor.domain.Todo;
import com.litsynp.monitor.dto.TodoUpdateServiceDto;
import com.litsynp.monitor.exception.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Page<Todo> search(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public Todo update(Long id, TodoUpdateServiceDto dto) {
        Todo existing = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        existing.update(dto.getDescription(), dto.getCompleted(), dto.getDueBy());
        return existing;
    }

    public void deleteById(Long id) {
        Todo existing = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));

        todoRepository.delete(existing);
    }
}
