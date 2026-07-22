package com.zeus.mapper;

import java.util.List;

import com.zeus.domain.Item;

public interface ItemMapper {	
	public int insert(Item item) throws Exception; 
	public Item select(Item item) throws Exception; 
	public int update(Item item) throws Exception; 
	public int delete(Item item) throws Exception; 
	public List<Item> list() throws Exception; 
	public String getPicture(Item item) throws Exception;
}