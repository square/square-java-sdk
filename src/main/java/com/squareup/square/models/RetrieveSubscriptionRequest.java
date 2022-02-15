
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveSubscriptionRequest type.
 */
public class RetrieveSubscriptionRequest {
    private final String include;

    /**
     * Initialization constructor.
     * @param  include  String value for include.
     */
    @JsonCreator
    public RetrieveSubscriptionRequest(
            @JsonProperty("include") String include) {
        this.include = include;
    }

    /**
     * Getter for Include.
     * A query parameter to specify related information to be included in the response. The
     * supported query parameter values are: - `actions`: to include scheduled actions on the
     * targeted subscription.
     * @return Returns the String
     */
    @JsonGetter("include")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getInclude() {
        return include;
    }

    @Override
    public int hashCode() {
        return Objects.hash(include);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveSubscriptionRequest)) {
            return false;
        }
        RetrieveSubscriptionRequest other = (RetrieveSubscriptionRequest) obj;
        return Objects.equals(include, other.include);
    }

    /**
     * Converts this RetrieveSubscriptionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveSubscriptionRequest [" + "include=" + include + "]";
    }

    /**
     * Builds a new {@link RetrieveSubscriptionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveSubscriptionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .include(getInclude());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveSubscriptionRequest}.
     */
    public static class Builder {
        private String include;



        /**
         * Setter for include.
         * @param  include  String value for include.
         * @return Builder
         */
        public Builder include(String include) {
            this.include = include;
            return this;
        }

        /**
         * Builds a new {@link RetrieveSubscriptionRequest} object using the set fields.
         * @return {@link RetrieveSubscriptionRequest}
         */
        public RetrieveSubscriptionRequest build() {
            return new RetrieveSubscriptionRequest(include);
        }
    }
}
