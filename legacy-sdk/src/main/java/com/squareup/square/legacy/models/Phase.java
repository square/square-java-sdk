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
 * This is a model class for Phase type.
 */
public class Phase {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<Long> ordinal;
    private final OptionalNullable<String> orderTemplateId;
    private final OptionalNullable<String> planPhaseUid;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  ordinal  Long value for ordinal.
     * @param  orderTemplateId  String value for orderTemplateId.
     * @param  planPhaseUid  String value for planPhaseUid.
     */
    @JsonCreator
    public Phase(
            @JsonProperty("uid") String uid,
            @JsonProperty("ordinal") Long ordinal,
            @JsonProperty("order_template_id") String orderTemplateId,
            @JsonProperty("plan_phase_uid") String planPhaseUid) {
        this.uid = OptionalNullable.of(uid);
        this.ordinal = OptionalNullable.of(ordinal);
        this.orderTemplateId = OptionalNullable.of(orderTemplateId);
        this.planPhaseUid = OptionalNullable.of(planPhaseUid);
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  ordinal  Long value for ordinal.
     * @param  orderTemplateId  String value for orderTemplateId.
     * @param  planPhaseUid  String value for planPhaseUid.
     */
    protected Phase(
            OptionalNullable<String> uid,
            OptionalNullable<Long> ordinal,
            OptionalNullable<String> orderTemplateId,
            OptionalNullable<String> planPhaseUid) {
        this.uid = uid;
        this.ordinal = ordinal;
        this.orderTemplateId = orderTemplateId;
        this.planPhaseUid = planPhaseUid;
    }

    /**
     * Internal Getter for Uid.
     * id of subscription phase
     * @return Returns the Internal String
     */
    @JsonGetter("uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetUid() {
        return this.uid;
    }

    /**
     * Getter for Uid.
     * id of subscription phase
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for Ordinal.
     * index of phase in total subscription plan
     * @return Returns the Internal Long
     */
    @JsonGetter("ordinal")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<Long> internalGetOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for Ordinal.
     * index of phase in total subscription plan
     * @return Returns the Long
     */
    @JsonIgnore
    public Long getOrdinal() {
        return OptionalNullable.getFrom(ordinal);
    }

    /**
     * Internal Getter for OrderTemplateId.
     * id of order to be used in billing
     * @return Returns the Internal String
     */
    @JsonGetter("order_template_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetOrderTemplateId() {
        return this.orderTemplateId;
    }

    /**
     * Getter for OrderTemplateId.
     * id of order to be used in billing
     * @return Returns the String
     */
    @JsonIgnore
    public String getOrderTemplateId() {
        return OptionalNullable.getFrom(orderTemplateId);
    }

    /**
     * Internal Getter for PlanPhaseUid.
     * the uid from the plan's phase in catalog
     * @return Returns the Internal String
     */
    @JsonGetter("plan_phase_uid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetPlanPhaseUid() {
        return this.planPhaseUid;
    }

    /**
     * Getter for PlanPhaseUid.
     * the uid from the plan's phase in catalog
     * @return Returns the String
     */
    @JsonIgnore
    public String getPlanPhaseUid() {
        return OptionalNullable.getFrom(planPhaseUid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, ordinal, orderTemplateId, planPhaseUid);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Phase)) {
            return false;
        }
        Phase other = (Phase) obj;
        return Objects.equals(uid, other.uid)
                && Objects.equals(ordinal, other.ordinal)
                && Objects.equals(orderTemplateId, other.orderTemplateId)
                && Objects.equals(planPhaseUid, other.planPhaseUid);
    }

    /**
     * Converts this Phase into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "Phase [" + "uid=" + uid + ", ordinal=" + ordinal + ", orderTemplateId=" + orderTemplateId
                + ", planPhaseUid=" + planPhaseUid + "]";
    }

    /**
     * Builds a new {@link Phase.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Phase.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.uid = internalGetUid();
        builder.ordinal = internalGetOrdinal();
        builder.orderTemplateId = internalGetOrderTemplateId();
        builder.planPhaseUid = internalGetPlanPhaseUid();
        return builder;
    }

    /**
     * Class to build instances of {@link Phase}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<Long> ordinal;
        private OptionalNullable<String> orderTemplateId;
        private OptionalNullable<String> planPhaseUid;

        /**
         * Setter for uid.
         * @param  uid  String value for uid.
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = OptionalNullable.of(uid);
            return this;
        }

        /**
         * UnSetter for uid.
         * @return Builder
         */
        public Builder unsetUid() {
            uid = null;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param  ordinal  Long value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Long ordinal) {
            this.ordinal = OptionalNullable.of(ordinal);
            return this;
        }

        /**
         * UnSetter for ordinal.
         * @return Builder
         */
        public Builder unsetOrdinal() {
            ordinal = null;
            return this;
        }

        /**
         * Setter for orderTemplateId.
         * @param  orderTemplateId  String value for orderTemplateId.
         * @return Builder
         */
        public Builder orderTemplateId(String orderTemplateId) {
            this.orderTemplateId = OptionalNullable.of(orderTemplateId);
            return this;
        }

        /**
         * UnSetter for orderTemplateId.
         * @return Builder
         */
        public Builder unsetOrderTemplateId() {
            orderTemplateId = null;
            return this;
        }

        /**
         * Setter for planPhaseUid.
         * @param  planPhaseUid  String value for planPhaseUid.
         * @return Builder
         */
        public Builder planPhaseUid(String planPhaseUid) {
            this.planPhaseUid = OptionalNullable.of(planPhaseUid);
            return this;
        }

        /**
         * UnSetter for planPhaseUid.
         * @return Builder
         */
        public Builder unsetPlanPhaseUid() {
            planPhaseUid = null;
            return this;
        }

        /**
         * Builds a new {@link Phase} object using the set fields.
         * @return {@link Phase}
         */
        public Phase build() {
            return new Phase(uid, ordinal, orderTemplateId, planPhaseUid);
        }
    }
}
