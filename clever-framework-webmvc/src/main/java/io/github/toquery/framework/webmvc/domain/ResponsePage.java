package io.github.toquery.framework.webmvc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.PagedModel;

/**
 * @author toquery
 * @version 1
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponsePage {

    private int pageSize;

    private int pageNum;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long totalElements;

    private int totalPages;

    public ResponsePage() {
    }

    public ResponsePage(ResponsePageBuilder builder) {
        this.pageSize = builder.getPageSize();
        this.pageNum = builder.getPageNum();
        this.totalElements = builder.getTotalElements();
        this.totalPages = builder.getTotalPages();
    }

    public static ResponsePageBuilder builder() {
        return new ResponsePageBuilder();
    }

    public ResponsePageBuilder newBuilder() {
        return new ResponsePageBuilder(this);
    }


}
