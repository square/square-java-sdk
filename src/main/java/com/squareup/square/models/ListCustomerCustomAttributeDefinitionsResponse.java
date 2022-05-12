
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
 * This is a model class for ListCustomerCustomAttributeDefinitionsResponse type.
 */
public class ListCustomerCustomAttributeDefinitionsResponse {
    private HttpContext httpContext;
    private final List<CustomAttributeDefinition> customAttributeDefinitions;
    private final String cursor;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  customAttributeDefinitions  List of CustomAttributeDefinition value for
     *         customAttributeDefinitions.
     * @param  cursor  String value for cursor.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public ListCustomerCustomAttributeDefinitionsResponse(
            @JsonProperty("custom_attribute_definitions") List<CustomAttributeDefinition> customAttributeDefinitions,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.customAttributeDefinitions = customAttributeDefinitions;
        this.cursor = cursor;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for CustomAttributeDefinitions.
     * The retrieved custom attribute definitions. If no custom attribute definitions are found,
     * Square returns an empty object (`{}`).
     * @return Returns the List of CustomAttributeDefinition
     */
    @JsonGetter("custom_attribute_definitions")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<CustomAttributeDefinition> getCustomAttributeDefinitions() {
        return customAttributeDefinitions;
    }

    /**
     * Getter for Cursor.
     * The cursor to provide in your next call to this endpoint to retrieve the next page of results
     * for your original request. This field is present only if the request succeeded and additional
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
        return Objects.hash(customAttributeDefinitions, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListCustomerCustomAttributeDefinitionsResponse)) {
            return false;
        }
        ListCustomerCustomAttributeDefinitionsResponse other =
                (ListCustomerCustomAttributeDefinitionsResponse) obj;
        return Objects.equals(customAttributeDefinitions, other.customAttributeDefinitions)
            && Objects.equals(cursor, other.cursor)
            && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this ListCustomerCustomAttributeDefinitionsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListCustomerCustomAttributeDefinitionsResponse [" + "customAttributeDefinitions="
                + customAttributeDefinitions + ", cursor=" + cursor + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link ListCustomerCustomAttributeDefinitionsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListCustomerCustomAttributeDefinitionsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .customAttributeDefinitions(getCustomAttributeDefinitions())
                .cursor(getCursor())
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link ListCustomerCustomAttributeDefinitionsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<CustomAttributeDefinition> customAttributeDefinitions;
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
         * Setter for customAttributeDefinitions.
         * @param  customAttributeDefinitions  List of CustomAttributeDefinition value for
         *         customAttributeDefinitions.
         * @return Builder
         */
        public Builder customAttributeDefinitions(
                List<CustomAttributeDefinition> customAttributeDefinitions) {
            this.customAttributeDefinitions = customAttributeDefinitions;
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
         * Builds a new {@link ListCustomerCustomAttributeDefinitionsResponse} object using the set
         * fields.
         * @return {@link ListCustomerCustomAttributeDefinitionsResponse}
         */
        public ListCustomerCustomAttributeDefinitionsResponse build() {
            ListCustomerCustomAttributeDefinitionsResponse model =
                    new ListCustomerCustomAttributeDefinitionsResponse(customAttributeDefinitions,
                            cursor, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
