
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
 * This is a model class for CalculateLoyaltyPointsResponse type.
 */
public class CalculateLoyaltyPointsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final Integer points;
    private final Integer promotionPoints;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  points  Integer value for points.
     * @param  promotionPoints  Integer value for promotionPoints.
     */
    @JsonCreator
    public CalculateLoyaltyPointsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("points") Integer points,
            @JsonProperty("promotion_points") Integer promotionPoints) {
        this.errors = errors;
        this.points = points;
        this.promotionPoints = promotionPoints;
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
     * Getter for Points.
     * The number of points that the buyer can earn from the base loyalty program.
     * @return Returns the Integer
     */
    @JsonGetter("points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getPoints() {
        return points;
    }

    /**
     * Getter for PromotionPoints.
     * The number of points that the buyer can earn from a loyalty promotion. To be eligible to earn
     * promotion points, the purchase must first qualify for program points. When `order_id` is not
     * provided in the request, this value is always 0.
     * @return Returns the Integer
     */
    @JsonGetter("promotion_points")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getPromotionPoints() {
        return promotionPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, points, promotionPoints);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CalculateLoyaltyPointsResponse)) {
            return false;
        }
        CalculateLoyaltyPointsResponse other = (CalculateLoyaltyPointsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(points, other.points)
            && Objects.equals(promotionPoints, other.promotionPoints);
    }

    /**
     * Converts this CalculateLoyaltyPointsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CalculateLoyaltyPointsResponse [" + "errors=" + errors + ", points=" + points
                + ", promotionPoints=" + promotionPoints + "]";
    }

    /**
     * Builds a new {@link CalculateLoyaltyPointsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateLoyaltyPointsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .points(getPoints())
                .promotionPoints(getPromotionPoints());
        return builder;
    }

    /**
     * Class to build instances of {@link CalculateLoyaltyPointsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Integer points;
        private Integer promotionPoints;



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
         * Setter for points.
         * @param  points  Integer value for points.
         * @return Builder
         */
        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for promotionPoints.
         * @param  promotionPoints  Integer value for promotionPoints.
         * @return Builder
         */
        public Builder promotionPoints(Integer promotionPoints) {
            this.promotionPoints = promotionPoints;
            return this;
        }

        /**
         * Builds a new {@link CalculateLoyaltyPointsResponse} object using the set fields.
         * @return {@link CalculateLoyaltyPointsResponse}
         */
        public CalculateLoyaltyPointsResponse build() {
            CalculateLoyaltyPointsResponse model =
                    new CalculateLoyaltyPointsResponse(errors, points, promotionPoints);
            model.httpContext = httpContext;
            return model;
        }
    }
}
