package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CalculateLoyaltyPointsResponse type.
 */
public class CalculateLoyaltyPointsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param points
     */
    @JsonCreator
    public CalculateLoyaltyPointsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("points") Integer points) {
        this.errors = errors;
        this.points = points;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Integer points;

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
     * Getter for Points.
     * The points that the buyer can earn from a specified purchase.
     */
    @JsonGetter("points")
    public Integer getPoints() {
        return this.points;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, points);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CalculateLoyaltyPointsResponse)) {
            return false;
        }
        CalculateLoyaltyPointsResponse calculateLoyaltyPointsResponse = (CalculateLoyaltyPointsResponse) obj;
        return Objects.equals(errors, calculateLoyaltyPointsResponse.errors) &&
            Objects.equals(points, calculateLoyaltyPointsResponse.points);
    }

    /**
     * Builds a new {@link CalculateLoyaltyPointsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateLoyaltyPointsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .points(getPoints());
            return builder;
    }

    /**
     * Class to build instances of {@link CalculateLoyaltyPointsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Integer points;

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
         * Setter for points
         * @param points
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        /**
         * Builds a new {@link CalculateLoyaltyPointsResponse} object using the set fields.
         * @return {@link CalculateLoyaltyPointsResponse}
         */
        public CalculateLoyaltyPointsResponse build() {
            CalculateLoyaltyPointsResponse model = new CalculateLoyaltyPointsResponse(errors,
                points);
            model.httpContext = httpContext;
            return model;
        }
    }
}
