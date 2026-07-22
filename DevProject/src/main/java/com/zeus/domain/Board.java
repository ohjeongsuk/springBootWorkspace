package com.zeus.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(exclude = {"regDate","COUNT"})
@Builder
public class Board {
	
	//멤변(게시판)
	@NonNull
	private int boardNo;      //pk
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int COUNT;
	

}

