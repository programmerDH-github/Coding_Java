package com.bside.BSIDE.contents.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bside.BSIDE.contents.domain.CountAnsweredQuestionsByMonthDto;
import com.bside.BSIDE.contents.domain.PagedResponse;
import com.bside.BSIDE.contents.domain.QuestionAndAnswerDto;
import com.bside.BSIDE.contents.domain.QuestionCountDto;
import com.bside.BSIDE.contents.domain.QuestionDto;
import com.bside.BSIDE.service.AnswerService;
import com.bside.BSIDE.service.QuestionService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @QuestionController
 * @작성자 DongHun
 * @일자 2023.04.23.
 **/

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	public QuestionController(QuestionService questionService, AnswerService answerService) {
		this.questionService = questionService;
		this.answerService = answerService;
	}

	/* 질문 저장 */
	@PostMapping("/insertQuestion")
	@Operation(summary = "질문 저장")
	public ResponseEntity<Void> createQuestion(@RequestBody QuestionDto questionDto) {
		questionService.insertQuestion(questionDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/unanswered")
	@Operation(summary = "금일 답변하지 않은 개수 조회")
	public ResponseEntity<Integer> countUnansweredQuestionsToday(@RequestParam("writer") String writer) {
		Integer count = 3 - questionService.countUnansweredQuestions(writer)
				- questionService.countPassQuestions(writer);
		System.out.println("사용자가 아직 답변하지 않은 질문은 " + questionService.countUnansweredQuestions(writer) + "개입니다.");
		System.out.println("사용자가 답변하지 않겠다고 넘긴 질문은 " + questionService.countPassQuestions(writer) + "개입니다.");
		return ResponseEntity.ok(count);
	}

	/* 이번달에 답변한 질문 개수 조회 */
	@GetMapping("/answered/month")
	@Operation(summary = "이번달에 답변한 질문 개수 조회")
	public ResponseEntity<Integer> countAnsweredQuestionsThisMonth(@RequestParam("writer") String writer) {
		Integer count = questionService.countAnsweredQuestionsThisMonth(writer);
		String message = String.format("이번 달에 답변한 질문 개수는 " + count + "개 입니다.");
		System.out.println(message);
		return ResponseEntity.ok(count);
	}

	/* 오늘 답변한 질문 개수 조회 */
	@GetMapping("/answered/day")
	@Operation(summary = "오늘 답변한 질문 개수 조회")
	public ResponseEntity<Integer> countAnsweredQuestionsToday(@RequestParam("writer") String writer) {
		Integer count = questionService.countAnsweredQuestionsToday(writer);
		String message = String.format("오늘 답변한 질문 개수는 " + count + "개 입니다.");
		System.out.println(message);
		return ResponseEntity.ok(count);
	}

	/* 선택한 월에 답변한 질문 개수 조회 */
	@GetMapping("/answeredCount/{email}/{year}/{month}")
	@Operation(summary = "선택한 월에 답변한 질문 개수 조회")
	public ResponseEntity<CountAnsweredQuestionsByMonthDto> countAnsweredQuestionsByMonth(@PathVariable String email,
			@PathVariable int year, @PathVariable int month) {
		CountAnsweredQuestionsByMonthDto dto = questionService.countAnsweredQuestionsByMonth(email, year, month);
		return ResponseEntity.ok(dto);
	}

	/* 선택한 일에 답변한 질문 개수 조회 */
	@GetMapping("/answeredCount/{email}/{date}")
	@Operation(summary = "선택한 일에 답변한 질문 개수 조회")
	public ResponseEntity<?> countAnsweredQuestionsByDay(@PathVariable String email, @PathVariable String date) {
		String[] dateArr = date.split("-");

		/* YYYY-MM-DD 입력했을 경우 */
		if (dateArr.length == 3) {
			int count = questionService.countAnsweredQuestionsByDay(email, date);
			return ResponseEntity.ok(count);
		}
		/* YYYY-MM-DD 입력하지 않은 경우 */
		else {
			return ResponseEntity.ok("YYYY-MM-DD 의 형식으로 정확하게 입력해주세요.");
		}
	}

	/* 선택한 월에 답변한 개수를 일별로 조회 */
	@GetMapping("/answeredCountDatesInMonth/{email}/{date}")
	@Operation(summary = "선택한 월에 답변한 개수를 일별로 조회")
	public ResponseEntity<?> countAnsweredDatesInMonth(@PathVariable String email, @PathVariable String date) {
		String[] dateArr = date.split("-");

		/* YYYY-MM-DD 입력했을 경우 */
		if (dateArr.length == 2) {
			List<QuestionCountDto> dto = questionService.countAnsweredDatesInMonth(email, date + "-01");
			return ResponseEntity.ok(dto);
		}
		/* YYYY-MM-DD 입력하지 않은 경우 */
		else {
			return ResponseEntity.ok("YYYY-MM 의 형식으로 정확하게 입력해주세요.");
		}
	}

	/* 선택한 월에 답변한 질문 조회 */
	@GetMapping("/answered/{email}/{date}")
	@Operation(summary = "선택한 월에 답변한 질문 조회")
	public ResponseEntity<?> getQuestionsAndAnswersByMonthAndEmail(@PathVariable String email,
			@PathVariable String date, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "15") int size) {

		List<QuestionAndAnswerDto> questionAndAnswers;
		String[] dateArr = date.split("-");

		/* YYYY 입력했을 경우 */
		if (dateArr.length == 1) {
			return ResponseEntity.ok("YYYY-MM 의 형식 또는 YYYY-MM-DD 의 형식으로 입력해주세요.");
		}
		/* YYYY-MM 입력했을 경우 */
		else if (dateArr.length == 2) {
			questionAndAnswers = questionService.getQuestionsAndAnswersByMonthAndEmail(email, date + "-01");
		}
		/* YYYY-MM-DD 입력했을 경우 */
		else {
			questionAndAnswers = questionService.getQuestionsAndAnswersByDayAndEmail(email, date);
		}

		if (questionAndAnswers.isEmpty()) {
			ResponseEntity.ok("선택한 날짜의 값이 존재하지 않습니다.");
		}

		// 페이징 처리를 위한 Pageable 생성
		int totalElements = questionAndAnswers.size();
		int totalPages = (int) Math.ceil((double) totalElements / size);
		int currentPage = Math.min(Math.max(1, page), totalPages);
		int startIndex = (currentPage - 1) * size;
		int endIndex = Math.min(startIndex + size, totalElements);

		// 해당 페이지에 맞게 데이터 분할
		List<QuestionAndAnswerDto> pageContent = questionAndAnswers.subList(startIndex, endIndex);

		// PagedResponse 객체 생성
		PagedResponse<QuestionAndAnswerDto> pagedResponse = new PagedResponse<>(pageContent, currentPage, size,
				totalElements);

		return ResponseEntity.ok(pagedResponse);
	}
}
