
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RetrieveCustomerCustomAttributeRequest type.
 */
public class RetrieveCustomerCustomAttributeRequest {
    private final Boolean withDefinition;
    private final Integer version;

    /**
     * Initialization constructor.
     * @param  withDefinition  Boolean value for withDefinition.
     * @param  version  Integer value for version.
     */
    @JsonCreator
    public RetrieveCustomerCustomAttributeRequest(
            @JsonProperty("with_definition") Boolean withDefinition,
            @JsonProperty("version") Integer version) {
        this.withDefinition = withDefinition;
        this.version = version;
    }

    /**
     * Getter for WithDefinition.
     * Indicates whether to return the [custom attribute definition]($m/CustomAttributeDefinition)
     * in the `definition` field of the custom attribute. Set this parameter to `true` to get the
     * name and description of the custom attribute, information about the data type, or other
     * definition details. The default value is `false`.
     * @return Returns the Boolean
     */
    @JsonGetter("with_definition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean getWithDefinition() {
        return withDefinition;
    }

    /**
     * Getter for Version.
     * The current version of the custom attribute, which is used for strongly consistent reads to
     * guarantee that you receive the most up-to-date data. When included in the request, Square
     * returns the specified version or a higher version if one exists. If the specified version is
     * higher than the current version, Square returns a `BAD_REQUEST` error.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(withDefinition, version);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveCustomerCustomAttributeRequest)) {
            return false;
        }
        RetrieveCustomerCustomAttributeRequest other = (RetrieveCustomerCustomAttributeRequest) obj;
        return Objects.equals(withDefinition, other.withDefinition)
            && Objects.equals(version, other.version);
    }

    /**
     * Converts this RetrieveCustomerCustomAttributeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveCustomerCustomAttributeRequest [" + "withDefinition=" + withDefinition
                + ", version=" + version + "]";
    }

    /**
     * Builds a new {@link RetrieveCustomerCustomAttributeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveCustomerCustomAttributeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .withDefinition(getWithDefinition())
                .version(getVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveCustomerCustomAttributeRequest}.
     */
    public static class Builder {
        private Boolean withDefinition;
        private Integer version;



        /**
         * Setter for withDefinition.
         * @param  withDefinition  Boolean value for withDefinition.
         * @return Builder
         */
        public Builder withDefinition(Boolean withDefinition) {
            this.withDefinition = withDefinition;
            return this;
        }

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
         * Builds a new {@link RetrieveCustomerCustomAttributeRequest} object using the set fields.
         * @return {@link RetrieveCustomerCustomAttributeRequest}
         */
        public RetrieveCustomerCustomAttributeRequest build() {
            return new RetrieveCustomerCustomAttributeRequest(withDefinition, version);
        }
    }
}
