package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class V1ListBankAccountsResponse {

    @JsonCreator
    public V1ListBankAccountsResponse(
            @JsonProperty("items") List<V1BankAccount> items) {
        this.items = items;
    }

    private final List<V1BankAccount> items;

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof V1ListBankAccountsResponse)) {
            return false;
        }
        V1ListBankAccountsResponse v1ListBankAccountsResponse = (V1ListBankAccountsResponse) o;
        return Objects.equals(items, v1ListBankAccountsResponse.items);
    }

    /**
     * Getter for Items.
     */
    @JsonGetter("items")
    public List<V1BankAccount> getItems() { 
        return this.items;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .items(getItems());
            return builder;
    }

    public static class Builder {
        private List<V1BankAccount> items;

        public Builder() { }

        public Builder items(List<V1BankAccount> value) {
            items = value;
            return this;
        }

        public V1ListBankAccountsResponse build() {
            return new V1ListBankAccountsResponse(items);
        }
    }
}
