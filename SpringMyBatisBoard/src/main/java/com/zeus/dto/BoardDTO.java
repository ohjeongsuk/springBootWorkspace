package com.zeus.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardDTO {
	private int boardNo;
	@NotBlank
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}
