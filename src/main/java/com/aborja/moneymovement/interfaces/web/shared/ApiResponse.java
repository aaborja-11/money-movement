package com.aborja.moneymovement.interfaces.web.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private T data;
    private Metadata metadata;

    public static <S, T> ApiResponse<T> create(T data, Metadata metadata) {
        return new ApiResponse<>(data, metadata);
    }

    public static <S, T> ApiResponse<T> create(T data) {
        return new ApiResponse<>(data, null);
    }

}
