package com.aborja.moneymovement.interfaces.web.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseBody<T>(T data, Metadata metadata) {

    public ResponseBody(T data) {
        this(data, null);
    }

    public ResponseBody(Page<T> data) {
        this((T) data.stream().toList(),
            new Metadata(
                data.getNumber(),
                data.getNumberOfElements(),
                data.getTotalElements(),
                data.getTotalPages(),
                data.getSort().toList().stream()
                    .map(sort -> new SortOrder(sort.getDirection().name(), sort.getProperty())).toList()));
    }

}
