
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import io.apimatic.core.types.BaseModel;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkDeleteOrderCustomAttributesResponse type.
 */
public class BulkDeleteOrderCustomAttributesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Map<String, DeleteOrderCustomAttributeResponse> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkDeleteOrderCustomAttributesResponse(
            @JsonProperty("values") Map<String, DeleteOrderCustomAttributeResponse> values,
            @JsonProperty("errors") List<Error> errors) {
        this.errors = errors;
        this.values = values;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
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

    /**
     * Getter for Values.
     * A map of responses that correspond to individual delete requests. Each response has the same
     * ID as the corresponding request and contains either a `custom_attribute` or an `errors`
     * field.
     * @return Returns the Map of String, DeleteOrderCustomAttributeResponse
     */
    @JsonGetter("values")
    public Map<String, DeleteOrderCustomAttributeResponse> getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, values);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BulkDeleteOrderCustomAttributesResponse)) {
            return false;
        }
        BulkDeleteOrderCustomAttributesResponse other =
                (BulkDeleteOrderCustomAttributesResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkDeleteOrderCustomAttributesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkDeleteOrderCustomAttributesResponse [" + "values=" + values + ", errors="
                + errors + "]";
    }

    /**
     * Builds a new {@link BulkDeleteOrderCustomAttributesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkDeleteOrderCustomAttributesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values)
                .errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkDeleteOrderCustomAttributesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, DeleteOrderCustomAttributeResponse> values;
        private List<Error> errors;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(Map<String, DeleteOrderCustomAttributeResponse> values) {
            this.values = values;
        }

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
         * Setter for values.
         * @param  values  Map of String, value for values.
         * @return Builder
         */
        public Builder values(Map<String, DeleteOrderCustomAttributeResponse> values) {
            this.values = values;
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
         * Builds a new {@link BulkDeleteOrderCustomAttributesResponse} object using the set fields.
         * @return {@link BulkDeleteOrderCustomAttributesResponse}
         */
        public BulkDeleteOrderCustomAttributesResponse build() {
            BulkDeleteOrderCustomAttributesResponse model =
                    new BulkDeleteOrderCustomAttributesResponse(values, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
