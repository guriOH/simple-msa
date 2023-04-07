package com.example.bbscore.domain.board.service;


import com.example.bbscore.base.exception.BbsException;
import com.example.bbscore.domain.board.dto.BoardInsertDto;
import com.example.bbscore.domain.board.dto.BoardUpdateDto;
import com.example.bbscore.domain.board.persistence.entity.Board;
import com.example.bbscore.domain.board.persistence.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoards(){
        return boardRepository.findAll();
    }

    public void register(BoardInsertDto boardInsertDto) {
        Board board = Board.builder()
                .name(boardInsertDto.getBbsName())
                .description(boardInsertDto.getDescription())
                .isAllowedComment(boardInsertDto.getIsAllowedComment())
                .isAllowedAttach(boardInsertDto.getIsAllowedAttach())
                .registeredDatetime(new Date())
                .registeredUserNumber(1L)
                .lastUpdatedDatetime(new Date())
                .lastUpdatedUserNumber(1L)
                .build();

        boardRepository.save(board);
    }

    @Transactional
    public void update(BoardUpdateDto boardUpdateDto) {
        Board board = boardRepository.findById(boardUpdateDto.getBoardId()).orElseThrow(() -> new BbsException("NOT_FOUND_RESOURCE"));

        board.setAllowedAttach(boardUpdateDto.getIsAllowedAttach());
        board.setAllowedComment(boardUpdateDto.getIsAllowedComment());
        board.setLastUpdatedDatetime(new Date());
        board.setLastUpdatedUserNumber(1L);
    }
}
