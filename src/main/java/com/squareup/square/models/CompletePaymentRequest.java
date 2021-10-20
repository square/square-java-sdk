
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for CompletePaymentRequest type.
 */
public class CompletePaymentRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String versionToken;

    /**
     * Initialization constructor.
     * @param  versionToken  String value for versionToken.
     */
    @JsonCreator
    public CompletePaymentRequest(
            @JsonProperty("version_token") String versionToken) {
        this.versionToken = versionToken;
    }

    /**
     * Getter for VersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned.
     * @return Returns the String
     */
    @JsonGetter("version_token")
    public String getVersionToken() {
        return versionToken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CompletePaymentRequest)) {
            return false;
        }
        CompletePaymentRequest other = (CompletePaymentRequest) obj;
        return Objects.equals(versionToken, other.versionToken);
    }

    /**
     * Converts this CompletePaymentRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CompletePaymentRequest [" + "versionToken=" + versionToken + "]";
    }

    /**
     * Builds a new {@link CompletePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CompletePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .versionToken(getVersionToken());
        return builder;
    }

    /**
     * Class to build instances of {@link CompletePaymentRequest}.
     */
    public static class Builder {
        private String versionToken;



        /**
         * Setter for versionToken.
         * @param  versionToken  String value for versionToken.
         * @return Builder
         */
        public Builder versionToken(String versionToken) {
            this.versionToken = versionToken;
            return this;
        }

        /**
         * Builds a new {@link CompletePaymentRequest} object using the set fields.
         * @return {@link CompletePaymentRequest}
         */
        public CompletePaymentRequest build() {
            return new CompletePaymentRequest(versionToken);
        }
    }
}
