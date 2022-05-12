
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for ListCustomerCustomAttributesResponse type.
 */
public class ListCustomerCustomAttributesResponse {
    private HttpContext httpContext;
    private final List<CustomAttribute> customAttributes;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  customAttributes  List of CustomAttribute value for customAttributes.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListCustomerCustomAttributesResponse(
            @JsonProperty("custom_attributes") List<CustomAttribute> customAttributes,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.customAttributes = customAttributes;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for CustomAttributes.
     * The retrieved custom attributes. If `with_definitions` was set to `true` in the request, the
     * custom attribute definition is returned in the `definition` field of each custom attribute.
     * If no custom attributes are found, Square returns an empty object (`{}`).
     * @return Returns the List of CustomAttribute
     */
    @JsonGetter("custom_attributes")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() {
        return customAttributes;
    }

    /**
     * Getter for Cursor.
     * The cursor to use in your next call to this endpoint to retrieve the next page of results for
     * your original request. This field is present only if the request succeeded and additional
     * results are available. For more information, see
     * [Pagination](https://developer.squareup.com/docs/build-basics/common-api-patterns/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customAttributes, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerCustomAttributesResponse)) {
            return false;
        }
        ListCustomerCustomAttributesResponse other = (ListCustomerCustomAttributesResponse) obj;
        return Objects.equals(customAttributes, other.customAttributes)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListCustomerCustomAttributesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerCustomAttributesResponse [" + "customAttributes=" + customAttributes
                + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListCustomerCustomAttributesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerCustomAttributesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .customAttributes(getCustomAttributes())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerCustomAttributesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CustomAttribute> customAttributes;
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
         * Setter for customAttributes.
         * @param  customAttributes  List of CustomAttribute value for customAttributes.
         * @return Builder
         */
        public Builder customAttributes(List<CustomAttribute> customAttributes) {
            this.customAttributes = customAttributes;
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
         * Builds a new {@link ListCustomerCustomAttributesResponse} object using the set fields.
         * @return {@link ListCustomerCustomAttributesResponse}
         */
        public ListCustomerCustomAttributesResponse build() {
            ListCustomerCustomAttributesResponse model =
                    new ListCustomerCustomAttributesResponse(customAttributes, cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
