package com.mtbp.kanbanboard.Repostitories;

import com.mtbp.kanbanboard.Entities.TaskColumn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskColumnRepository extends JpaRepository<TaskColumn, Long> {}