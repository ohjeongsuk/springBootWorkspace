package com.hi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hi.domain.Board;
import com.hi.dto.BoardDTO;
import com.hi.repository.BoardRepo;

@Service
public class BoardSeviceImpl implements BoardService {
	
	@Autowired
	private BoardRepo boardRepo;
	
	@Override
	@Transactional
	public boolean insert(BoardDTO boardDto) throws Exception {
		if (boardDto == null || boardDto.getTitle() == null) {
			return false;
		}
		Board board = new Board();
		board.setTitle(boardDto.getTitle());
		board.setWriter(boardDto.getWriter());
		board.setContent(boardDto.getContent());
		return boardRepo.insert(board);
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDTO select(BoardDTO boardDto) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return null;
		}
		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());
		Board board1 = boardRepo.select(board);
		boardDto.setBoardNo(board1.getBoardNo());
		boardDto.setTitle(board1.getTitle());
		boardDto.setContent(board1.getContent());
		boardDto.setWriter(board1.getWriter());
		boardDto.setRegDate(board1.getRegDate());
		return boardDto;
	}

	@Override
	@Transactional
	public boolean update(BoardDTO boardDto) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return false;
		}
		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());
		board.setTitle(boardDto.getTitle());
		board.setWriter(boardDto.getWriter());
		board.setContent(boardDto.getContent());
		return boardRepo.update(board);
	}

	@Override
	@Transactional
	public boolean delete(BoardDTO boardDto) throws Exception {

		if (boardDto.getBoardNo() <= 0) {
			return false;
		}
		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());
		return boardRepo.delete(board);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		List<Board> list = boardRepo.list();
		if (list.size() <= 0) {
			return null;
		}
		List<BoardDTO> list2 = new ArrayList<>();
		for (Board board : list) {
			BoardDTO boardDto = new BoardDTO();
			boardDto.setBoardNo(board.getBoardNo());
			boardDto.setContent(board.getContent());
			boardDto.setRegDate(board.getRegDate());
			boardDto.setTitle(board.getTitle());
			boardDto.setWriter(board.getWriter());
			list2.add(boardDto);
		}
		return list2;
		
	}

}
