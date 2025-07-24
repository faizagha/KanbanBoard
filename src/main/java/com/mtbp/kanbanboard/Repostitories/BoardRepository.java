package com.mtbp.kanbanboard.Repostitories;

import com.mtbp.kanbanboard.Entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {}