package com.zeus.service;

import java.util.List;

import com.zeus.domain.Item;

public interface ItemService {
	public boolean insert(Item item) throws Exception; 
	public Item select(Item item) throws Exception; 
	public boolean update(Item item) throws Exception; 
	public boolean delete(Item item) throws Exception; 
	public List<Item> list() throws Exception; 
	public String getPicture(Item item) throws Exception;
}
