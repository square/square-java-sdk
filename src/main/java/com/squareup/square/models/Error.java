
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;


/**
 * This is a model class for Error type.
 */
public class Error {
    private final String category;
    private final String code;
    private final String detail;
    private final String field;

    /**
     * Initialization constructor.
     * @param category String value for category.
     * @param code String value for code.
     * @param detail String value for detail.
     * @param field String value for field.
     */
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

    /**
     * Getter for Category.
     * Indicates which high-level category of error has occurred during a request to the Connect
     * API.
     * @return Returns the String
     */
    @JsonGetter("category")
    public String getCategory() {
        return this.category;
    }

    /**
     * Getter for Code.
     * Indicates the specific error that occurred during a request to a Square API.
     * @return Returns the String
     */
    @JsonGetter("code")
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for Detail.
     * A human-readable description of the error for debugging purposes.
     * @return Returns the String
     */
    @JsonGetter("detail")
    public String getDetail() {
        return this.detail;
    }

    /**
     * Getter for Field.
     * The name of the field provided in the original request (if any) that the error pertains to.
     * @return Returns the String
     */
    @JsonGetter("field")
    public String getField() {
        return this.field;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(category, code, detail, field);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Error)) {
            return false;
        }
        Error other = (Error) obj;
        return Objects.equals(category, other.category)
            && Objects.equals(code, other.code)
            && Objects.equals(detail, other.detail)
            && Objects.equals(field, other.field);
    }

    /**
     * Builds a new {@link Error.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Error.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(category,
            code)
            .detail(getDetail())
            .field(getField());
        return builder;
    }

    /**
     * Class to build instances of {@link Error}.
     */
    public static class Builder {
        private String category;
        private String code;
        private String detail;
        private String field;

        /**
         * Initialization constructor.
         * @param category String value for category.
         * @param code String value for code.
         */
        public Builder(String category,
                String code) {
            this.category = category;
            this.code = code;
        }

        /**
         * Setter for category.
         * @param category String value for category.
         * @return Builder
         */
        public Builder category(String category) {
            this.category = category;
            return this;
        }

        /**
         * Setter for code.
         * @param code String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Setter for detail.
         * @param detail String value for detail.
         * @return Builder
         */
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        /**
         * Setter for field.
         * @param field String value for field.
         * @return Builder
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }

        /**
         * Builds a new {@link Error} object using the set fields.
         * @return {@link Error}
         */
        public Error build() {
            return new Error(category,
                code,
                detail,
                field);
        }
    }
}
