
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
 * This is a model class for SearchLoyaltyRewardsResponse type.
 */
public class SearchLoyaltyRewardsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyReward> rewards;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param  errors  List of Error value for errors.
     * @param  rewards  List of LoyaltyReward value for rewards.
     * @param  cursor  String value for cursor.
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
     * Getter for Rewards.
     * The loyalty rewards that satisfy the search criteria. These are returned in descending order
     * by `updated_at`.
     * @return Returns the List of LoyaltyReward
     */
    @JsonGetter("rewards")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<LoyaltyReward> getRewards() {
        return rewards;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to be used in a subsequent request. If empty, this is the final
     * response.
     * @return Returns the String
     */
    @JsonGetter("cursor")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCursor() {
        return cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, rewards, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyRewardsResponse)) {
            return false;
        }
        SearchLoyaltyRewardsResponse other = (SearchLoyaltyRewardsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(rewards, other.rewards)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchLoyaltyRewardsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyRewardsResponse [" + "errors=" + errors + ", rewards=" + rewards
                + ", cursor=" + cursor + "]";
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
     * Class to build instances of {@link SearchLoyaltyRewardsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyReward> rewards;
        private String cursor;



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
         * Setter for rewards.
         * @param  rewards  List of LoyaltyReward value for rewards.
         * @return Builder
         */
        public Builder rewards(List<LoyaltyReward> rewards) {
            this.rewards = rewards;
            return this;
        }

        /**
         * Setter for cursor.
         * @param  cursor  String value for cursor.
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
            SearchLoyaltyRewardsResponse model =
                    new SearchLoyaltyRewardsResponse(errors, rewards, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
