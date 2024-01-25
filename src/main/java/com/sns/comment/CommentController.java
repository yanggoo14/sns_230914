package com.sns.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/comment")
@RestController
public class CommentController {
	@Autowired CommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("postId") int postId,
			@RequestParam("content") String Content,
			HttpSession session){
		
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인을 해주세요.");
		}
		commentBO.addComment(postId, userId, Content);
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
		@DeleteMapping("/delete")
		public Map<String, Object> delete(
				@RequestParam("commentId") int commentId,
				HttpSession session) {
			
			Map<String, Object> result = new HashMap<>();
			// 로그인 여부 확인
			Integer userId = (Integer)session.getAttribute("userId");
			if (userId == null) {
				result.put("code", 500);
				result.put("error_message", "로그인이 되지 않은 사용자 입니다.");
				return result;
			}
			
			// 삭제
			commentBO.deleteCommentById(commentId);
			
			// 응답값
			result.put("code", 200);
			result.put("result", "성공");
			
			return result;
		}
	
	
}
