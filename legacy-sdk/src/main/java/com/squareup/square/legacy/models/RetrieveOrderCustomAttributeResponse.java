package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for RetrieveOrderCustomAttributeResponse type.
 */
public class RetrieveOrderCustomAttributeResponse {
    private HttpContext httpContext;
    private final CustomAttribute customAttribute;
    private final List<Error> errors;

    /**
     * Initialization constructor.
     * @param  customAttribute  CustomAttribute value for customAttribute.
     * @param  errors  List of Error value for errors.
     */
    @JsonCreator
    public RetrieveOrderCustomAttributeResponse(
            @JsonProperty("custom_attribute") CustomAttribute customAttribute,
            @JsonProperty("errors") List<Error> errors) {
        this.customAttribute = customAttribute;
        this.errors = errors;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for CustomAttribute.
     * A custom attribute value. Each custom attribute value has a corresponding
     * `CustomAttributeDefinition` object.
     * @return Returns the CustomAttribute
     */
    @JsonGetter("custom_attribute")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomAttribute getCustomAttribute() {
        return customAttribute;
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
        return Objects.hash(customAttribute, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveOrderCustomAttributeResponse)) {
            return false;
        }
        RetrieveOrderCustomAttributeResponse other = (RetrieveOrderCustomAttributeResponse) obj;
        return Objects.equals(customAttribute, other.customAttribute) && Objects.equals(errors, other.errors);
    }

    /**
     * Converts this RetrieveOrderCustomAttributeResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveOrderCustomAttributeResponse [" + "customAttribute=" + customAttribute + ", errors=" + errors
                + "]";
    }

    /**
     * Builds a new {@link RetrieveOrderCustomAttributeResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveOrderCustomAttributeResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().customAttribute(getCustomAttribute()).errors(getErrors());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveOrderCustomAttributeResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private CustomAttribute customAttribute;
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
         * Setter for customAttribute.
         * @param  customAttribute  CustomAttribute value for customAttribute.
         * @return Builder
         */
        public Builder customAttribute(CustomAttribute customAttribute) {
            this.customAttribute = customAttribute;
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
         * Builds a new {@link RetrieveOrderCustomAttributeResponse} object using the set fields.
         * @return {@link RetrieveOrderCustomAttributeResponse}
         */
        public RetrieveOrderCustomAttributeResponse build() {
            RetrieveOrderCustomAttributeResponse model =
                    new RetrieveOrderCustomAttributeResponse(customAttribute, errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
