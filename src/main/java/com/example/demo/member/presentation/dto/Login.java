package com.example.demo.member.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record Login(
        @Schema(description = "로그인 이메일")
        String email,
        @Schema(description = "로그인 비밀번호")
        String password) {
}
