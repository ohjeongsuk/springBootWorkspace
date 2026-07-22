package com.hi.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "JPABOARD_SEQ_GEN", sequenceName = "JPABOARD_SEQ",
				initialValue = 1, allocationSize = 1)
@Table(name = "jpaboard")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
            generator = "JPABOARD_SEQ_GEN" // 식별자 생성기를 설정해 놓은 JPABOARD_SEQ_GEN으로 설정
    )
    @Column(name = "board_no")
    private Long boardNo;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @CreationTimestamp
    @Column(name = "reg_date")
    private Date regDate;
}