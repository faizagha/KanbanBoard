package com.mtbp.kanbanboard.Controller;

import com.mtbp.kanbanboard.Entities.Board;
import com.mtbp.kanbanboard.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

class TaskMoveRequest {
    public Long newColumnId;
    public int newPosition;
}

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // Milestone 1 Endpoint
    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    // Milestone 2 Endpoint
    @PostMapping("/tasks/{taskId}/move")
    public ResponseEntity<Void> moveTask(@PathVariable Long taskId, @RequestBody TaskMoveRequest request) {
        boardService.moveTask(taskId, request.newColumnId, request.newPosition);
        return ResponseEntity.ok().build();
    }
    
    // Milestone 3 Endpoint
    @PostMapping("/tasks/{taskId}/reorder")
    public ResponseEntity<Void> reorderTask(@PathVariable Long taskId, @RequestBody TaskMoveRequest request) {
        // We only need the newPosition for reordering
        boardService.reorderTask(taskId, request.newPosition);
        return ResponseEntity.ok().build();
    }
}