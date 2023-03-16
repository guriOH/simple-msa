package com.example.bbscore.domain.board.persistence.repository;

import com.example.bbscore.domain.board.persistence.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
