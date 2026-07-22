package com.hi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hi.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
//	List<Board> findByTitleContaining(String keyword);
//	  // 내용에 키워드가 포함된 목록 찾기 
//    List<Board> findByContentContaining(String keyword); 
//    // 작성자에 키워드가 포함된 목록 찾기
//    List<Board> findByWriterContaining(String keyword);
}
