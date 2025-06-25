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
 * This is a model class for DestinationDetailsExternalRefundDetails type.
 */
public class DestinationDetailsExternalRefundDetails {
    private final String type;
    private final String source;
    private final OptionalNullable<String> sourceId;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  source  String value for source.
     * @param  sourceId  String value for sourceId.
     */
    @JsonCreator
    public DestinationDetailsExternalRefundDetails(
            @JsonProperty("type") String type,
            @JsonProperty("source") String source,
            @JsonProperty("source_id") String sourceId) {
        this.type = type;
        this.source = source;
        this.sourceId = OptionalNullable.of(sourceId);
    }

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  source  String value for source.
     * @param  sourceId  String value for sourceId.
     */
    protected DestinationDetailsExternalRefundDetails(String type, String source, OptionalNullable<String> sourceId) {
        this.type = type;
        this.source = source;
        this.sourceId = sourceId;
    }

    /**
     * Getter for Type.
     * The type of external refund the seller paid to the buyer. It can be one of the following: -
     * CHECK - Refunded using a physical check. - BANK_TRANSFER - Refunded using external bank
     * transfer. - OTHER\\_GIFT\\_CARD - Refunded using a non-Square gift card. - CRYPTO - Refunded
     * using a crypto currency. - SQUARE_CASH - Refunded using Square Cash App. - SOCIAL - Refunded
     * using peer-to-peer payment applications. - EXTERNAL - A third-party application gathered this
     * refund outside of Square. - EMONEY - Refunded using an E-money provider. - CARD - A credit or
     * debit card that Square does not support. - STORED_BALANCE - Use for house accounts, store
     * credit, and so forth. - FOOD_VOUCHER - Restaurant voucher provided by employers to employees
     * to pay for meals - OTHER - A type not listed here.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for Source.
     * A description of the external refund source. For example, "Food Delivery Service".
     * @return Returns the String
     */
    @JsonGetter("source")
    public String getSource() {
        return source;
    }

    /**
     * Internal Getter for SourceId.
     * An ID to associate the refund to its originating source.
     * @return Returns the Internal String
     */
    @JsonGetter("source_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetSourceId() {
        return this.sourceId;
    }

    /**
     * Getter for SourceId.
     * An ID to associate the refund to its originating source.
     * @return Returns the String
     */
    @JsonIgnore
    public String getSourceId() {
        return OptionalNullable.getFrom(sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, source, sourceId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DestinationDetailsExternalRefundDetails)) {
            return false;
        }
        DestinationDetailsExternalRefundDetails other = (DestinationDetailsExternalRefundDetails) obj;
        return Objects.equals(type, other.type)
                && Objects.equals(source, other.source)
                && Objects.equals(sourceId, other.sourceId);
    }

    /**
     * Converts this DestinationDetailsExternalRefundDetails into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "DestinationDetailsExternalRefundDetails [" + "type=" + type + ", source=" + source + ", sourceId="
                + sourceId + "]";
    }

    /**
     * Builds a new {@link DestinationDetailsExternalRefundDetails.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DestinationDetailsExternalRefundDetails.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type, source);
        builder.sourceId = internalGetSourceId();
        return builder;
    }

    /**
     * Class to build instances of {@link DestinationDetailsExternalRefundDetails}.
     */
    public static class Builder {
        private String type;
        private String source;
        private OptionalNullable<String> sourceId;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         * @param  source  String value for source.
         */
        public Builder(String type, String source) {
            this.type = type;
            this.source = source;
        }

        /**
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for source.
         * @param  source  String value for source.
         * @return Builder
         */
        public Builder source(String source) {
            this.source = source;
            return this;
        }

        /**
         * Setter for sourceId.
         * @param  sourceId  String value for sourceId.
         * @return Builder
         */
        public Builder sourceId(String sourceId) {
            this.sourceId = OptionalNullable.of(sourceId);
            return this;
        }

        /**
         * UnSetter for sourceId.
         * @return Builder
         */
        public Builder unsetSourceId() {
            sourceId = null;
            return this;
        }

        /**
         * Builds a new {@link DestinationDetailsExternalRefundDetails} object using the set fields.
         * @return {@link DestinationDetailsExternalRefundDetails}
         */
        public DestinationDetailsExternalRefundDetails build() {
            return new DestinationDetailsExternalRefundDetails(type, source, sourceId);
        }
    }
}
