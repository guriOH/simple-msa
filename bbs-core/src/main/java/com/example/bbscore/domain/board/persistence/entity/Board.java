package com.example.bbscore.domain.board.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "board")
@Entity
@SuperBuilder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    private String name;


    private boolean isAllowedComment;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
