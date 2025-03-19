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
 * This is a model class for RetrieveMerchantCustomAttributeRequest type.
 */
public class RetrieveMerchantCustomAttributeRequest {
    private final OptionalNullable<Boolean> withDefinition;
    private final Integer version;

    /**
     * Initialization constructor.
     * @param  withDefinition  Boolean value for withDefinition.
     * @param  version  Integer value for version.
     */
    @JsonCreator
    public RetrieveMerchantCustomAttributeRequest(
            @JsonProperty("with_definition") Boolean withDefinition, @JsonProperty("version") Integer version) {
        this.withDefinition = OptionalNullable.of(withDefinition);
        this.version = version;
    }

    /**
     * Initialization constructor.
     * @param  withDefinition  Boolean value for withDefinition.
     * @param  version  Integer value for version.
     */
    protected RetrieveMerchantCustomAttributeRequest(OptionalNullable<Boolean> withDefinition, Integer version) {
        this.withDefinition = withDefinition;
        this.version = version;
    }

    /**
     * Internal Getter for WithDefinition.
     * Indicates whether to return the [custom attribute
     * definition](entity:CustomAttributeDefinition) in the `definition` field of the custom
     * attribute. Set this parameter to `true` to get the name and description of the custom
     * attribute, information about the data type, or other definition details. The default value is
     * `false`.
     * @return Returns the Internal Boolean
     */
    @JsonGetter("with_definition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Boolean> internalGetWithDefinition() {
        return this.withDefinition;
    }

    /**
     * Getter for WithDefinition.
     * Indicates whether to return the [custom attribute
     * definition](entity:CustomAttributeDefinition) in the `definition` field of the custom
     * attribute. Set this parameter to `true` to get the name and description of the custom
     * attribute, information about the data type, or other definition details. The default value is
     * `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getWithDefinition() {
        return OptionalNullable.getFrom(withDefinition);
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
        if (!(obj instanceof RetrieveMerchantCustomAttributeRequest)) {
            return false;
        }
        RetrieveMerchantCustomAttributeRequest other = (RetrieveMerchantCustomAttributeRequest) obj;
        return Objects.equals(withDefinition, other.withDefinition) && Objects.equals(version, other.version);
    }

    /**
     * Converts this RetrieveMerchantCustomAttributeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveMerchantCustomAttributeRequest [" + "withDefinition=" + withDefinition + ", version=" + version
                + "]";
    }

    /**
     * Builds a new {@link RetrieveMerchantCustomAttributeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveMerchantCustomAttributeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder().version(getVersion());
        builder.withDefinition = internalGetWithDefinition();
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveMerchantCustomAttributeRequest}.
     */
    public static class Builder {
        private OptionalNullable<Boolean> withDefinition;
        private Integer version;

        /**
         * Setter for withDefinition.
         * @param  withDefinition  Boolean value for withDefinition.
         * @return Builder
         */
        public Builder withDefinition(Boolean withDefinition) {
            this.withDefinition = OptionalNullable.of(withDefinition);
            return this;
        }

        /**
         * UnSetter for withDefinition.
         * @return Builder
         */
        public Builder unsetWithDefinition() {
            withDefinition = null;
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
         * Builds a new {@link RetrieveMerchantCustomAttributeRequest} object using the set fields.
         * @return {@link RetrieveMerchantCustomAttributeRequest}
         */
        public RetrieveMerchantCustomAttributeRequest build() {
            return new RetrieveMerchantCustomAttributeRequest(withDefinition, version);
        }
    }
}
