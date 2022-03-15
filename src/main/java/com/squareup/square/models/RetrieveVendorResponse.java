
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
 * This is a model class for RetrieveVendorResponse type.
 */
public class RetrieveVendorResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Vendor vendor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  vendor  Vendor value for vendor.
     */
    @JsonCreator
    public RetrieveVendorResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("vendor") Vendor vendor) {
        this.errors = errors;
        this.vendor = vendor;
    }

    @JsonIgnore
    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Errors encountered when the request fails.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * Getter for Vendor.
     * Represents a supplier to a seller.
     * @return Returns the Vendor
     */
    @JsonGetter("vendor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Vendor getVendor() {
        return vendor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, vendor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveVendorResponse)) {
            return false;
        }
        RetrieveVendorResponse other = (RetrieveVendorResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(vendor, other.vendor);
    }

    /**
     * Converts this RetrieveVendorResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveVendorResponse [" + "errors=" + errors + ", vendor=" + vendor + "]";
    }

    /**
     * Builds a new {@link RetrieveVendorResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveVendorResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .vendor(getVendor());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveVendorResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Vendor vendor;



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
         * Setter for errors.
         * @param  errors  List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for vendor.
         * @param  vendor  Vendor value for vendor.
         * @return Builder
         */
        public Builder vendor(Vendor vendor) {
            this.vendor = vendor;
            return this;
        }

        /**
         * Builds a new {@link RetrieveVendorResponse} object using the set fields.
         * @return {@link RetrieveVendorResponse}
         */
        public RetrieveVendorResponse build() {
            RetrieveVendorResponse model =
                    new RetrieveVendorResponse(errors, vendor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
