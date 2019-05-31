package cafe.jjdev.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.service.BoardService;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardRequest;

@Controller
public class BoardController {
	@Autowired private BoardService boardService;
	//----------------------------addBoard시작----------------------------
	//폼
	@GetMapping("/board/addBoard")
	public String addBoard() {		
		return "/board/addBoard";
	}
	//액션
	@PostMapping("/board/addBoard")
	public String addBoard(BoardRequest boardRequest) {
		//String path = ServletUriComponentsBuilder.fromCurrentContextPath().path("upload").toUriString();

		// ServletUriComponentsBuilder.fromCurrentContextPath() 
		//                        == request.getContextPath() <- HttpServlet request도 필요함
		boardService.addBoard(boardRequest, PathStr.UPLOAD_PATH);
		return "redirect:/board/getBoardList";
	}
	//----------------------------addBoard시작----------------------------
	
	//----------------------------removeBoard시작----------------------------
	//폼
	@GetMapping("/board/removeBoard")
	public String removeBoard(Model model
							, @RequestParam(value="boardNo", required=true) int boardNo) {
		model.addAttribute("boardNo", boardNo);
		return "/board/removeBoard";
	}
	//액션(no, pw 둘 다 받아야하므로 command객체로 받기)
	@PostMapping("/board/removeBoard")
	public String removeBoard(Board board) {
		boardService.removeBoard(board);
		return "redirect:/board/getBoardList";				
		
	}
	//-----------------------------removeBoard끝---------------------------
	
	//-----------------------------removeBoardComment 시작---------------------------
	//액션
	@PostMapping("/board/removeBoardComment")
	public String removeBoardComment(BoardComment boardComment) {
		boardService.removeBoardByBoardCommentNo(boardComment);
		return "redirect:/board/getBoard?boardNo="+boardComment.getBoardNo();
	}
	//-----------------------------removeBoardComment끝---------------------------
		
	//---------------------------- modifyBoard 시작---------------------
	//폼
	@GetMapping("/board/modifyBoard")
	public String modifyBoard(Model model
							, @RequestParam(value="boardNo", required=true) int boardNo) {
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("board", board);
		return "/board/modifyBoard";
	}
	//액션
	@PostMapping("/board/modifyBoard")
	public String ModifyBoard(Board board) {
		boardService.modifyBoard(board);	
		return "redirect:/board/getBoard?boardNo="+board.getBoardNo();
	}
	//---------------------------- modifyBoard 끝---------------------
	
	//---------------------------getBoard (글, 댓글) 시작-------------------------------
	@GetMapping("/board/getBoard")
	public String getBoard(Model model
						, @RequestParam(value="boardNo", required=true) int boardNo) {
		Map<String, Object> map = boardService.getBoardAndCommentListAndFileList(boardNo);
				
		model.addAttribute("board", map.get("board"));		
		model.addAttribute("boardCommentList", map.get("boardCommentList"));
		model.addAttribute("boardFileList", map.get("boardFileList"));
		return "/board/getBoard";
	}
	//-----------------------------getBoard (글, 댓글) 끝---------------------------
	
	//------------------------------getBoardList(리스트/페이징처리) 시작--------------------------------
	@GetMapping("/board/getBoardList")
	public String getBoardList(Model model, @RequestParam(value="currentPage", required=false, defaultValue = "1") int currentPage) {   // 원래는 currentPage 받아와서 int로 형변환하고... 
		Map<String, Object> map = boardService.getBoardList(currentPage);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("boardCount", map.get("boardCount"));
		model.addAttribute("currentPage", currentPage);		
		return "/board/getBoardList";
		
	}
	//------------------------------getBoardList(리스트/페이징처리) 끝--------------------------------
	
	
	

}
