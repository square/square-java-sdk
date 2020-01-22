package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CatalogInfoResponse type.
 */
public class CatalogInfoResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param limits
     * @param standardUnitDescriptionGroup
     */
    @JsonCreator
    public CatalogInfoResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("limits") CatalogInfoResponseLimits limits,
            @JsonProperty("standard_unit_description_group") StandardUnitDescriptionGroup standardUnitDescriptionGroup) {
        this.errors = errors;
        this.limits = limits;
        this.standardUnitDescriptionGroup = standardUnitDescriptionGroup;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogInfoResponseLimits limits;
    private final StandardUnitDescriptionGroup standardUnitDescriptionGroup;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * The set of errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Limits.
     */
    @JsonGetter("limits")
    public CatalogInfoResponseLimits getLimits() {
        return this.limits;
    }

    /**
     * Getter for StandardUnitDescriptionGroup.
     * Group of standard measurement units.
     */
    @JsonGetter("standard_unit_description_group")
    public StandardUnitDescriptionGroup getStandardUnitDescriptionGroup() {
        return this.standardUnitDescriptionGroup;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, limits, standardUnitDescriptionGroup);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogInfoResponse)) {
            return false;
        }
        CatalogInfoResponse catalogInfoResponse = (CatalogInfoResponse) obj;
        return Objects.equals(errors, catalogInfoResponse.errors) &&
            Objects.equals(limits, catalogInfoResponse.limits) &&
            Objects.equals(standardUnitDescriptionGroup, catalogInfoResponse.standardUnitDescriptionGroup);
    }

    /**
     * Builds a new {@link CatalogInfoResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogInfoResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .limits(getLimits())
            .standardUnitDescriptionGroup(getStandardUnitDescriptionGroup());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogInfoResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogInfoResponseLimits limits;
        private StandardUnitDescriptionGroup standardUnitDescriptionGroup;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for limits
         * @param limits
         * @return Builder
         */
        public Builder limits(CatalogInfoResponseLimits limits) {
            this.limits = limits;
            return this;
        }
        /**
         * Setter for standardUnitDescriptionGroup
         * @param standardUnitDescriptionGroup
         * @return Builder
         */
        public Builder standardUnitDescriptionGroup(StandardUnitDescriptionGroup standardUnitDescriptionGroup) {
            this.standardUnitDescriptionGroup = standardUnitDescriptionGroup;
            return this;
        }

        /**
         * Builds a new {@link CatalogInfoResponse} object using the set fields.
         * @return {@link CatalogInfoResponse}
         */
        public CatalogInfoResponse build() {
            CatalogInfoResponse model = new CatalogInfoResponse(errors,
                limits,
                standardUnitDescriptionGroup);
            model.httpContext = httpContext;
            return model;
        }
    }
}
