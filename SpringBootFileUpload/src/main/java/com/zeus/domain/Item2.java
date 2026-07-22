package com.zeus.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item2 implements Serializable{
	private static final long serialVersionUID = 1L; 
	private Integer itemId; 
	private String itemName; 
	private Integer price; 
	private String description; 
	private List<MultipartFile> pictures; 
	private String pictureUrl;
	private String pictureUrl2;
}
