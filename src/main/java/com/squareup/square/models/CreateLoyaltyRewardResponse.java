package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CreateLoyaltyRewardResponse type.
 */
public class CreateLoyaltyRewardResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param reward
     */
    @JsonCreator
    public CreateLoyaltyRewardResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("reward") LoyaltyReward reward) {
        this.errors = errors;
        this.reward = reward;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyReward reward;

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
     * Getter for Reward.
     */
    @JsonGetter("reward")
    public LoyaltyReward getReward() {
        return this.reward;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, reward);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateLoyaltyRewardResponse)) {
            return false;
        }
        CreateLoyaltyRewardResponse createLoyaltyRewardResponse = (CreateLoyaltyRewardResponse) obj;
        return Objects.equals(errors, createLoyaltyRewardResponse.errors) &&
            Objects.equals(reward, createLoyaltyRewardResponse.reward);
    }

    /**
     * Builds a new {@link CreateLoyaltyRewardResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyRewardResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .reward(getReward());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyRewardResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyReward reward;

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
         * Setter for reward
         * @param reward
         * @return Builder
         */
        public Builder reward(LoyaltyReward reward) {
            this.reward = reward;
            return this;
        }

        /**
         * Builds a new {@link CreateLoyaltyRewardResponse} object using the set fields.
         * @return {@link CreateLoyaltyRewardResponse}
         */
        public CreateLoyaltyRewardResponse build() {
            CreateLoyaltyRewardResponse model = new CreateLoyaltyRewardResponse(errors,
                reward);
            model.httpContext = httpContext;
            return model;
        }
    }
}
