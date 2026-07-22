package com.zeus.mapper;

import java.util.List;

import com.zeus.domain.Item2;

public interface Item2Mapper {	
	public int insert(Item2 item) throws Exception; 
	public Item2 select(Item2 item) throws Exception; 
	public int update(Item2 item) throws Exception; 
	public int delete(Item2 item) throws Exception; 
	public List<Item2> list() throws Exception; 
	public String getPicture(Item2 item) throws Exception;
	public String getPicture2(Item2 item) throws Exception;
}