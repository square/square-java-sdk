
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for RetrieveOrderCustomAttributeRequest type.
 */
public class RetrieveOrderCustomAttributeRequest {
    private final Integer version;
    private final OptionalNullable<Boolean> withDefinition;

    /**
     * Initialization constructor.
     * @param  version  Integer value for version.
     * @param  withDefinition  Boolean value for withDefinition.
     */
    @JsonCreator
    public RetrieveOrderCustomAttributeRequest(
            @JsonProperty("version") Integer version,
            @JsonProperty("with_definition") Boolean withDefinition) {
        this.version = version;
        this.withDefinition = OptionalNullable.of(withDefinition);
    }

    /**
     * Internal initialization constructor.
     */
    protected RetrieveOrderCustomAttributeRequest(Integer version,
            OptionalNullable<Boolean> withDefinition) {
        this.version = version;
        this.withDefinition = withDefinition;
    }

    /**
     * Getter for Version.
     * To enable [optimistic
     * concurrency](https://developer.squareup.com/docs/build-basics/common-api-patterns/optimistic-concurrency)
     * control, include this optional field and specify the current version of the custom attribute.
     * @return Returns the Integer
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getVersion() {
        return version;
    }

    /**
     * Internal Getter for WithDefinition.
     * Indicates whether to return the [custom attribute
     * definition](entity:CustomAttributeDefinition) in the `definition` field of each custom
     * attribute. Set this parameter to `true` to get the name and description of each custom
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
     * definition](entity:CustomAttributeDefinition) in the `definition` field of each custom
     * attribute. Set this parameter to `true` to get the name and description of each custom
     * attribute, information about the data type, or other definition details. The default value is
     * `false`.
     * @return Returns the Boolean
     */
    @JsonIgnore
    public Boolean getWithDefinition() {
        return OptionalNullable.getFrom(withDefinition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, withDefinition);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveOrderCustomAttributeRequest)) {
            return false;
        }
        RetrieveOrderCustomAttributeRequest other = (RetrieveOrderCustomAttributeRequest) obj;
        return Objects.equals(version, other.version)
            && Objects.equals(withDefinition, other.withDefinition);
    }

    /**
     * Converts this RetrieveOrderCustomAttributeRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveOrderCustomAttributeRequest [" + "version=" + version + ", withDefinition="
                + withDefinition + "]";
    }

    /**
     * Builds a new {@link RetrieveOrderCustomAttributeRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveOrderCustomAttributeRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion());
        builder.withDefinition = internalGetWithDefinition();
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveOrderCustomAttributeRequest}.
     */
    public static class Builder {
        private Integer version;
        private OptionalNullable<Boolean> withDefinition;



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
         * Builds a new {@link RetrieveOrderCustomAttributeRequest} object using the set fields.
         * @return {@link RetrieveOrderCustomAttributeRequest}
         */
        public RetrieveOrderCustomAttributeRequest build() {
            return new RetrieveOrderCustomAttributeRequest(version, withDefinition);
        }
    }
}
