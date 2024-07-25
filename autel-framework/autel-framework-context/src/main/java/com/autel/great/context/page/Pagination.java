package com.autel.great.context.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Used for paging display")
public class Pagination {

    @Schema(description = "The current page number.", example = "1")
    private long page;

    @Schema(description = "The amount of data displayed per page.", example = "10")
    @JsonProperty("page_size")
    private long pageSize;

    @Schema(description = "The total amount of all data.", example = "10")
    private long total;

    public Pagination() {
    }

    public Pagination(long page, long pageSize, long total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }

    public long getPage() {
        return page;
    }

    public Pagination setPage(long page) {
        this.page = page;
        return this;
    }

    public long getPageSize() {
        return pageSize;
    }

    public Pagination setPageSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public Pagination setTotal(long total) {
        this.total = total;
        return this;
    }
}
