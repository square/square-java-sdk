
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
 * This is a model class for RetrieveCustomerSegmentResponse type.
 */
public class RetrieveCustomerSegmentResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final CustomerSegment segment;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  segment  CustomerSegment value for segment.
     */
    @JsonCreator
    public RetrieveCustomerSegmentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("segment") CustomerSegment segment) {
        this.errors = errors;
        this.segment = segment;
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
     * Getter for Segment.
     * Represents a group of customer profiles that match one or more predefined filter criteria.
     * Segments (also known as Smart Groups) are defined and created within the Customer Directory
     * in the Square Seller Dashboard or Point of Sale.
     * @return Returns the CustomerSegment
     */
    @JsonGetter("segment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public CustomerSegment getSegment() {
        return segment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, segment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCustomerSegmentResponse)) {
            return false;
        }
        RetrieveCustomerSegmentResponse other = (RetrieveCustomerSegmentResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(segment, other.segment);
    }

    /**
     * Converts this RetrieveCustomerSegmentResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCustomerSegmentResponse [" + "errors=" + errors + ", segment=" + segment
                + "]";
    }

    /**
     * Builds a new {@link RetrieveCustomerSegmentResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCustomerSegmentResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .segment(getSegment());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCustomerSegmentResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CustomerSegment segment;



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
         * Setter for segment.
         * @param  segment  CustomerSegment value for segment.
         * @return Builder
         */
        public Builder segment(CustomerSegment segment) {
            this.segment = segment;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCustomerSegmentResponse} object using the set fields.
         * @return {@link RetrieveCustomerSegmentResponse}
         */
        public RetrieveCustomerSegmentResponse build() {
            RetrieveCustomerSegmentResponse model =
                    new RetrieveCustomerSegmentResponse(errors, segment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
