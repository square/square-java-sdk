package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for ListEventTypesRequest type.
 */
public class ListEventTypesRequest {
    private final OptionalNullable<String> apiVersion;

    /**
     * Initialization constructor.
     * @param  apiVersion  String value for apiVersion.
     */
    @JsonCreator
    public ListEventTypesRequest(@JsonProperty("api_version") String apiVersion) {
        this.apiVersion = OptionalNullable.of(apiVersion);
    }

    /**
     * Initialization constructor.
     * @param  apiVersion  String value for apiVersion.
     */
    protected ListEventTypesRequest(OptionalNullable<String> apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Internal Getter for ApiVersion.
     * The API version for which to list event types. Setting this field overrides the default
     * version used by the application.
     * @return Returns the Internal String
     */
    @JsonGetter("api_version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetApiVersion() {
        return this.apiVersion;
    }

    /**
     * Getter for ApiVersion.
     * The API version for which to list event types. Setting this field overrides the default
     * version used by the application.
     * @return Returns the String
     */
    @JsonIgnore
    public String getApiVersion() {
        return OptionalNullable.getFrom(apiVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiVersion);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListEventTypesRequest)) {
            return false;
        }
        ListEventTypesRequest other = (ListEventTypesRequest) obj;
        return Objects.equals(apiVersion, other.apiVersion);
    }

    /**
     * Converts this ListEventTypesRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "ListEventTypesRequest [" + "apiVersion=" + apiVersion + "]";
    }

    /**
     * Builds a new {@link ListEventTypesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListEventTypesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.apiVersion = internalGetApiVersion();
        return builder;
    }

    /**
     * Class to build instances of {@link ListEventTypesRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> apiVersion;

        /**
         * Setter for apiVersion.
         * @param  apiVersion  String value for apiVersion.
         * @return Builder
         */
        public Builder apiVersion(String apiVersion) {
            this.apiVersion = OptionalNullable.of(apiVersion);
            return this;
        }

        /**
         * UnSetter for apiVersion.
         * @return Builder
         */
        public Builder unsetApiVersion() {
            apiVersion = null;
            return this;
        }

        /**
         * Builds a new {@link ListEventTypesRequest} object using the set fields.
         * @return {@link ListEventTypesRequest}
         */
        public ListEventTypesRequest build() {
            return new ListEventTypesRequest(apiVersion);
        }
    }
}
