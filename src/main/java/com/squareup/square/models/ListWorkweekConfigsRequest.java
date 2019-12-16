package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ListWorkweekConfigsRequest {

    @JsonCreator
    public ListWorkweekConfigsRequest(
            @JsonProperty("limit") Integer limit,
            @JsonProperty("cursor") String cursor) {
        this.limit = limit;
        this.cursor = cursor;
    }

    private final Integer limit;
    private final String cursor;

    @Override
    public int hashCode() {
        return Objects.hash(limit, cursor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ListWorkweekConfigsRequest)) {
            return false;
        }
        ListWorkweekConfigsRequest listWorkweekConfigsRequest = (ListWorkweekConfigsRequest) o;
        return Objects.equals(limit, listWorkweekConfigsRequest.limit) &&
            Objects.equals(cursor, listWorkweekConfigsRequest.cursor);
    }

    /**
     * Getter for Limit.
     * Maximum number of Workweek Configs to return per page.
     */
    @JsonGetter("limit")
    public Integer getLimit() { 
        return this.limit;
    }

    /**
     * Getter for Cursor.
     * Pointer to the next page of Workweek Config results to fetch.
     */
    @JsonGetter("cursor")
    public String getCursor() { 
        return this.cursor;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .limit(getLimit())
            .cursor(getCursor());
            return builder;
    }

    public static class Builder {
        private Integer limit;
        private String cursor;

        public Builder() { }

        public Builder limit(Integer value) {
            limit = value;
            return this;
        }
        public Builder cursor(String value) {
            cursor = value;
            return this;
        }

        public ListWorkweekConfigsRequest build() {
            return new ListWorkweekConfigsRequest(limit,
                cursor);
        }
    }
}
