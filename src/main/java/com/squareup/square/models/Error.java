package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class Error {

    @JsonCreator
    public Error(
            @JsonProperty("category") String category,
            @JsonProperty("code") String code,
            @JsonProperty("detail") String detail,
            @JsonProperty("field") String field) {
        this.category = category;
        this.code = code;
        this.detail = detail;
        this.field = field;
    }

    private final String category;
    private final String code;
    private final String detail;
    private final String field;

    @Override
    public int hashCode() {
        return Objects.hash(category, code, detail, field);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Error)) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(category, error.category) &&
            Objects.equals(code, error.code) &&
            Objects.equals(detail, error.detail) &&
            Objects.equals(field, error.field);
    }

    /**
     * Getter for Category.
     * Indicates which high-level category of error has occurred during a
     * request to the Connect API.
     */
    @JsonGetter("category")
    public String getCategory() { 
        return this.category;
    }

    /**
     * Getter for Code.
     * Indicates the specific error that occurred during a request to a
     * Square API.
     */
    @JsonGetter("code")
    public String getCode() { 
        return this.code;
    }

    /**
     * Getter for Detail.
     * A human-readable description of the error for debugging purposes.
     */
    @JsonGetter("detail")
    public String getDetail() { 
        return this.detail;
    }

    /**
     * Getter for Field.
     * The name of the field provided in the original request (if any) that
     * the error pertains to.
     */
    @JsonGetter("field")
    public String getField() { 
        return this.field;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(category,
            code)
            .detail(getDetail())
            .field(getField());
            return builder;
    }

    public static class Builder {
        private String category;
        private String code;
        private String detail;
        private String field;

        public Builder(String category,
                String code) {
            this.category = category;
            this.code = code;
        }

        public Builder category(String value) {
            category = value;
            return this;
        }
        public Builder code(String value) {
            code = value;
            return this;
        }
        public Builder detail(String value) {
            detail = value;
            return this;
        }
        public Builder field(String value) {
            field = value;
            return this;
        }

        public Error build() {
            return new Error(category,
                code,
                detail,
                field);
        }
    }
}
