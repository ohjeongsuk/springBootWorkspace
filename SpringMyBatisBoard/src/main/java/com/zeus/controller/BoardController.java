package com.zeus.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.dto.BoardDTO;
import com.zeus.exception.BoardRecordNotFoundException;
import com.zeus.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
public class BoardController {

	//@Autowired
	private BoardService boardService;
	
	//생성자
//	@Autowired
//	public BoardController(BoardService boardService) {
//		this.boardSevice = boardService;
//	}
	
	//setter
	@Autowired
	public void setBoardSevice(BoardService boardSevice) {
		this.boardService = boardSevice;
	}
	
	// 게시판 입력창화면 요청
	@GetMapping(value = "/board/insertForm")
	public String boardInsertForm(BoardDTO boardDto, Model model) {
		model.addAttribute("boardDto", boardDto);
		return "board/insertForm";
	}

	// 게시판 입력저장 요청
	@PostMapping(value = "/board/insert")
	public String boardInsert(@Validated @ModelAttribute("boardDto") BoardDTO boardDto,BindingResult bindingResult, Model model, RedirectAttributes rttr) throws Exception {
		log.info("board/insert" + boardDto.toString());
		if (bindingResult.hasErrors()) {
			return "board/insertForm";
		}
		boolean result = boardService.insert(boardDto);
		
		if (result == false) {
//			rttr.addFlashAttribute("msg","게시글 작성이 실패되었습니다");
			throw new BoardRecordNotFoundException("title 입력이 안됨"+boardDto.toString());
		} else {
			rttr.addFlashAttribute("msg","게시글이 작성되었습니다");
			rttr.addAttribute("writer",boardDto.getWriter());  // /board/list?writer =
		}
		return "redirect:/board/list";
	}

	// 게시판 리스트 요청
	@GetMapping(value = "/board/list")
	public String boardList(Model model) throws Exception {
		List<BoardDTO> list = boardService.list();
		if (list == null || list.size() <= 0) {
			return "board/false";
		}
		model.addAttribute("list", list);
		return "board/list";
	}

	// 선택된 게시글 요청
	@GetMapping(value = "/board/select")
	public String boardSelect(BoardDTO boardDto, Model model) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return "board/false";
		}
		boardDto = boardService.select(boardDto);
		if (boardDto == null) {
//			return "board/false";
			throw new BoardRecordNotFoundException(boardDto.getBoardNo()+"번 게시글은 없는 게시글입니다.!");
		}
		model.addAttribute("boardDto", boardDto);
		return "board/select";
	}

	// 선택된 게시글 요청
	@GetMapping(value = "/board/delete")
	public String boardDelete(BoardDTO boardDto, Model model) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return "board/false";
		}
		boolean result = boardService.delete(boardDto);
		if (result == false) {
			return "board/false";
		}
		return "board/success";
	}

	// 게시판 수정화면 요청
	@GetMapping(value = "/board/updateForm")
	public String boardUpdateForm(BoardDTO boardDto, Model model) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return "board/false";
		}
		boardDto = boardService.select(boardDto);
		model.addAttribute("boardDto",boardDto);
		return "board/updateForm";
	}
	
	// 게시판내용 수정 요청
	@PostMapping(value = "/board/update")
	public String boardUpdate(BoardDTO boardDto, Model model) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return "board/false";
		}
		boolean result= boardService.update(boardDto);
		
		if (result == false) {
			return "board/false";
		}
		return "board/success";
	}
	
	// 게시판 수정화면 요청
	@PostMapping(value = "/board/search")
	public String boardSearch(BoardDTO boardDto, Model model) throws Exception {
		List<BoardDTO> list = boardService.search(boardDto);
		
		if (list == null || list.size() <= 0) {
			return "board/false";
		}
		model.addAttribute("list", list);
		return "board/list";
	}
	
}













