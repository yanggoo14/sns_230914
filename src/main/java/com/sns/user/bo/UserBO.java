package com.sns.user.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.user.entity.UserEntity;
import com.sns.user.repository.UserRepository;

@Service
public class UserBO {
	@Autowired
	private UserRepository userRepository;
	
	// input:loginId     output:UserEntity(null이거나 entity)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	// input:4개 파라미터      output:id(pk)
	public Integer addUser(String loginId, String password, String name, String email) {
		// UserEntity = save(UserEntity);
		UserEntity userEntity = userRepository.save(
				UserEntity.builder()
					.loginId(loginId)
					.password(password)
					.name(name)
					.email(email)
					.build());
			
		return userEntity == null ? null : userEntity.getId();
	}
	
	// input: loginId, password
	// output: UserEntity
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
	// cardview에 들어가는
	// input: userid     output: UserEntity
	public UserEntity getUserEntityById(int id) {
		return userRepository.findById(id).orElse(null); // optional 에러를 안나게하려면
	}
	
}
