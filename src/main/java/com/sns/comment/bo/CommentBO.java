package com.sns.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.Mapper.CommentMapper;
import com.sns.comment.domain.Comment;



@Service
public class CommentBO {

	@Autowired CommentMapper commentMapper;
	public void addComment(int userId, int postId, String content) {
		commentMapper.insertComment(userId, postId, content);
	}
	
	public List<Comment> getListComment(){
		return commentMapper.selectCommentList();
	}
}
