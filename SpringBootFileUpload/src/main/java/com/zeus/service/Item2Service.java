package com.zeus.service;

import java.util.List;

import com.zeus.domain.Item2;

public interface Item2Service {
	public boolean insert(Item2 item) throws Exception; 
	public Item2 select(Item2 item) throws Exception; 
	public boolean update(Item2 item) throws Exception; 
	public boolean delete(Item2 item) throws Exception; 
	public List<Item2> list() throws Exception; 
	public String getPicture(Item2 item) throws Exception;
	public String getPicture2(Item2 item) throws Exception;
}
