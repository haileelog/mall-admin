package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.BoardFile;

@Mapper
public interface BoardFileMapper {
	// 첨부파일 업로드
	public int insertBoardFile(BoardFile boardFile);
	//첨부파일(여러개) 화면에 보여주기
	public List<BoardFile> selectBoardFileListByBoardNo(int boardNo);
	
	// 첨부파일 전체 삭제하기
	public int deleteBoardFileListByBoardNo(int boardNo);

}
