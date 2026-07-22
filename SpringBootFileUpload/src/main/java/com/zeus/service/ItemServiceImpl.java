package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Item;
import com.zeus.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired 
	private ItemMapper mapper;
	
	@Override
	@Transactional
	public boolean insert(Item item) throws Exception {
		int count = mapper.insert(item);
		return count == 0 ? false : true;
	}

	@Override
	@Transactional(readOnly = true)
	public Item select(Item item) throws Exception {
		return mapper.select(item);
	}

	@Override
	@Transactional
	public boolean update(Item item) throws Exception {
		int count = mapper.update(item);
		return count == 0 ? false : true;
	}

	@Override
	@Transactional
	public boolean delete(Item item) throws Exception {
		int count = mapper.delete(item);
		return count == 0 ? false : true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	@Override
	@Transactional(readOnly = true)
	public String getPicture(Item item) throws Exception {
		return mapper.getPicture(item);
	}

}