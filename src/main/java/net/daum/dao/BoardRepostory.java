package net.daum.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.BoardVO;

public interface BoardRepostory extends CrudRepository<BoardVO, Integer> {

	List<BoardVO> findBoardVOByTitle(String string);
//<엔티티 빈클래스명, 빈클래스 유일 식별키 @Id로 변수명 자료형의 참조타입>
	
	public Collection<BoardVO> findByWriter(String writer); //쿼리메서드에서 Writer는 빈클래스 
	//의 속성인 멤버변수명 =>findBy+빈클래스 속성명 (멤버변수명) ,작성자로 검색
	
	//작성자에 대한 like % 검색어 % => '%'+검색어+'%' (Containging)
	/*
	 * like 검색 쿼리 메서드 형태
	 * 형태 		쿼리 메서드
	 * 검색어+'%' StartingWith
	 * '%'+검색어  EndingWith
	 * '%'+검색어+'%' Containing
	 */
	
	public Collection<BoardVO> findByWriterContaining(String writer);
	
	//or 조건 처리 => '%'+제목+'%' + Or +'%'+내용+'%'
	public Collection<BoardVO> findByTitleContainingOrContentContaining(String title,
			String content);
}
