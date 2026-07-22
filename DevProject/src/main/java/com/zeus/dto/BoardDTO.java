package com.zeus.dto;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Datapublic class BoardDTO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int coin;
	@DateTimeFormat(pattern= "yyyyMMdd")
    private Date dateOfBirth;
	private String gender;
	private ArrayList<String> nationality;
	private ArrayList<String> hobby;
	private boolean foreigner;
	private ArrayList<Address> address;
	private ArrayList<MultipartFile> picture;
	
}
