package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.Comment;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;

@Controller
public class TimelineController {
	@Autowired
	private PostBO postBO;
	
	@Autowired 
	private CommentBO commentBO;
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model) {
		
		// 글 목록 조회 (CardView를 가져오면서 밑에 안써도 됨)
		//List<PostEntity> postList = postBO.getPostList();
		//List<Comment> commentList = commentBO.getListComment();
		
		//model.addAttribute("postList", postList);
		//model.addAttribute("commentList", commentList);
		model.addAttribute("viewName", "timeline/timeline");
		
		return "template/layout";
	}
}
