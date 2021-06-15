
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Objects;

/**
 * This is a model class for GiftCard type.
 */
public class GiftCard {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String id;
    private final String type;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String ganSource;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Money balanceMoney;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String gan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<String> customerIds;

    /**
     * Initialization constructor.
     * @param  type  String value for type.
     * @param  id  String value for id.
     * @param  ganSource  String value for ganSource.
     * @param  state  String value for state.
     * @param  balanceMoney  Money value for balanceMoney.
     * @param  gan  String value for gan.
     * @param  createdAt  String value for createdAt.
     * @param  customerIds  List of String value for customerIds.
     */
    @JsonCreator
    public GiftCard(
            @JsonProperty("type") String type,
            @JsonProperty("id") String id,
            @JsonProperty("gan_source") String ganSource,
            @JsonProperty("state") String state,
            @JsonProperty("balance_money") Money balanceMoney,
            @JsonProperty("gan") String gan,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("customer_ids") List<String> customerIds) {
        this.id = id;
        this.type = type;
        this.ganSource = ganSource;
        this.state = state;
        this.balanceMoney = balanceMoney;
        this.gan = gan;
        this.createdAt = createdAt;
        this.customerIds = customerIds;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the gift card.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * @return Returns the String
     */
    @JsonGetter("type")
    public String getType() {
        return type;
    }

    /**
     * Getter for GanSource.
     * Indicates the source that generated the gift card account number (GAN).
     * @return Returns the String
     */
    @JsonGetter("gan_source")
    public String getGanSource() {
        return ganSource;
    }

    /**
     * Getter for State.
     * Indicates the gift card state.
     * @return Returns the String
     */
    @JsonGetter("state")
    public String getState() {
        return state;
    }

    /**
     * Getter for BalanceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned. Fields that do not
     * explicitly define whether they are signed or unsigned are considered unsigned and can only
     * hold positive amounts. For signed fields, the sign of the value indicates the purpose of the
     * money transfer. See [Working with Monetary
     * Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts) for
     * more information.
     * @return Returns the Money
     */
    @JsonGetter("balance_money")
    public Money getBalanceMoney() {
        return balanceMoney;
    }

    /**
     * Getter for Gan.
     * The gift card account number.
     * @return Returns the String
     */
    @JsonGetter("gan")
    public String getGan() {
        return gan;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the gift card was created, in RFC 3339 format. In the case of a digital
     * gift card, it is the time when you create a card (using the Square Point of Sale application,
     * Seller Dashboard, or Gift Cards API). In the case of a plastic gift card, it is the time when
     * Square associates the card with the seller at the time of activation.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for CustomerIds.
     * The IDs of the customers to whom this gift card is linked.
     * @return Returns the List of String
     */
    @JsonGetter("customer_ids")
    public List<String> getCustomerIds() {
        return customerIds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, ganSource, state, balanceMoney, gan, createdAt,
                customerIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftCard)) {
            return false;
        }
        GiftCard other = (GiftCard) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(ganSource, other.ganSource)
            && Objects.equals(state, other.state)
            && Objects.equals(balanceMoney, other.balanceMoney)
            && Objects.equals(gan, other.gan)
            && Objects.equals(createdAt, other.createdAt)
            && Objects.equals(customerIds, other.customerIds);
    }

    /**
     * Converts this GiftCard into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "GiftCard [" + "type=" + type + ", id=" + id + ", ganSource=" + ganSource
                + ", state=" + state + ", balanceMoney=" + balanceMoney + ", gan=" + gan
                + ", createdAt=" + createdAt + ", customerIds=" + customerIds + "]";
    }

    /**
     * Builds a new {@link GiftCard.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link GiftCard.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type)
                .id(getId())
                .ganSource(getGanSource())
                .state(getState())
                .balanceMoney(getBalanceMoney())
                .gan(getGan())
                .createdAt(getCreatedAt())
                .customerIds(getCustomerIds());
        return builder;
    }

    /**
     * Class to build instances of {@link GiftCard}.
     */
    public static class Builder {
        private String type;
        private String id;
        private String ganSource;
        private String state;
        private Money balanceMoney;
        private String gan;
        private String createdAt;
        private List<String> customerIds;

        /**
         * Initialization constructor.
         * @param  type  String value for type.
         */
        public Builder(String type) {
            this.type = type;
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
         * Setter for id.
         * @param  id  String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for ganSource.
         * @param  ganSource  String value for ganSource.
         * @return Builder
         */
        public Builder ganSource(String ganSource) {
            this.ganSource = ganSource;
            return this;
        }

        /**
         * Setter for state.
         * @param  state  String value for state.
         * @return Builder
         */
        public Builder state(String state) {
            this.state = state;
            return this;
        }

        /**
         * Setter for balanceMoney.
         * @param  balanceMoney  Money value for balanceMoney.
         * @return Builder
         */
        public Builder balanceMoney(Money balanceMoney) {
            this.balanceMoney = balanceMoney;
            return this;
        }

        /**
         * Setter for gan.
         * @param  gan  String value for gan.
         * @return Builder
         */
        public Builder gan(String gan) {
            this.gan = gan;
            return this;
        }

        /**
         * Setter for createdAt.
         * @param  createdAt  String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for customerIds.
         * @param  customerIds  List of String value for customerIds.
         * @return Builder
         */
        public Builder customerIds(List<String> customerIds) {
            this.customerIds = customerIds;
            return this;
        }

        /**
         * Builds a new {@link GiftCard} object using the set fields.
         * @return {@link GiftCard}
         */
        public GiftCard build() {
            return new GiftCard(type, id, ganSource, state, balanceMoney, gan, createdAt,
                    customerIds);
        }
    }
}
