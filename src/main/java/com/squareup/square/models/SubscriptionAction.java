
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for SubscriptionAction type.
 */
public class SubscriptionAction {
    private final String id;
    private final String type;
    private final String effectiveDate;
    private final String newPlanId;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  type  String value for type.
     * @param  effectiveDate  String value for effectiveDate.
     * @param  newPlanId  String value for newPlanId.
     */
    @JsonCreator
    public SubscriptionAction(
            @JsonProperty("id") String id,
            @JsonProperty("type") String type,
            @JsonProperty("effective_date") String effectiveDate,
            @JsonProperty("new_plan_id") String newPlanId) {
        this.id = id;
        this.type = type;
        this.effectiveDate = effectiveDate;
        this.newPlanId = newPlanId;
    }

    /**
     * Getter for Id.
     * The ID of an action scoped to a subscription.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Type.
     * Supported types of an action as a pending change to a subscription.
     * @return Returns the String
     */
    @JsonGetter("type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getType() {
        return type;
    }

    /**
     * Getter for EffectiveDate.
     * The `YYYY-MM-DD`-formatted date when the action occurs on the subscription.
     * @return Returns the String
     */
    @JsonGetter("effective_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Getter for NewPlanId.
     * The target subscription plan a subscription switches to, for a `SWAP_PLAN` action.
     * @return Returns the String
     */
    @JsonGetter("new_plan_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNewPlanId() {
        return newPlanId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, effectiveDate, newPlanId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubscriptionAction)) {
            return false;
        }
        SubscriptionAction other = (SubscriptionAction) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(type, other.type)
            && Objects.equals(effectiveDate, other.effectiveDate)
            && Objects.equals(newPlanId, other.newPlanId);
    }

    /**
     * Converts this SubscriptionAction into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "SubscriptionAction [" + "id=" + id + ", type=" + type + ", effectiveDate="
                + effectiveDate + ", newPlanId=" + newPlanId + "]";
    }

    /**
     * Builds a new {@link SubscriptionAction.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionAction.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .id(getId())
                .type(getType())
                .effectiveDate(getEffectiveDate())
                .newPlanId(getNewPlanId());
        return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionAction}.
     */
    public static class Builder {
        private String id;
        private String type;
        private String effectiveDate;
        private String newPlanId;



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
         * Setter for type.
         * @param  type  String value for type.
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * Setter for effectiveDate.
         * @param  effectiveDate  String value for effectiveDate.
         * @return Builder
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * Setter for newPlanId.
         * @param  newPlanId  String value for newPlanId.
         * @return Builder
         */
        public Builder newPlanId(String newPlanId) {
            this.newPlanId = newPlanId;
            return this;
        }

        /**
         * Builds a new {@link SubscriptionAction} object using the set fields.
         * @return {@link SubscriptionAction}
         */
        public SubscriptionAction build() {
            return new SubscriptionAction(id, type, effectiveDate, newPlanId);
        }
    }
}
