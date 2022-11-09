package radu.jakab.springboottraining.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {
    private int pageNumber;
    private int pageSize;
    private String sortField;
    private Sort.Direction direction;

    public PageRequest toPageRequest() {
        return PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortField));
    }
}
