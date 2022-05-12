
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveCustomerCustomAttributeDefinitionRequest type.
 */
public class RetrieveCustomerCustomAttributeDefinitionRequest {
    private final Integer version;

    /**
     * Initialization constructor.
     * @param  version  Integer value for version.
     */
    @JsonCreator
    public RetrieveCustomerCustomAttributeDefinitionRequest(
            @JsonProperty("version") Integer version) {
        this.version = version;
    }

    /**
     * Getter for Version.
     * The current version of the custom attribute definition, which is used for strongly consistent
     * reads to guarantee that you receive the most up-to-date data. When included in the request,
     * Square returns the specified version or a higher version if one exists. If the specified
     * version is higher than the current version, Square returns a `BAD_REQUEST` error.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
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
        if (!(obj instanceof RetrieveCustomerCustomAttributeDefinitionRequest)) {
            return false;
        }
        RetrieveCustomerCustomAttributeDefinitionRequest other =
                (RetrieveCustomerCustomAttributeDefinitionRequest) obj;
        return Objects.equals(version, other.version);
    }

    /**
     * Converts this RetrieveCustomerCustomAttributeDefinitionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCustomerCustomAttributeDefinitionRequest [" + "version=" + version + "]";
    }

    /**
     * Builds a new {@link RetrieveCustomerCustomAttributeDefinitionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCustomerCustomAttributeDefinitionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCustomerCustomAttributeDefinitionRequest}.
     */
    public static class Builder {
        private Integer version;



        /**
         * Setter for version.
         * @param  version  Integer value for version.
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Builds a new {@link RetrieveCustomerCustomAttributeDefinitionRequest} object using the
         * set fields.
         * @return {@link RetrieveCustomerCustomAttributeDefinitionRequest}
         */
        public RetrieveCustomerCustomAttributeDefinitionRequest build() {
            return new RetrieveCustomerCustomAttributeDefinitionRequest(version);
        }
    }
}
