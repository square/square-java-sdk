package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.legacy.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for CreateLoyaltyRewardResponse type.
 */
public class CreateLoyaltyRewardResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final LoyaltyReward reward;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  reward  LoyaltyReward value for reward.
     */
    @JsonCreator
    public CreateLoyaltyRewardResponse(
            @JsonProperty("errors") List<Error> errors, @JsonProperty("reward") LoyaltyReward reward) {
        this.errors = errors;
        this.reward = reward;
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
     * Getter for Reward.
     * Represents a contract to redeem loyalty points for a [reward
     * tier]($m/LoyaltyProgramRewardTier) discount. Loyalty rewards can be in an ISSUED, REDEEMED,
     * or DELETED state. For more information, see [Manage loyalty
     * rewards](https://developer.squareup.com/docs/loyalty-api/loyalty-rewards).
     * @return Returns the LoyaltyReward
     */
    @JsonGetter("reward")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyReward getReward() {
        return reward;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, reward);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateLoyaltyRewardResponse)) {
            return false;
        }
        CreateLoyaltyRewardResponse other = (CreateLoyaltyRewardResponse) obj;
        return Objects.equals(errors, other.errors) && Objects.equals(reward, other.reward);
    }

    /**
     * Converts this CreateLoyaltyRewardResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CreateLoyaltyRewardResponse [" + "errors=" + errors + ", reward=" + reward + "]";
    }

    /**
     * Builds a new {@link CreateLoyaltyRewardResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateLoyaltyRewardResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().errors(getErrors()).reward(getReward());
        return builder;
    }

    /**
     * Class to build instances of {@link CreateLoyaltyRewardResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private LoyaltyReward reward;

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
         * Setter for reward.
         * @param  reward  LoyaltyReward value for reward.
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
            CreateLoyaltyRewardResponse model = new CreateLoyaltyRewardResponse(errors, reward);
            model.httpContext = httpContext;
            return model;
        }
    }
}
