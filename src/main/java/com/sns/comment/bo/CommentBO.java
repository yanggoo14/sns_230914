package com.sns.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.Mapper.CommentMapper;
import com.sns.comment.domain.Comment;
import com.sns.comment.domain.CommentView;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;



@Service
public class CommentBO {
	
	
	@Autowired CommentMapper commentMapper;

	@Autowired 
	private UserBO userBO;
	public void addComment(int userId, int postId, String content) {
		commentMapper.insertComment(userId, postId, content);
	}
	
	public List<Comment> getListComment(){
		return commentMapper.selectCommentList();
	}
	public List<CommentView> generateCommentViewListByPostId(int postId){
		//결과 리스트만들기
		List<CommentView> commentViewList = new ArrayList<>();
		//글에 해당하는 댓글 목록 가져오기 List<Comment>
		List<Comment> commentList = commentMapper.selectCommentListByPostId(postId);
		// 반복문 순회 Comment -> CommentView => 리스트에 넣기
		for(Comment commet : commentList) {
			CommentView commentView = new CommentView();
			
			// 댓글1개
			commentView.setComment(commet);
			
			// 댓글쓴이
			UserEntity user = userBO.getUserEntityById(commet.getUserId());
			commentView.setUser(user);
			// 결과 리스트 담기
			commentViewList.add(commentView);
		}
		// 결과 리스트 리턴
		return commentViewList;
	}
	public void deleteCommentById(int id) {
		commentMapper.deleteCommentById(id);
	}
}
