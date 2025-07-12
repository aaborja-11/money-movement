package com.aborja.moneymovement.interfaces.web.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {

    private String message;
    private List<Error> errors;

    public List<Error> addError(Error error) {
        if (error == null) {
            errors = new ArrayList<>();
        }
        errors.add(error);
        return errors;
    }

    @Data
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Error {
        private String field;
        private String message;
    }

}
