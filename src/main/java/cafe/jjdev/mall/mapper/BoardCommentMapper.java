package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;

@Mapper
public interface BoardCommentMapper {
	public int insertBoardComment(BoardComment boardComment);
	public List<BoardComment> selectBoardCommentListByBoardNo(int boardNo);
	
	//댓글 하나만 삭제하기
	public int deleteBoardCommentByCommentNo(int boardCommentNo);
	//댓글 전체를 삭제하기
	public int deleteBoardCommentByBoardNo(int boardNo);

}
