package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sns.common.FileManagerService;
import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostBO {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private FileManagerService fileManagerService;
	// input: X   output: List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	// input: 파라미터들   output:PostEntity
		public PostEntity addPost(int userId, String userLoginId, 
				String content, MultipartFile file) {
			
			String imagePath = null;

			// 이미지가 있으면 업로드 후 imagePath를 받아옴
			if (file != null) {
				imagePath = fileManagerService.saveFile(userLoginId, file);
			}

			return postRepository.save(PostEntity.builder()
					.userId(userId)
					.content(content)
					.imagePath(imagePath)
					.build());
		}
		public void deletePostBypostId(int postId, int userId) {
			// 기존 글 가져오기
			PostEntity post = postRepository.findById(postId).orElse(null);
			if(post == null) {
				log.info("[글 삭제] post is null. postId:{}, userId:{}", postId, userId);
				return;
			}
			
			// 글 삭제
	
			postRepository.delete(post);
			// 이미지 있으면 삭제
			
			fileManagerService.deleteFile(post.getImagePath());
			
			// 댓글들 삭제
			
			// 좋아요를 삭제
			
		
		}
}
