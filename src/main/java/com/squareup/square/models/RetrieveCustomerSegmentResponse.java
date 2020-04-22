package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for RetrieveCustomerSegmentResponse type.
 */
public class RetrieveCustomerSegmentResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param segment
     */
    @JsonCreator
    public RetrieveCustomerSegmentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("segment") CustomerSegment segment) {
        this.errors = errors;
        this.segment = segment;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final CustomerSegment segment;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for Segment.
     * Represents a group of customer profiles that match one or more predefined filter criteria. 
     * Segments (also known as Smart Groups) are defined and created within Customer Directory in the Square Dashboard or Point of Sale.
     */
    @JsonGetter("segment")
    public CustomerSegment getSegment() {
        return this.segment;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, segment);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof RetrieveCustomerSegmentResponse)) {
            return false;
        }
        RetrieveCustomerSegmentResponse retrieveCustomerSegmentResponse = (RetrieveCustomerSegmentResponse) obj;
        return Objects.equals(errors, retrieveCustomerSegmentResponse.errors) &&
            Objects.equals(segment, retrieveCustomerSegmentResponse.segment);
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
     * Class to build instances of {@link RetrieveCustomerSegmentResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private CustomerSegment segment;

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
         * Setter for segment
         * @param segment
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
            RetrieveCustomerSegmentResponse model = new RetrieveCustomerSegmentResponse(errors,
                segment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
