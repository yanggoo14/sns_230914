package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.Mapper.LikeMapper;

@Service
public class LikeBO {
	@Autowired
	private LikeMapper likeMapper;
	
	// input:postId, userId     output: X
	public void likeToggle(int postId, int userId) {
		if (likeMapper.SelectLikeCountByPostIdOrUserId(postId, userId) > 0) {
			// 있으면 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else {
			// 없으면 추가
			likeMapper.insertLike(postId, userId);
		}
	}
	
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostId(postId);
	}
	
	public int getLikeCountByPostIdUserId(int postId, int userId) {
		return likeMapper.SelectLikeCountByPostIdOrUserId(postId, userId);
	}
	
	// input: postId, userId (null or)    output : boolean
	public boolean getLikeCountByPostIdUserId(int postId, Integer userId) {
		if(userId == null) {
			return false;	// 비로그인이면 무조건 빈하트 => false 	
		}
		 // 로그인이 0보다 크면(1이면) 채운다, 그렇지 않으면 false
		return likeMapper.SelectLikeCountByPostIdOrUserId(postId, userId) > 0;
	}
}
