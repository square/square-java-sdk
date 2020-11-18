
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for UpdateWageSettingRequest type.
 */
public class UpdateWageSettingRequest {
    private final WageSetting wageSetting;

    /**
     * Initialization constructor.
     * @param wageSetting WageSetting value for wageSetting.
     */
    @JsonCreator
    public UpdateWageSettingRequest(
            @JsonProperty("wage_setting") WageSetting wageSetting) {
        this.wageSetting = wageSetting;
    }

    /**
     * Getter for WageSetting.
     * An object representing a team member's wage information.
     * @return Returns the WageSetting
     */
    @JsonGetter("wage_setting")
    public WageSetting getWageSetting() {
        return this.wageSetting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wageSetting);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpdateWageSettingRequest)) {
            return false;
        }
        UpdateWageSettingRequest other = (UpdateWageSettingRequest) obj;
        return Objects.equals(wageSetting, other.wageSetting);
    }

    /**
     * Converts this UpdateWageSettingRequest into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "UpdateWageSettingRequest [" + "wageSetting=" + wageSetting + "]";
    }

    /**
     * Builds a new {@link UpdateWageSettingRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateWageSettingRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(wageSetting);
        return builder;
    }

    /**
     * Class to build instances of {@link UpdateWageSettingRequest}.
     */
    public static class Builder {
        private WageSetting wageSetting;

        /**
         * Initialization constructor.
         * @param wageSetting WageSetting value for wageSetting.
         */
        public Builder(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
        }

        /**
         * Setter for wageSetting.
         * @param wageSetting WageSetting value for wageSetting.
         * @return Builder
         */
        public Builder wageSetting(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
            return this;
        }

        /**
         * Builds a new {@link UpdateWageSettingRequest} object using the set fields.
         * @return {@link UpdateWageSettingRequest}
         */
        public UpdateWageSettingRequest build() {
            return new UpdateWageSettingRequest(wageSetting);
        }
    }
}
