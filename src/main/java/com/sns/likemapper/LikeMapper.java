package com.sns.likemapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
	
	public List<Map<String, Object>> selectLikeList();
}