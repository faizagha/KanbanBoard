package com.mtbp.kanbanboard.Repostitories;

import com.mtbp.kanbanboard.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}