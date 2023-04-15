package com.bside.BSIDE.test;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    @Operation(summary = "Hello API", description = "Hello, World!를 반환하는 API")
    @ApiResponse(responseCode = "200", description = "요청이 성공적으로 처리되었습니다.", content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE, schema = @Schema(type = "string")))
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, World!");
    }

}