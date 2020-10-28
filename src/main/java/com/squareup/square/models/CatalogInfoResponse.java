
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for CatalogInfoResponse type.
 */
public class CatalogInfoResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CatalogInfoResponseLimits limits;
    private final StandardUnitDescriptionGroup standardUnitDescriptionGroup;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param limits CatalogInfoResponseLimits value for limits.
     * @param standardUnitDescriptionGroup StandardUnitDescriptionGroup value for standardUnitDescriptionGroup.
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

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Limits.
     * @return Returns the CatalogInfoResponseLimits
     */
    @JsonGetter("limits")
    public CatalogInfoResponseLimits getLimits() {
        return this.limits;
    }

    /**
     * Getter for StandardUnitDescriptionGroup.
     * Group of standard measurement units.
     * @return Returns the StandardUnitDescriptionGroup
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
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CatalogInfoResponse)) {
            return false;
        }
        CatalogInfoResponse other = (CatalogInfoResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(limits, other.limits)
            && Objects.equals(standardUnitDescriptionGroup, other.standardUnitDescriptionGroup);
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
     * Class to build instances of {@link CatalogInfoResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogInfoResponseLimits limits;
        private StandardUnitDescriptionGroup standardUnitDescriptionGroup;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for limits.
         * @param limits CatalogInfoResponseLimits value for limits.
         * @return Builder
         */
        public Builder limits(CatalogInfoResponseLimits limits) {
            this.limits = limits;
            return this;
        }

        /**
         * Setter for standardUnitDescriptionGroup.
         * @param standardUnitDescriptionGroup StandardUnitDescriptionGroup value for standardUnitDescriptionGroup.
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
            CatalogInfoResponse model =
                    new CatalogInfoResponse(errors,
                            limits,
                            standardUnitDescriptionGroup);
            model.httpContext = httpContext;
            return model;
        }
    }
}
