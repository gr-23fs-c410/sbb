package com.mysite.sbb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/question")
@RequiredArgsConstructor
@RestController
public class MainApiController {

	private final QuestionService questionService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> list(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "kw", defaultValue = "") String kw) {
		
		log.info("Questin List");
        Page<Question> paging = this.questionService.getList(page, kw);
        
        Map<String, Object> response = new HashMap<>();
        response.put("content", paging.getContent());
        response.put("currentPage", paging.getNumber());
        response.put("totalItems", paging.getTotalElements());
        response.put("totalPages", paging.getTotalPages());
        
		return ResponseEntity.ok(response);
	}
}
