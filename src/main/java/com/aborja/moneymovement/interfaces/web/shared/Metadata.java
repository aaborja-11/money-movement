package com.aborja.moneymovement.interfaces.web.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Sort;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Metadata(int page, int size, long totalElements, int totalPages, List<SortOrder> sort) {

}
