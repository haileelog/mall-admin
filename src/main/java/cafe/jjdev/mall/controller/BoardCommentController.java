package cafe.jjdev.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.service.BoardCommentService;
import cafe.jjdev.mall.vo.BoardComment;

@Controller
public class BoardCommentController {
	@Autowired private BoardCommentService boardCommentService;
	
	@PostMapping("/board/addBoardComment")
	public String addBoardComment(BoardComment boardComment) {
		int result = boardCommentService.addBoardComment(boardComment);
		return "redirect:/board/getBoard?boardNo="+boardComment.getBoardNo();
	}
	
}
