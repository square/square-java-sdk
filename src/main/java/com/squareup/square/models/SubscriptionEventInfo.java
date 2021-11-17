
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SubscriptionEventInfo type.
 */
public class SubscriptionEventInfo {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String detail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String code;

    /**
     * Initialization constructor.
     * @param  detail  String value for detail.
     * @param  code  String value for code.
     */
    @JsonCreator
    public SubscriptionEventInfo(
            @JsonProperty("detail") String detail,
            @JsonProperty("code") String code) {
        this.detail = detail;
        this.code = code;
    }

    /**
     * Getter for Detail.
     * A human-readable explanation for the event.
     * @return Returns the String
     */
    @JsonGetter("detail")
    public String getDetail() {
        return detail;
    }

    /**
     * Getter for Code.
     * Supported info codes of a subscription event.
     * @return Returns the String
     */
    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, code);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionEventInfo)) {
            return false;
        }
        SubscriptionEventInfo other = (SubscriptionEventInfo) obj;
        return Objects.equals(detail, other.detail)
            && Objects.equals(code, other.code);
    }

    /**
     * Converts this SubscriptionEventInfo into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionEventInfo [" + "detail=" + detail + ", code=" + code + "]";
    }

    /**
     * Builds a new {@link SubscriptionEventInfo.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionEventInfo.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .detail(getDetail())
                .code(getCode());
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionEventInfo}.
     */
    public static class Builder {
        private String detail;
        private String code;



        /**
         * Setter for detail.
         * @param  detail  String value for detail.
         * @return Builder
         */
        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        /**
         * Setter for code.
         * @param  code  String value for code.
         * @return Builder
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionEventInfo} object using the set fields.
         * @return {@link SubscriptionEventInfo}
         */
        public SubscriptionEventInfo build() {
            return new SubscriptionEventInfo(detail, code);
        }
    }
}
