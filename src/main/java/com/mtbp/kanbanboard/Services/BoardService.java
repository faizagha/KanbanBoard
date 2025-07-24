package com.mtbp.kanbanboard.Services;


import com.mtbp.kanbanboard.Entities.*;
import com.mtbp.kanbanboard.Repostitories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired private BoardRepository boardRepository;
    @Autowired private TaskRepository taskRepository;
    @Autowired private TaskColumnRepository taskColumnRepository;

    // Milestone 1: Get the full board
    @Transactional(readOnly = true)
    public Board getBoard(Long boardId) {
        // The @OrderColumn annotation ensures columns and tasks are already sorted!
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    // Milestone 2: Change a task's column
    @Transactional
    public void moveTask(Long taskId, Long newColumnId, int newPosition) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        TaskColumn newColumn = taskColumnRepository.findById(newColumnId).orElseThrow(() -> new RuntimeException("Column not found"));

        // Remove from the old column's list
        task.getTaskColumn().getTasks().remove(task);

        // Add to the new column's list at the specified position
        newColumn.getTasks().add(newPosition, task);
        task.setTaskColumn(newColumn); // Update the task's parent column

        // JPA's @OrderColumn will automatically update the order indices
        taskRepository.save(task);
    }

    // Milestone 3: Change a task's order within the same column
    @Transactional
    public void reorderTask(Long taskId, int newPosition) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        TaskColumn column = task.getTaskColumn();

        // Just remove and re-add to the list. JPA handles the reordering.
        column.getTasks().remove(task);
        column.getTasks().add(newPosition, task);
        
        taskColumnRepository.save(column);
    }
}