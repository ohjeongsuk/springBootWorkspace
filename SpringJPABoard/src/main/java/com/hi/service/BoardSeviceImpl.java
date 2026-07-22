package com.hi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hi.domain.Board;
import com.hi.dto.BoardDTO;
import com.hi.repository.BoardRepository;

@Service
public class BoardSeviceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;

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

		// insert into board values(~~~);
		board = repository.save(board);
		return (board == null) ? (false) : (true);
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDTO select(BoardDTO boardDto) throws Exception {
		// return repository.getOne(boardNo);
		Board board = repository.getReferenceById(boardDto.getBoardNo());

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
		try {
			// 1. DB에서 게시글 조회 (값이 없으면 NoSuchElementException 발생)
			Board board = repository.findById(boardDto.getBoardNo()).orElseThrow();

			// 2. DTO의 새로운 데이터로 변경 (영속성 컨텍스트 변경 감지)
			board.setTitle(boardDto.getTitle());
			board.setContent(boardDto.getContent());

			// 3. 성공 시 true 반환
			return true;

		} catch (Exception e) {
			// 4. 에러 발생 시 콘솔에 원인을 출력하고 false 반환
			e.printStackTrace(); // 개발 중 로그 확인용
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(BoardDTO boardDto) throws Exception {

		try {
			// 1. 파라미터로 넘어온 번호로 데이터 삭제 진행
			repository.deleteById(boardDto.getBoardNo());

			// 2. 성공 시 true 반환
			return true;

		} catch (Exception e) {
			// 3. 에러 발생 시 콘솔에 원인을 출력하고 false 반환
			e.printStackTrace(); // 개발 중 로그 확인용
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<BoardDTO> list() throws Exception {
		List<Board> list = repository.findAll(Sort.by(Direction.DESC, "boardNo"));

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
