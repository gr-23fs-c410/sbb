package com.mysite.sbb.question.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
	
	private final QuestionRepository questionRepository;

	@Override
	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	@Override
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("질문을 찾을 수 없습니다.");
		}
	}
	

}
