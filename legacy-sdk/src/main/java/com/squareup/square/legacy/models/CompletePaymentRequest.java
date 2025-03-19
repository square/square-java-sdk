package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CompletePaymentRequest type.
 */
public class CompletePaymentRequest {
    private final OptionalNullable<String> versionToken;

    /**
     * Initialization constructor.
     * @param  versionToken  String value for versionToken.
     */
    @JsonCreator
    public CompletePaymentRequest(@JsonProperty("version_token") String versionToken) {
        this.versionToken = OptionalNullable.of(versionToken);
    }

    /**
     * Initialization constructor.
     * @param  versionToken  String value for versionToken.
     */
    protected CompletePaymentRequest(OptionalNullable<String> versionToken) {
        this.versionToken = versionToken;
    }

    /**
     * Internal Getter for VersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned.
     * @return Returns the Internal String
     */
    @JsonGetter("version_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetVersionToken() {
        return this.versionToken;
    }

    /**
     * Getter for VersionToken.
     * Used for optimistic concurrency. This opaque token identifies the current `Payment` version
     * that the caller expects. If the server has a different version of the Payment, the update
     * fails and a response with a VERSION_MISMATCH error is returned.
     * @return Returns the String
     */
    @JsonIgnore
    public String getVersionToken() {
        return OptionalNullable.getFrom(versionToken);
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
        Builder builder = new Builder();
        builder.versionToken = internalGetVersionToken();
        return builder;
    }

    /**
     * Class to build instances of {@link CompletePaymentRequest}.
     */
    public static class Builder {
        private OptionalNullable<String> versionToken;

        /**
         * Setter for versionToken.
         * @param  versionToken  String value for versionToken.
         * @return Builder
         */
        public Builder versionToken(String versionToken) {
            this.versionToken = OptionalNullable.of(versionToken);
            return this;
        }

        /**
         * UnSetter for versionToken.
         * @return Builder
         */
        public Builder unsetVersionToken() {
            versionToken = null;
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
