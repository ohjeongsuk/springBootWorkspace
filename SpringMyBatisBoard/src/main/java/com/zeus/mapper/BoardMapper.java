package com.zeus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zeus.domain.Board;

public interface BoardMapper {
	public int insert(Board board) throws Exception;
	public Board select(Board board) throws Exception;
	public int update(Board board) throws Exception;
	public int delete(Board board) throws Exception;
	public List<Board> list() throws Exception;
	//@param xml 매핑파일에 저바 메소드가 피라미터를 명확하게 전달하기 위해 이름을 지정해주는 역할
	//#{title} 접근해야함.
	public List<Board> search(@Param("title") String title) throws Exception;
}
