package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CustomerPreferences type.
 */
public class CustomerPreferences {

    /**
     * Initialization constructor.
     * @param emailUnsubscribed
     */
    @JsonCreator
    public CustomerPreferences(
            @JsonProperty("email_unsubscribed") Boolean emailUnsubscribed) {
        this.emailUnsubscribed = emailUnsubscribed;
    }

    private final Boolean emailUnsubscribed;
    /**
     * Getter for EmailUnsubscribed.
     * The customer has unsubscribed from receiving marketing campaign emails.
     */
    @JsonGetter("email_unsubscribed")
    public Boolean getEmailUnsubscribed() {
        return this.emailUnsubscribed;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(emailUnsubscribed);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CustomerPreferences)) {
            return false;
        }
        CustomerPreferences customerPreferences = (CustomerPreferences) obj;
        return Objects.equals(emailUnsubscribed, customerPreferences.emailUnsubscribed);
    }

    /**
     * Builds a new {@link CustomerPreferences.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CustomerPreferences.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .emailUnsubscribed(getEmailUnsubscribed());
            return builder;
    }

    /**
     * Class to build instances of {@link CustomerPreferences}
     */
    public static class Builder {
        private Boolean emailUnsubscribed;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for emailUnsubscribed
         * @param emailUnsubscribed
         * @return Builder
         */
        public Builder emailUnsubscribed(Boolean emailUnsubscribed) {
            this.emailUnsubscribed = emailUnsubscribed;
            return this;
        }

        /**
         * Builds a new {@link CustomerPreferences} object using the set fields.
         * @return {@link CustomerPreferences}
         */
        public CustomerPreferences build() {
            return new CustomerPreferences(emailUnsubscribed);
        }
    }
}
