package com.mtbp.kanbanboard.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class TaskColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "taskColumn", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "task_order") // JPA will manage the task order!
    private List<Task> tasks;
}