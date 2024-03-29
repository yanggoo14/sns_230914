package com.sns.comment.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sns.comment.domain.Comment;
import com.sns.comment.domain.CommentView;

@Mapper
public interface CommentMapper {
	public void insertComment(
			@Param("userId") int userId,
			@Param("postId") int postId,
			@Param("content") String content); 
		
	public List<Comment> selectCommentList();	
	
	public List<Comment> selectCommentListByPostId(int postId);
	
	public void deleteCommentById(int id);
}
