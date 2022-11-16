
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apimatic.core.types.BaseModel;
import java.util.Objects;

/**
 * This is a model class for RetrieveOrderCustomAttributeDefinitionRequest type.
 */
public class RetrieveOrderCustomAttributeDefinitionRequest {
    private final Integer version;

    /**
     * Initialization constructor.
     * @param  version  Integer value for version.
     */
    @JsonCreator
    public RetrieveOrderCustomAttributeDefinitionRequest(
            @JsonProperty("version") Integer version) {
        this.version = version;
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

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RetrieveOrderCustomAttributeDefinitionRequest)) {
            return false;
        }
        RetrieveOrderCustomAttributeDefinitionRequest other =
                (RetrieveOrderCustomAttributeDefinitionRequest) obj;
        return Objects.equals(version, other.version);
    }

    /**
     * Converts this RetrieveOrderCustomAttributeDefinitionRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RetrieveOrderCustomAttributeDefinitionRequest [" + "version=" + version + "]";
    }

    /**
     * Builds a new {@link RetrieveOrderCustomAttributeDefinitionRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RetrieveOrderCustomAttributeDefinitionRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link RetrieveOrderCustomAttributeDefinitionRequest}.
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
         * Builds a new {@link RetrieveOrderCustomAttributeDefinitionRequest} object using the set
         * fields.
         * @return {@link RetrieveOrderCustomAttributeDefinitionRequest}
         */
        public RetrieveOrderCustomAttributeDefinitionRequest build() {
            return new RetrieveOrderCustomAttributeDefinitionRequest(version);
        }
    }
}
