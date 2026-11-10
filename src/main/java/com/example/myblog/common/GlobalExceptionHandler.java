package com.example.myblog.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

/**
 * Week08：把"业务异常"翻译成"HTTP 语义 + 统一 JSON"。
 * 没有它，NoSuchElementException 会变成 500 白页 / HTML 错误页。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 资源不存在 → 404，body 仍是 {code, message, data} */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleNotFound(NoSuchElementException e) {
        return ApiResponse.fail(404, e.getMessage());
    }

    /** 参数不合法 → 400 */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleBadRequest(IllegalArgumentException e) {
        return ApiResponse.fail(400, e.getMessage());
    }
}
