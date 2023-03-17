package com.example.bbscore.domain.board.persistence.entity;


import com.example.bbscore.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "board")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;

    private boolean isAllowedComment;

    private boolean isAllowedAttach;

}
