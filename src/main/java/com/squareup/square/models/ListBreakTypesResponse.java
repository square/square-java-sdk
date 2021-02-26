
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListBreakTypesResponse type.
 */
public class ListBreakTypesResponse {
    private HttpContext httpContext;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<BreakType> breakTypes;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String cursor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  breakTypes  List of BreakType value for breakTypes.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListBreakTypesResponse(
            @JsonProperty("break_types") List<BreakType> breakTypes,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.breakTypes = breakTypes;
        this.cursor = cursor;
        this.errors = errors;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakTypes.
     * A page of `BreakType` results.
     * @return Returns the List of BreakType
     */
    @JsonGetter("break_types")
    public List<BreakType> getBreakTypes() {
        return breakTypes;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next next page of Break Type results.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breakTypes, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListBreakTypesResponse)) {
            return false;
        }
        ListBreakTypesResponse other = (ListBreakTypesResponse) obj;
        return Objects.equals(breakTypes, other.breakTypes)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListBreakTypesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListBreakTypesResponse [" + "breakTypes=" + breakTypes + ", cursor=" + cursor
                + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListBreakTypesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBreakTypesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .breakTypes(getBreakTypes())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListBreakTypesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<BreakType> breakTypes;
        private String cursor;
        private List<Error> errors;



        /**
         * Setter for httpContext.
         * @param  httpContext  HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for breakTypes.
         * @param  breakTypes  List of BreakType value for breakTypes.
         * @return Builder
         */
        public Builder breakTypes(List<BreakType> breakTypes) {
            this.breakTypes = breakTypes;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListBreakTypesResponse} object using the set fields.
         * @return {@link ListBreakTypesResponse}
         */
        public ListBreakTypesResponse build() {
            ListBreakTypesResponse model =
                    new ListBreakTypesResponse(breakTypes, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
