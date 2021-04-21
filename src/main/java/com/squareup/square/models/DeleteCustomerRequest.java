
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeleteCustomerRequest type.
 */
public class DeleteCustomerRequest {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Long version;

    /**
     * Initialization constructor.
     * @param  version  Long value for version.
     */
    @JsonCreator
    public DeleteCustomerRequest(
            @JsonProperty("version") Long version) {
        this.version = version;
    }

    /**
     * Getter for Version.
     * The current version of the customer profile. As a best practice, you should include this
     * parameter to enable [optimistic
     * concurrency](https://developer.squareup.com/docs/working-with-apis/optimistic-concurrency)
     * control. For more information, see [Delete a customer
     * profile](https://developer.squareup.com/docs/customers-api/use-the-api/keep-records#delete-customer-profile).
     * @return Returns the Long
     */
    @JsonGetter("version")
    public Long getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeleteCustomerRequest)) {
            return false;
        }
        DeleteCustomerRequest other = (DeleteCustomerRequest) obj;
        return Objects.equals(version, other.version);
    }

    /**
     * Converts this DeleteCustomerRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeleteCustomerRequest [" + "version=" + version + "]";
    }

    /**
     * Builds a new {@link DeleteCustomerRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeleteCustomerRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link DeleteCustomerRequest}.
     */
    public static class Builder {
        private Long version;



        /**
         * Setter for version.
         * @param  version  Long value for version.
         * @return Builder
         */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        /**
         * Builds a new {@link DeleteCustomerRequest} object using the set fields.
         * @return {@link DeleteCustomerRequest}
         */
        public DeleteCustomerRequest build() {
            return new DeleteCustomerRequest(version);
        }
    }
}
