package com.sns.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.CommentView;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;
import com.sns.timeline.domain.CardView;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;

@Service
public class TimelineBO {
	//  input:x        output: List<CardView>
	@Autowired 
	PostBO postBO;
	
	@Autowired 
	UserBO userBO;
	
	@Autowired
	CommentBO commentBO;
	public List<CardView> generateCardViewList(){
		List<CardView> cardViewList = new ArrayList<>();
		
		// 글 목록을 가져온다. List<PostEntity>
		List<PostEntity> postList = postBO.getPostList(); 
		
		// 글 목록 반복문 순회
		// 향상된 for문 사용
		
		for(PostEntity post : postList) {
			// post 하나에 대응되는 하나의 카드를 만든다. 
			CardView cardView = new CardView();
			// 글 1개
			cardView.setPost(post);
			
			// 글쓴이 정보
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			cardView.setUser(user);
			
			// 댓글들, 
			List<CommentView> commentList = commentBO.generateCommentViewListByPostId(post.getId());
			cardView.setCommentList(commentList);
			//좋아요
			
			
			
			//   ★★★★★★★★★ 마지막에 cardVㅑew를 list에 넣어야한다 ★★★★★★★★★
			cardViewList.add(cardView); 
		}
		
		// Post => CardView  => cardViewList에 넣기
		
		
	
		
		return cardViewList;
	}
}
