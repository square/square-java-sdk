package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for SearchLoyaltyAccountsResponse type.
 */
public class SearchLoyaltyAccountsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param loyaltyAccounts
     * @param cursor
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

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<LoyaltyAccount> loyaltyAccounts;
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
     * Getter for LoyaltyAccounts.
     * The loyalty accounts that met the search criteria,  
     * in order of creation date.
     */
    @JsonGetter("loyalty_accounts")
    public List<LoyaltyAccount> getLoyaltyAccounts() {
        return this.loyaltyAccounts;
    }

    /**
     * Getter for Cursor.
     * The pagination cursor to use in a subsequent 
     * request. If empty, this is the final response.
     * For more information, 
     * see [Pagination](https://developer.squareup.com/docs/docs/basics/api101/pagination).
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchLoyaltyAccountsResponse)) {
            return false;
        }
        SearchLoyaltyAccountsResponse searchLoyaltyAccountsResponse = (SearchLoyaltyAccountsResponse) obj;
        return Objects.equals(errors, searchLoyaltyAccountsResponse.errors) &&
            Objects.equals(loyaltyAccounts, searchLoyaltyAccountsResponse.loyaltyAccounts) &&
            Objects.equals(cursor, searchLoyaltyAccountsResponse.cursor);
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
     * Class to build instances of {@link SearchLoyaltyAccountsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<LoyaltyAccount> loyaltyAccounts;
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
         * Setter for loyaltyAccounts
         * @param loyaltyAccounts
         * @return Builder
         */
        public Builder loyaltyAccounts(List<LoyaltyAccount> loyaltyAccounts) {
            this.loyaltyAccounts = loyaltyAccounts;
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
         * Builds a new {@link SearchLoyaltyAccountsResponse} object using the set fields.
         * @return {@link SearchLoyaltyAccountsResponse}
         */
        public SearchLoyaltyAccountsResponse build() {
            SearchLoyaltyAccountsResponse model = new SearchLoyaltyAccountsResponse(errors,
                loyaltyAccounts,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
