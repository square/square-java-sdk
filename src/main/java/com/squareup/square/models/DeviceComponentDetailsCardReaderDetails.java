
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for DeviceComponentDetailsCardReaderDetails type.
 */
public class DeviceComponentDetailsCardReaderDetails {
    private final String version;

    /**
     * Initialization constructor.
     * @param  version  String value for version.
     */
    @JsonCreator
    public DeviceComponentDetailsCardReaderDetails(
            @JsonProperty("version") String version) {
        this.version = version;
    }

    /**
     * Getter for Version.
     * The version of the card reader.
     * @return Returns the String
     */
    @JsonGetter("version")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getVersion() {
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
        if (!(obj instanceof DeviceComponentDetailsCardReaderDetails)) {
            return false;
        }
        DeviceComponentDetailsCardReaderDetails other =
                (DeviceComponentDetailsCardReaderDetails) obj;
        return Objects.equals(version, other.version);
    }

    /**
     * Converts this DeviceComponentDetailsCardReaderDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DeviceComponentDetailsCardReaderDetails [" + "version=" + version + "]";
    }

    /**
     * Builds a new {@link DeviceComponentDetailsCardReaderDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeviceComponentDetailsCardReaderDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .version(getVersion());
        return builder;
    }

    /**
     * Class to build instances of {@link DeviceComponentDetailsCardReaderDetails}.
     */
    public static class Builder {
        private String version;



        /**
         * Setter for version.
         * @param  version  String value for version.
         * @return Builder
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }

        /**
         * Builds a new {@link DeviceComponentDetailsCardReaderDetails} object using the set fields.
         * @return {@link DeviceComponentDetailsCardReaderDetails}
         */
        public DeviceComponentDetailsCardReaderDetails build() {
            return new DeviceComponentDetailsCardReaderDetails(version);
        }
    }
}
