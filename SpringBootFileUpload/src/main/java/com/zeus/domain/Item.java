package com.zeus.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item implements Serializable{
	private static final long serialVersionUID = 1L; 
	private Integer itemId; 
	private String itemName; 
	private Integer price; 
	private String description; 
	private MultipartFile picture; 
	private String pictureUrl;
}
