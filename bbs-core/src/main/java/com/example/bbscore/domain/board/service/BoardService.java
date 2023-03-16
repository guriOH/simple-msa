package com.example.bbscore.domain.board.service;


import com.example.bbscore.domain.board.persistence.entity.Board;
import com.example.bbscore.domain.board.persistence.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;

    public String test(){
        List<Board> list = boardRepository.findAll();
        log.info("Test");
        return "Test";
    }
}
