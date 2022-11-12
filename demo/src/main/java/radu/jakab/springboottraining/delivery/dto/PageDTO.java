package radu.jakab.springboottraining.delivery.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
public class PageDTO {
    private int pageNumber;
    private int pageSize;
    private String sortColumn;
    private Sort.Direction direction;

    public PageRequest toPageRequest() {
        return PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortColumn));
    }
}
