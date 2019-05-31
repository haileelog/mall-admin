package cafe.jjdev.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cafe.jjdev.mall.commons.PathStr;
import cafe.jjdev.mall.mapper.BoardCommentMapper;
import cafe.jjdev.mall.mapper.BoardFileMapper;
import cafe.jjdev.mall.mapper.BoardMapper;
import cafe.jjdev.mall.vo.Board;
import cafe.jjdev.mall.vo.BoardComment;
import cafe.jjdev.mall.vo.BoardFile;
import cafe.jjdev.mall.vo.BoardRequest;

@Service
@Transactional
public class BoardService {
	@Autowired private BoardMapper boardMapper;
	@Autowired private BoardCommentMapper boardCommentMapper;
	@Autowired private BoardFileMapper boardFileMapper;
	
	// 댓글리스트
	public Map<String, Object> getBoardAndCommentListAndFileList(int boardNo) {
		// 1. 보드리스트
		Board board = boardMapper.selectBoard(boardNo);
		// 2. 댓글리스트
		List<BoardComment> boardCommentList = boardCommentMapper.selectBoardCommentListByBoardNo(boardNo);
		// 3. 첨부파일리스트
		List<BoardFile> boardFileList = boardFileMapper.selectBoardFileListByBoardNo(boardNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board", board);
		map.put("boardCommentList", boardCommentList);		
		map.put("boardFileList", boardFileList);
		return map;
	}
	
	// 리스트 , 페이징처리
	public Map<String, Object> getBoardList(int currentPage){
		// currentPage를 바로 쓸 수 없으므로 요청 가공해줘야함
		final int ROW_PER_PAGE = 10;
		final int beginRow = (currentPage-1)*ROW_PER_PAGE;
		
		// selectBoardList가 하나의 값만 받으므로 map사용해준다
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		// Mapper 메서드 2개 호출 -> 쿼리 2번 호출
		List<Board> list = boardMapper.selectBoardList(map);
		int boardCount = boardMapper.selectBoardCount();
		int lastPage = boardCount/ROW_PER_PAGE;
		if(boardCount%ROW_PER_PAGE !=0) {
			lastPage++;
		}
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("boardCount", boardCount);		
		return returnMap;
	}
	
	// 수정
	public int modifyBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
	// 글작성
	public void addBoard(BoardRequest boardRequest, String path) {
		
		// 1. BoardRequest -> Board
		Board board = new Board();
		board.setBoardTitle(boardRequest.getBoardTitle());
		board.setBoardPw(boardRequest.getBoardPw());
		board.setBoardContent(boardRequest.getBoardContent());
		board.setBoardUser(boardRequest.getBoardUser());
		System.out.println("[BoardService.addBoard] board : "+ board);
		
		boardMapper.insertBoard(board);  // board.setBoardNo(실제 insert되었던 autoincrement값);
		
		// 2. BoardRequest -> MultipartFile -> BoardFile
		List<MultipartFile> multipartFile = boardRequest.getBoardFile();
		System.out.println("[BoardService.addBoard] multipartFile : "+ multipartFile);
			for(int m=0; m<multipartFile.size(); m++) {
				MultipartFile multiFile = multipartFile.get(m);
				
				if(multiFile.getSize() > 0) {
					String contentType = multiFile.getContentType();
					String name = multiFile.getName();
					String originalFileName = multiFile.getOriginalFilename();
					long size = multiFile.getSize();
					System.out.println("contentType : "+contentType);
					System.out.println("name : "+name);
					System.out.println("originalFileName : "+originalFileName);
					System.out.println("size : "+size);
				
					// abc.hwp <- UUID 이용하기
					int i = originalFileName.lastIndexOf(".");
					String originName = originalFileName.substring(0,i);
					String ext = originalFileName.substring(i+1).toLowerCase();
					UUID uuid = UUID.randomUUID();
					String saveName = uuid.toString();
				
					BoardFile boardFile = new BoardFile();
					boardFile.setBoardFileSize(multiFile.getSize());
					boardFile.setBoardFileType(multiFile.getContentType());
					boardFile.setBoardFileOriginName(originName);
					boardFile.setBoardFileSaveName(saveName);
					boardFile.setBoardFileExt(ext);
				    boardFile.setBoardNo(board.getBoardNo());
					System.out.println("[BoardService.addBoard] boardNo : "+ board.getBoardNo());
					System.out.println("[BoardService.addBoard] boardFile : "+ boardFile);
			
					boardFileMapper.insertBoardFile(boardFile);
					
					// 3. 서버폴더에 파일 저장 
					File file = new File(path+"/"+saveName+"."+ext);  // 빈파일
					
					try {
						multiFile.transferTo(file);
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException();
					} 
				}
			}
	}
	
	// 글삭제 및 댓글전체삭제
	public void removeBoard(Board board) {
		// 1. 댓글 전체 삭제
		boardCommentMapper.deleteBoardCommentByBoardNo(board.getBoardNo());		
		
		// 2. 첨부파일 삭제
		List<BoardFile> fileList = boardFileMapper.selectBoardFileListByBoardNo(board.getBoardNo());

		for(int i=0; i<fileList.size(); i++) {
			BoardFile boardFile = fileList.get(i);
			
			String saveName = boardFile.getBoardFileSaveName();
			String ext = boardFile.getBoardFileExt();
			System.out.println("[fileList saveName] : "+saveName);
			System.out.println("[fileList ext] : "+ext);
			
			File file = new File(PathStr.UPLOAD_PATH+"/"+saveName+"."+ext);
			System.out.println("[ 삭제파일 file] : "+file);
			file.delete();
			
			boardFileMapper.deleteBoardFileListByBoardNo(board.getBoardNo());
		}
		// 3. 게시글 삭제
		boardMapper.deleteBoard(board);
		
	}
	
	// 댓글하나 삭제
	public void removeBoardByBoardCommentNo(BoardComment boardComment) {
		int deleteCommentResult = boardCommentMapper.deleteBoardCommentByCommentNo(boardComment.getBoardCommentNo());
	}
	
	// 선택
	public Board getBoard(int boardNo) {
		return boardMapper.selectBoard(boardNo);
	}
}
