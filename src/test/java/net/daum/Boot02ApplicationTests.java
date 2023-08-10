package net.daum;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.daum.dao.BoardRepostory;
import net.daum.vo.BoardVO;

@SpringBootTest
class Boot02ApplicationTests {

	@Autowired
	private BoardRepostory boardRepo;
	
	@Test
	public void testInsert20() {
		for (int i=1; i<=20;i++) {
			BoardVO b = new BoardVO();
			
			b.setWriter("user0"+(i % 10));
			b.setTitle("게시판 제목..:"+i);
			b.setContent("게시판 내용.."+i);
			
			//this.boardRepo.save(b); //게시판 저장
		}
	}//20개 샘플 레코드 저장
	
	//쿼리 메서드에서 제목으로 검색
	@Test
	public void TestByTitle() {
		//자바8 이전 방법
		/*List<BoardVO> blist = this.boardRepo.findBoardVOByTitle("게시판 제목..:17");
		
		if(blist != null && blist.size() > 0) {//검색된 레코드가 있는 경우
			for(int i=0;i<blist.size();i++) {//size()는 컬렉션 원소 개수 반환. 첫원소값은 1부터 시작
				System.out.println(blist.get(i)); //get()메서드로 원소값을 가져옴.
			}
			
		}else {
			System.out.println("검색된 레코드가 없습니다!");
		}*/ //if else
		
		//자바 8 이후 방법
		//this.boardRepo.findBoardVOByTitle("게시판 제목..:7")
		//.forEach(board -> System.out.println(board));
	}//testByTitle()
	
	@Test //글쓴이로 검색
	public void testByWriter() {
		Collection<BoardVO> blist = this.boardRepo.findByWriter("user00");
		
		blist.forEach(board -> System.out.println(board));
	}
}
