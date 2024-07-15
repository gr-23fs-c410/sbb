package com.mysite.sbb.question;

import java.util.List;

public interface QuestionService {
	
	public List<Question> getList();
	public Question getQuestion(Integer id);

}
