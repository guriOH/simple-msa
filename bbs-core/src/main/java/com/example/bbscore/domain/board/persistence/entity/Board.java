package com.example.bbscore.domain.board.persistence.entity;


import com.example.bbscore.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@Entity
@Table(name = "board")
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
