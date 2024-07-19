package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import com.mysite.sbb.user.SiteUser;

public interface QuestionService {
	
	public List<Question> getList();
	public Question getQuestion(Integer id);
	public void create(String subject, String content, SiteUser user);
	public Page<Question> getList(int page, String kw);
	public void modify(Question question, String subject, String content);
	public void delete(Question question);
	public void vote(Question question, SiteUser siteUser);
	
}
