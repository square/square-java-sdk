
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for SearchLoyaltyAccountsResponse type.
 */
public class SearchLoyaltyAccountsResponse {
    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyAccount> loyaltyAccounts;
    private final String cursor;

    /**
     * Initialization constructor.
     * @param errors List of Error value for errors.
     * @param loyaltyAccounts List of LoyaltyAccount value for loyaltyAccounts.
     * @param cursor String value for cursor.
     */
    @JsonCreator
    public SearchLoyaltyAccountsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("loyalty_accounts") List<LoyaltyAccount> loyaltyAccounts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.loyaltyAccounts = loyaltyAccounts;
        this.cursor = cursor;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     * @return Returns the List of Error
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for LoyaltyAccounts.
     * The loyalty accounts that met the search criteria, in order of creation date.
     * @return Returns the List of LoyaltyAccount
     */
    @JsonGetter("loyalty_accounts")
    public List<LoyaltyAccount> getLoyaltyAccounts() {
        return this.loyaltyAccounts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to use in a subsequent request. If empty, this is the final response.
     * For more information, see
     * [Pagination](https://developer.squareup.com/docs/basics/api101/pagination).
     * @return Returns the String
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, loyaltyAccounts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchLoyaltyAccountsResponse)) {
            return false;
        }
        SearchLoyaltyAccountsResponse other = (SearchLoyaltyAccountsResponse) obj;
        return Objects.equals(errors, other.errors)
            && Objects.equals(loyaltyAccounts, other.loyaltyAccounts)
            && Objects.equals(cursor, other.cursor);
    }

    /**
     * Converts this SearchLoyaltyAccountsResponse into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SearchLoyaltyAccountsResponse [" + "errors=" + errors + ", loyaltyAccounts="
                + loyaltyAccounts + ", cursor=" + cursor + "]";
    }

    /**
     * Builds a new {@link SearchLoyaltyAccountsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchLoyaltyAccountsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .errors(getErrors())
                .loyaltyAccounts(getLoyaltyAccounts())
                .cursor(getCursor());
        return builder;
    }

    /**
     * Class to build instances of {@link SearchLoyaltyAccountsResponse}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyAccount> loyaltyAccounts;
        private String cursor;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for errors.
         * @param errors List of Error value for errors.
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Setter for loyaltyAccounts.
         * @param loyaltyAccounts List of LoyaltyAccount value for loyaltyAccounts.
         * @return Builder
         */
        public Builder loyaltyAccounts(List<LoyaltyAccount> loyaltyAccounts) {
            this.loyaltyAccounts = loyaltyAccounts;
            return this;
        }

        /**
         * Setter for cursor.
         * @param cursor String value for cursor.
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        /**
         * Builds a new {@link SearchLoyaltyAccountsResponse} object using the set fields.
         * @return {@link SearchLoyaltyAccountsResponse}
         */
        public SearchLoyaltyAccountsResponse build() {
            SearchLoyaltyAccountsResponse model =
                    new SearchLoyaltyAccountsResponse(errors, loyaltyAccounts, cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
