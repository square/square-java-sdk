
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;


/**
 * This is a model class for V1ListBankAccountsResponse type.
 */
public class V1ListBankAccountsResponse {
    private final List<V1BankAccount> items;

    /**
     * Initialization constructor.
     * @param items List of V1BankAccount value for items.
     */
    @JsonCreator
    public V1ListBankAccountsResponse(
            @JsonProperty("items") List<V1BankAccount> items) {
        this.items = items;
    }

    /**
     * Getter for Items.
     * @return Returns the List of V1BankAccount
     */
    @JsonGetter("items")
    public List<V1BankAccount> getItems() {
        return this.items;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ListBankAccountsResponse)) {
            return false;
        }
        V1ListBankAccountsResponse other = (V1ListBankAccountsResponse) obj;
        return Objects.equals(items, other.items);
    }

    /**
     * Builds a new {@link V1ListBankAccountsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ListBankAccountsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ListBankAccountsResponse}.
     */
    public static class Builder {
        private List<V1BankAccount> items;



        /**
         * Setter for items.
         * @param items List of V1BankAccount value for items.
         * @return Builder
         */
        public Builder items(List<V1BankAccount> items) {
            this.items = items;
            return this;
        }

        /**
         * Builds a new {@link V1ListBankAccountsResponse} object using the set fields.
         * @return {@link V1ListBankAccountsResponse}
         */
        public V1ListBankAccountsResponse build() {
            return new V1ListBankAccountsResponse(items);
        }
    }
}
