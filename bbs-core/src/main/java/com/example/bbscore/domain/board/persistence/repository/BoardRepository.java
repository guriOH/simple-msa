package com.example.bbscore.domain.board.persistence.repository;

import com.example.bbscore.domain.board.persistence.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findAllByIsDeleted(boolean isDeleted);
}
