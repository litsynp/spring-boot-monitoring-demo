package com.litsynp.monitor.dao;

import com.litsynp.monitor.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
