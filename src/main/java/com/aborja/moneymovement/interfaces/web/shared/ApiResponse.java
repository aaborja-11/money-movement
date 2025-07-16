package com.aborja.moneymovement.interfaces.web.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> extends ResponseEntity<ResponseBody<T>> {

    public ApiResponse(T body, HttpStatus status) {
        super(new ResponseBody<>(body), status);
    }

    public ApiResponse(Page<T> body, HttpStatus status) {
        super(new ResponseBody<>(body), status);
    }

    public static <S, T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(data, HttpStatus.CREATED);
    }

    public static <S, T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, HttpStatus.OK);
    }

    public static <S, T> ApiResponse<T> success(Page<T> data) {
        return new ApiResponse<>(data, HttpStatus.OK);
    }

    public static <S, T> ApiResponse<T> badRequest(T data) {
        return new ApiResponse<>(data, HttpStatus.BAD_REQUEST);
    }

    public static <S, T> ApiResponse<T> notFound(T data) {
        return new ApiResponse<>(data, HttpStatus.NOT_FOUND);
    }

    public static <S, T> ApiResponse<T> unauthorized(T data) {
        return new ApiResponse<>(data, HttpStatus.UNAUTHORIZED);
    }

}
