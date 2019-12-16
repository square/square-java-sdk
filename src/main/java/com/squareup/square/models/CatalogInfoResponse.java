package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CatalogInfoResponse {

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

    @Override
    public int hashCode() {
        return Objects.hash(errors, limits, standardUnitDescriptionGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogInfoResponse)) {
            return false;
        }
        CatalogInfoResponse catalogInfoResponse = (CatalogInfoResponse) o;
        return Objects.equals(errors, catalogInfoResponse.errors) &&
            Objects.equals(limits, catalogInfoResponse.limits) &&
            Objects.equals(standardUnitDescriptionGroup, catalogInfoResponse.standardUnitDescriptionGroup);
    }


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

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .limits(getLimits())
            .standardUnitDescriptionGroup(getStandardUnitDescriptionGroup());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CatalogInfoResponseLimits limits;
        private StandardUnitDescriptionGroup standardUnitDescriptionGroup;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder limits(CatalogInfoResponseLimits value) {
            limits = value;
            return this;
        }
        public Builder standardUnitDescriptionGroup(StandardUnitDescriptionGroup value) {
            standardUnitDescriptionGroup = value;
            return this;
        }

        public CatalogInfoResponse build() {
            CatalogInfoResponse model = new CatalogInfoResponse(errors,
                limits,
                standardUnitDescriptionGroup);
            model.httpContext = httpContext;
            return model;
        }
    }
}
