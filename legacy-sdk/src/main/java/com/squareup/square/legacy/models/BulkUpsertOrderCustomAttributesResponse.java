package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * This is a model class for BulkUpsertOrderCustomAttributesResponse type.
 */
public class BulkUpsertOrderCustomAttributesResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Map<String, UpsertOrderCustomAttributeResponse> values;

    /**
     * Initialization constructor.
     * @param  values  Map of String, value for values.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public BulkUpsertOrderCustomAttributesResponse(
            @JsonProperty("values") Map<String, UpsertOrderCustomAttributeResponse> values,
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
     * A map of responses that correspond to individual upsert operations for custom attributes.
     * @return Returns the Map of String, UpsertOrderCustomAttributeResponse
     */
    @JsonGetter("values")
    public Map<String, UpsertOrderCustomAttributeResponse> getValues() {
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
        if (!(obj instanceof BulkUpsertOrderCustomAttributesResponse)) {
            return false;
        }
        BulkUpsertOrderCustomAttributesResponse other = (BulkUpsertOrderCustomAttributesResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(values, other.values);
    }

    /**
     * Converts this BulkUpsertOrderCustomAttributesResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "BulkUpsertOrderCustomAttributesResponse [" + "values=" + values + ", errors=" + errors + "]";
    }

    /**
     * Builds a new {@link BulkUpsertOrderCustomAttributesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BulkUpsertOrderCustomAttributesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(values).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link BulkUpsertOrderCustomAttributesResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private Map<String, UpsertOrderCustomAttributeResponse> values;
        private List<Error> errors;

        /**
         * Initialization constructor.
         * @param  values  Map of String, value for values.
         */
        public Builder(Map<String, UpsertOrderCustomAttributeResponse> values) {
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
        public Builder values(Map<String, UpsertOrderCustomAttributeResponse> values) {
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
         * Builds a new {@link BulkUpsertOrderCustomAttributesResponse} object using the set fields.
         * @return {@link BulkUpsertOrderCustomAttributesResponse}
         */
        public BulkUpsertOrderCustomAttributesResponse build() {
            BulkUpsertOrderCustomAttributesResponse model = new BulkUpsertOrderCustomAttributesResponse(values, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
