package com.example.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.member.dao.IMemberDao;

@Controller
public class MyController {
	
	@Autowired
	private IMemberDao dao; 
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	// 전체 리스트 출력
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", dao.getList());
		return "list";
	}
	
	// detail 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam("mno") int mno, Model model) {
		model.addAttribute("dto", dao.getDto(mno));
		return "detail";
	}
	
	// writeForm 페이지
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	// write
	@RequestMapping("/write")
	public String write(@RequestParam("id") String id,@RequestParam("pw") String pw) {
		dao.write(id, pw);
		return "redirect:list";
	}
	
	// delete
	@RequestMapping("/delete")
	public String delete(@RequestParam("mno") int mno) {
		dao.delete(mno);
		return "redirect:list";
	}
	
	
	
	
	
	
}