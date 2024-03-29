package com.sns.timeline.domain;

import java.util.List;

import com.sns.comment.domain.CommentView;
import com.sns.post.entity.PostEntity;
import com.sns.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

// View용 객체
// 글 1개와 Mapping
@ToString
@Data   //가져온 Entity의 getter/setter도 가져오기
public class CardView {
	
	// 글 1개   (통으로 객체 하나하나 다 가져올수 있지만 Entity로 한꺼번에 가져오기)
		private PostEntity post;
		
	// 글쓴이 정보
	
		private UserEntity user;
	// 댓글들
	
		private List<CommentView> commentList;
		// List<comment>로 하면 안됨. comment 테이블에 userid밖에 없다
	// 좋아요 개수
		// 좋아요 개수
		private int likeCount;
		
		private boolean filledLike;
	
}
