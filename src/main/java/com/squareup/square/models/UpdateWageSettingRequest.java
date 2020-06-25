package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateWageSettingRequest type.
 */
public class UpdateWageSettingRequest {

    /**
     * Initialization constructor.
     * @param wageSetting
     */
    @JsonCreator
    public UpdateWageSettingRequest(
            @JsonProperty("wage_setting") WageSetting wageSetting) {
        this.wageSetting = wageSetting;
    }

    private final WageSetting wageSetting;
    /**
     * Getter for WageSetting.
     * An object representing a team member's wage information.
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
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateWageSettingRequest)) {
            return false;
        }
        UpdateWageSettingRequest updateWageSettingRequest = (UpdateWageSettingRequest) obj;
        return Objects.equals(wageSetting, updateWageSettingRequest.wageSetting);
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
     * Class to build instances of {@link UpdateWageSettingRequest}
     */
    public static class Builder {
        private WageSetting wageSetting;

        /**
         * Initialization constructor
         */
        public Builder(WageSetting wageSetting) {
            this.wageSetting = wageSetting;
        }

        /**
         * Setter for wageSetting
         * @param wageSetting
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
