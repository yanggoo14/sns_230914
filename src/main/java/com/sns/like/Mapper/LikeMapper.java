package com.sns.like.Mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikeMapper {
public List<Map<String, Object>> selectLikeList();
	

	/*public int selectLikeCountByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
	*/
	public int selectLikeCountByPostId(int postId);

	// likeCount 쿼리 하나로 합치기
	
	public int SelectLikeCountByPostIdOrUserId(
			@Param("postId") int postId,
			@Param("userId") Integer userId);
	
	public void deleteLikeByPostIdUserId(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("postId") int postId,
			@Param("userId") int userId);
	
	
}
