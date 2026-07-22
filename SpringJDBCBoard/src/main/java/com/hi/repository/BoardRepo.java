package com.hi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hi.domain.Board;


@Repository
public class BoardRepo {
	
	//JDBC 템플릿
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insert(Board board) throws Exception {
		String query = "INSERT INTO board(boardNo,title,writer,content)"
				       + " VALUES(board_seq.nextval,?,?,?)";
		//jdbcTemplate (update,insert,delete) => jdbcTemplate.update(query,~~)
		int count =	jdbcTemplate.update(query, board.getTitle(),board.getWriter(),board.getContent());
		return (count == 0)?(false):(true);
	}

	
	public Board select(Board board) throws Exception {
		String query = "SELECT * FROM board WHERE boardno = ?";
		
		List<Board> list = jdbcTemplate.query(query, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARDNO"));
				board.setContent(rs.getString("CONTENT"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REGDATE"));
				return board;
			}
		}, board.getBoardNo());
		
		return (list.isEmpty() == true)?(null):(list.get(0));
	}

	
	public boolean update(Board board) throws Exception {
		String query = "UPDATE board SET title = ?, content = ?, writer = ? WHERE boardno = ?";
		int count = jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter(),board.getBoardNo());
		return (count == 0)?(false):(true);
	}

	
	public boolean delete(Board board) throws Exception {
		String query = "DELETE FROM board WHERE boardno = ?";
		int count =	jdbcTemplate.update(query, board.getBoardNo());
		return (count == 0)?(false):(true);
	}

	
	public List<Board> list() throws Exception {
		String query = "SELECT * FROM board WHERE boardno > 0 ORDER BY regdate desc";
		
		List<Board> list = jdbcTemplate.query(query, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARDNO"));
				board.setContent(rs.getString("CONTENT"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REGDATE"));
				return board;
			}
		});
		return list;
	}
}
