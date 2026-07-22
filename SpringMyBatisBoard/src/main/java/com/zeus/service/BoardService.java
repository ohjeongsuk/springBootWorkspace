package com.zeus.service;

import java.util.List;

import com.zeus.dto.BoardDTO;


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
	
	//search
	public List<BoardDTO> search(BoardDTO boardDto) throws Exception;
	
}
