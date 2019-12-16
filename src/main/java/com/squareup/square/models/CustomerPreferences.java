package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CustomerPreferences {

    @JsonCreator
    public CustomerPreferences(
            @JsonProperty("email_unsubscribed") Boolean emailUnsubscribed) {
        this.emailUnsubscribed = emailUnsubscribed;
    }

    private final Boolean emailUnsubscribed;

    @Override
    public int hashCode() {
        return Objects.hash(emailUnsubscribed);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerPreferences)) {
            return false;
        }
        CustomerPreferences customerPreferences = (CustomerPreferences) o;
        return Objects.equals(emailUnsubscribed, customerPreferences.emailUnsubscribed);
    }

    /**
     * Getter for EmailUnsubscribed.
     * The customer has unsubscribed from receiving marketing campaign emails.
     */
    @JsonGetter("email_unsubscribed")
    public Boolean getEmailUnsubscribed() { 
        return this.emailUnsubscribed;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .emailUnsubscribed(getEmailUnsubscribed());
            return builder;
    }

    public static class Builder {
        private Boolean emailUnsubscribed;

        public Builder() { }

        public Builder emailUnsubscribed(Boolean value) {
            emailUnsubscribed = value;
            return this;
        }

        public CustomerPreferences build() {
            return new CustomerPreferences(emailUnsubscribed);
        }
    }
}
