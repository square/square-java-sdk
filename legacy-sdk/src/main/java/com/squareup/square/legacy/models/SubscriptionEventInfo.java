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
 * This is a model class for SubscriptionEventInfo type.
 */
public class SubscriptionEventInfo {
    private final OptionalNullable<String> detail;
    private final String code;

    /**
     * Initialization constructor.
     * @param  detail  String value for detail.
     * @param  code  String value for code.
     */
    @JsonCreator
    public SubscriptionEventInfo(@JsonProperty("detail") String detail, @JsonProperty("code") String code) {
        this.detail = OptionalNullable.of(detail);
        this.code = code;
    }

    /**
     * Initialization constructor.
     * @param  detail  String value for detail.
     * @param  code  String value for code.
     */
    protected SubscriptionEventInfo(OptionalNullable<String> detail, String code) {
        this.detail = detail;
        this.code = code;
    }

    /**
     * Internal Getter for Detail.
     * A human-readable explanation for the event.
     * @return Returns the Internal String
     */
    @JsonGetter("detail")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDetail() {
        return this.detail;
    }

    /**
     * Getter for Detail.
     * A human-readable explanation for the event.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDetail() {
        return OptionalNullable.getFrom(detail);
    }

    /**
     * Getter for Code.
     * Supported info codes of a subscription event.
     * @return Returns the String
     */
    @JsonGetter("code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
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
        return Objects.equals(detail, other.detail) && Objects.equals(code, other.code);
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
        Builder builder = new Builder().code(getCode());
        builder.detail = internalGetDetail();
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionEventInfo}.
     */
    public static class Builder {
        private OptionalNullable<String> detail;
        private String code;

        /**
         * Setter for detail.
         * @param  detail  String value for detail.
         * @return Builder
         */
        public Builder detail(String detail) {
            this.detail = OptionalNullable.of(detail);
            return this;
        }

        /**
         * UnSetter for detail.
         * @return Builder
         */
        public Builder unsetDetail() {
            detail = null;
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
