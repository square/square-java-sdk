
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for OfflinePaymentDetails type.
 */
public class OfflinePaymentDetails {
    private final String clientCreatedAt;

    /**
     * Initialization constructor.
     * @param  clientCreatedAt  String value for clientCreatedAt.
     */
    @JsonCreator
    public OfflinePaymentDetails(
            @JsonProperty("client_created_at") String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    /**
     * Getter for ClientCreatedAt.
     * The client-side timestamp of when the offline payment was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("client_created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientCreatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OfflinePaymentDetails)) {
            return false;
        }
        OfflinePaymentDetails other = (OfflinePaymentDetails) obj;
        return Objects.equals(clientCreatedAt, other.clientCreatedAt);
    }

    /**
     * Converts this OfflinePaymentDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "OfflinePaymentDetails [" + "clientCreatedAt=" + clientCreatedAt + "]";
    }

    /**
     * Builds a new {@link OfflinePaymentDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OfflinePaymentDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .clientCreatedAt(getClientCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link OfflinePaymentDetails}.
     */
    public static class Builder {
        private String clientCreatedAt;



        /**
         * Setter for clientCreatedAt.
         * @param  clientCreatedAt  String value for clientCreatedAt.
         * @return Builder
         */
        public Builder clientCreatedAt(String clientCreatedAt) {
            this.clientCreatedAt = clientCreatedAt;
            return this;
        }

        /**
         * Builds a new {@link OfflinePaymentDetails} object using the set fields.
         * @return {@link OfflinePaymentDetails}
         */
        public OfflinePaymentDetails build() {
            return new OfflinePaymentDetails(clientCreatedAt);
        }
    }
}
