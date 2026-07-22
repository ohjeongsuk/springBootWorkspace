package com.hi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hi.dto.BoardDTO;
import com.hi.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	//@Autowired
	private BoardService boardSevice;

//	@Autowired
//	public BoardController(BoardService boardService) {
//		this.boardSevice = boardService;
//	}
	
	@Autowired
	public void setBoardSevice(BoardService boardSevice) {
		this.boardSevice = boardSevice;
	}
	
	// 게시판 입력창화면 요청
	@GetMapping(value = "/board/insertForm")
	public String boardInsertForm(BoardDTO boardDto, Model model) {
		model.addAttribute("boardDto", boardDto);
		return "board/insertForm";
	}

	// 게시판 입력저장 요청
	@PostMapping(value = "/board/insert")
	public String boardInsert(BoardDTO boardDto, Model model, RedirectAttributes rttr) throws Exception {
		log.info("board/insert" + boardDto.toString());
		boolean result = boardSevice.insert(boardDto);

		if (result == false) {
			rttr.addFlashAttribute("msg","게시글 작성이 실패되었습니다");
		} else {
			rttr.addFlashAttribute("msg","게시글이 작성되었습니다");
			rttr.addAttribute("writer",boardDto.getWriter());  // /board/list?writer =
		}
		return "redirect:/board/list";
	}

	// 게시판 리스트 요청
	@GetMapping(value = "/board/list")
	public String boardList(Model model) throws Exception {
		List<BoardDTO> list = boardSevice.list();
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
		boardDto = boardSevice.select(boardDto);
		if (boardDto == null) {
			return "board/false";
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
		boolean result = boardSevice.delete(boardDto);
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
		boardDto = boardSevice.select(boardDto);
		model.addAttribute("boardDto",boardDto);
		return "board/updateForm";
	}
	
	// 게시판내용 수정 요청
	@PostMapping(value = "/board/update")
	public String boardUpdate(BoardDTO boardDto, Model model) throws Exception {
		if (boardDto.getBoardNo() <= 0) {
			return "board/false";
		}
		boolean result= boardSevice.update(boardDto);
		
		if (result == false) {
			return "board/false";
		}
		return "board/success";
	}



}
