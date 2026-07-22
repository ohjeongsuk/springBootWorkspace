package com.zeus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Board;
import com.zeus.dto.BoardDTO;
import com.zeus.mapper.BoardMapper;

@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override
	@Transactional
	public boolean insert(BoardDTO boardDto) throws Exception {
		if (boardDto == null || boardDto.getTitle().isEmpty() == true) {
			return false;
		}
		Board board = new Board();
		board.setTitle(boardDto.getTitle());
		board.setWriter(boardDto.getWriter());
		board.setContent(boardDto.getContent());

		int count = mapper.insert(board);

		return (count == 0) ? (false) : (true);
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDTO select(BoardDTO boardDto) throws Exception {
		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());

		board = mapper.select(board);

		boardDto.setBoardNo((board.getBoardNo()));
		boardDto.setTitle(board.getTitle());
		boardDto.setContent(board.getContent());
		boardDto.setRegDate(board.getRegDate());
		boardDto.setWriter(board.getWriter());

		return boardDto;
	}

	@Override
	@Transactional
	public boolean update(BoardDTO boardDto) throws Exception {
		// 1. DB에서 게시글 조회 (값이 없으면 NoSuchElementException 발생)
		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());
		board.setTitle(boardDto.getTitle());
		board.setWriter(boardDto.getWriter());
		board.setContent(boardDto.getContent());

		int count = mapper.update(board);

		return (count == 0) ? (false) : (true);
	}

	@Override
	@Transactional
	public boolean delete(BoardDTO boardDto) throws Exception {

		Board board = new Board();
		board.setBoardNo(boardDto.getBoardNo());
		int count = mapper.delete(board);

		return count == 0 ? false : true;
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDTO> list() throws Exception {
		List<Board> list = mapper.list();

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

	@Override
	@Transactional(readOnly = true)
	public List<BoardDTO> search(BoardDTO boardDto) throws Exception {
		List<Board> list = mapper.search(boardDto.getTitle());
		
		if (list.size() <= 0) {
			return null;
		}
		List<BoardDTO> listDTO = new ArrayList<>();

		for (Board board : list) {
			BoardDTO _boardDto = new BoardDTO();
			_boardDto.setBoardNo(board.getBoardNo());
			_boardDto.setContent(board.getContent());
			_boardDto.setRegDate(board.getRegDate());
			_boardDto.setTitle(board.getTitle());
			_boardDto.setWriter(board.getWriter());
			listDTO.add(_boardDto);
		}
		return listDTO;
	}

}
