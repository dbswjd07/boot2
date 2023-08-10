package net.daum;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;  


import net.daum.dao.BoardRepostory;
import net.daum.vo.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

		@Autowired //자동 의존성 주입
		private BoardRepostory boardRepo;
		
		@Test
		public void testInsertBoard() {
			BoardVO board = new BoardVO();
			
			board.setWriter("홍길동");
			board.setTitle("게시판 제목입니다.");
			board.setContent("게시판 내용입니다.");
			
			this.boardRepo.save(board); //게시판 저장
		}//게시판에 자료 저장(tbl_boards2 테이블)
		
		@Test
		public void testReadBoard() {
			Optional<BoardVO> b = this.boardRepo.findById(2);
			System.out.println(b.toString()); //.toString() 메서드 생략 가능함
		}//게시판 읽기
		
		@Test
		public void testUpdateBoard() {
			Optional<BoardVO> eb = this.boardRepo.findById(2); //2번 레코드 검색
			
			eb.ifPresent(ebBoard -> {
				ebBoard.setWriter("수정홍길동");
				ebBoard.setTitle("수정 게시판 제목입니다.");
				ebBoard.setContent("수정 게시판 내용입니다.");
				
				System.out.println("2번 레코드의 작성자, 제목, 내용을 수정 => ");
				this.boardRepo.save(ebBoard); //게시판 수정
				
			});
		}//게시판 수정
		
		//1번 레코드 삭제
		@Test
		public void testDelBoard() {
			System.out.println("JPA 엔티티빈 레코드 삭제");
			boardRepo.deleteById(1);
		}
}
