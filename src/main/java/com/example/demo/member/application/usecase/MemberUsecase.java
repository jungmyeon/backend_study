package com.example.demo.member.application.usecase;

import com.example.demo.member.application.dto.MemberCreateCommand;
import com.example.demo.member.application.dto.MemberLogin;
import com.example.demo.member.application.dto.MemberResQuery;
import com.example.demo.member.application.dto.Token;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface MemberUsecase {
    MemberResQuery join(MemberCreateCommand createdCommand);
    Token login(MemberLogin memberLogin) throws Exception;
    Token refreshToken(String refreshToken) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
