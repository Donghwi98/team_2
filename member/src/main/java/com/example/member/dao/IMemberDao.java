package com.example.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.member.dto.MemberDto;

@Mapper
public interface IMemberDao {

	public List<MemberDto> getList();
	public MemberDto getDto(@Param("mno")int mno);
	public void write(MemberDto member);
	public void delete(@Param("mno")int mno);
	
}
