package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;

public interface QuestionService {
	
	public List<Question> getList();
	public Question getQuestion(Integer id);
	public void create(String subject, String content);
	public Page<Question> getList(int page);
}
