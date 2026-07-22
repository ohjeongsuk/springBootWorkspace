package com.hi.service;

import java.util.List;

import com.hi.dto.BoardDTO;

public interface BoardService {
	
	//insert
	public boolean insert(BoardDTO boardDto) throws Exception;
	
	//select
	public BoardDTO select(BoardDTO boardDto) throws Exception;
	
	//update
	public boolean update(BoardDTO boardDto) throws Exception;
	
	//delete
	public boolean delete(BoardDTO boardDto) throws Exception;
	
	//list
	public List<BoardDTO> list() throws Exception;
	
}
