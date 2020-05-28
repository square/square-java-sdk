package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchLoyaltyRewardsResponse type.
 */
public class SearchLoyaltyRewardsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param rewards
     * @param cursor
     */
    @JsonCreator
    public SearchLoyaltyRewardsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("rewards") List<LoyaltyReward> rewards,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.rewards = rewards;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyReward> rewards;
    private final String cursor;

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
     * Getter for Rewards.
     * The loyalty rewards that satisfy the search criteria.
     * These are returned in descending order by `updated_at`.
     */
    @JsonGetter("rewards")
    public List<LoyaltyReward> getRewards() {
        return this.rewards;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent 
     * request. If empty, this is the final response.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, rewards, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchLoyaltyRewardsResponse)) {
            return false;
        }
        SearchLoyaltyRewardsResponse searchLoyaltyRewardsResponse = (SearchLoyaltyRewardsResponse) obj;
        return Objects.equals(errors, searchLoyaltyRewardsResponse.errors) &&
            Objects.equals(rewards, searchLoyaltyRewardsResponse.rewards) &&
            Objects.equals(cursor, searchLoyaltyRewardsResponse.cursor);
    }

    /**
     * Builds a new {@link SearchLoyaltyRewardsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyRewardsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .rewards(getRewards())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyRewardsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyReward> rewards;
        private String cursor;

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
         * Setter for rewards
         * @param rewards
         * @return Builder
         */
        public Builder rewards(List<LoyaltyReward> rewards) {
            this.rewards = rewards;
            return this;
        }
        /**
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyRewardsResponse} object using the set fields.
         * @return {@link SearchLoyaltyRewardsResponse}
         */
        public SearchLoyaltyRewardsResponse build() {
            SearchLoyaltyRewardsResponse model = new SearchLoyaltyRewardsResponse(errors,
                rewards,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
