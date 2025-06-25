package com.squareup.square.legacy.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for LoyaltyProgramRewardTier type.
 */
public class LoyaltyProgramRewardTier {
    private final String id;
    private final int points;
    private final String name;
    private final LoyaltyProgramRewardDefinition definition;
    private final String createdAt;
    private final CatalogObjectReference pricingRuleReference;

    /**
     * Initialization constructor.
     * @param  points  int value for points.
     * @param  pricingRuleReference  CatalogObjectReference value for pricingRuleReference.
     * @param  id  String value for id.
     * @param  name  String value for name.
     * @param  definition  LoyaltyProgramRewardDefinition value for definition.
     * @param  createdAt  String value for createdAt.
     */
    @JsonCreator
    public LoyaltyProgramRewardTier(
            @JsonProperty("points") int points,
            @JsonProperty("pricing_rule_reference") CatalogObjectReference pricingRuleReference,
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("definition") LoyaltyProgramRewardDefinition definition,
            @JsonProperty("created_at") String createdAt) {
        this.id = id;
        this.points = points;
        this.name = name;
        this.definition = definition;
        this.createdAt = createdAt;
        this.pricingRuleReference = pricingRuleReference;
    }

    /**
     * Getter for Id.
     * The Square-assigned ID of the reward tier.
     * @return Returns the String
     */
    @JsonGetter("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getId() {
        return id;
    }

    /**
     * Getter for Points.
     * The points exchanged for the reward tier.
     * @return Returns the int
     */
    @JsonGetter("points")
    public int getPoints() {
        return points;
    }

    /**
     * Getter for Name.
     * The name of the reward tier.
     * @return Returns the String
     */
    @JsonGetter("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }

    /**
     * Getter for Definition.
     * Provides details about the reward tier discount. DEPRECATED at version 2020-12-16. Discount
     * details are now defined using a catalog pricing rule and other catalog objects. For more
     * information, see [Getting discount details for a reward
     * tier](https://developer.squareup.com/docs/loyalty-api/loyalty-rewards#get-discount-details).
     * @return Returns the LoyaltyProgramRewardDefinition
     */
    @JsonGetter("definition")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LoyaltyProgramRewardDefinition getDefinition() {
        return definition;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the reward tier was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter for PricingRuleReference.
     * A reference to a Catalog object at a specific version. In general this is used as an entry
     * point into a graph of catalog objects, where the objects exist at a specific version.
     * @return Returns the CatalogObjectReference
     */
    @JsonGetter("pricing_rule_reference")
    public CatalogObjectReference getPricingRuleReference() {
        return pricingRuleReference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, name, definition, createdAt, pricingRuleReference);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoyaltyProgramRewardTier)) {
            return false;
        }
        LoyaltyProgramRewardTier other = (LoyaltyProgramRewardTier) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(points, other.points)
                && Objects.equals(name, other.name)
                && Objects.equals(definition, other.definition)
                && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(pricingRuleReference, other.pricingRuleReference);
    }

    /**
     * Converts this LoyaltyProgramRewardTier into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "LoyaltyProgramRewardTier [" + "points=" + points + ", pricingRuleReference="
                + pricingRuleReference + ", id=" + id + ", name=" + name + ", definition="
                + definition + ", createdAt=" + createdAt + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramRewardTier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramRewardTier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(points, pricingRuleReference)
                .id(getId())
                .name(getName())
                .definition(getDefinition())
                .createdAt(getCreatedAt());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramRewardTier}.
     */
    public static class Builder {
        private int points;
        private CatalogObjectReference pricingRuleReference;
        private String id;
        private String name;
        private LoyaltyProgramRewardDefinition definition;
        private String createdAt;

        /**
         * Initialization constructor.
         * @param  points  int value for points.
         * @param  pricingRuleReference  CatalogObjectReference value for pricingRuleReference.
         */
        public Builder(int points, CatalogObjectReference pricingRuleReference) {
            this.points = points;
            this.pricingRuleReference = pricingRuleReference;
        }

        /**
         * Setter for points.
         * @param  points  int value for points.
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
            return this;
        }

        /**
         * Setter for pricingRuleReference.
         * @param  pricingRuleReference  CatalogObjectReference value for pricingRuleReference.
         * @return Builder
         */
        public Builder pricingRuleReference(CatalogObjectReference pricingRuleReference) {
            this.pricingRuleReference = pricingRuleReference;
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
         * Setter for name.
         * @param  name  String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for definition.
         * @param  definition  LoyaltyProgramRewardDefinition value for definition.
         * @return Builder
         */
        public Builder definition(LoyaltyProgramRewardDefinition definition) {
            this.definition = definition;
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
         * Builds a new {@link LoyaltyProgramRewardTier} object using the set fields.
         * @return {@link LoyaltyProgramRewardTier}
         */
        public LoyaltyProgramRewardTier build() {
            return new LoyaltyProgramRewardTier(points, pricingRuleReference, id, name, definition, createdAt);
        }
    }
}
