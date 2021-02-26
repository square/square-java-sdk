
package com.squareup.square.models;

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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final CatalogObjectReference pricingRuleReference;

    /**
     * Initialization constructor.
     * @param  id  String value for id.
     * @param  points  int value for points.
     * @param  name  String value for name.
     * @param  definition  LoyaltyProgramRewardDefinition value for definition.
     * @param  createdAt  String value for createdAt.
     * @param  pricingRuleReference  CatalogObjectReference value for pricingRuleReference.
     */
    @JsonCreator
    public LoyaltyProgramRewardTier(
            @JsonProperty("id") String id,
            @JsonProperty("points") int points,
            @JsonProperty("name") String name,
            @JsonProperty("definition") LoyaltyProgramRewardDefinition definition,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("pricing_rule_reference") CatalogObjectReference pricingRuleReference) {
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
    public String getName() {
        return name;
    }

    /**
     * Getter for Definition.
     * Provides details about the reward tier discount. DEPRECATED at version 2020-12-16. Discount
     * details are now defined using a catalog pricing rule and other catalog objects. For more
     * information, see [Get discount details for the
     * reward](https://developer.squareup.com/docs/loyalty-api/overview#get-discount-details).
     * @return Returns the LoyaltyProgramRewardDefinition
     */
    @JsonGetter("definition")
    public LoyaltyProgramRewardDefinition getDefinition() {
        return definition;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when the reward tier was created, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
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
        return "LoyaltyProgramRewardTier [" + "id=" + id + ", points=" + points + ", name=" + name
                + ", definition=" + definition + ", createdAt=" + createdAt
                + ", pricingRuleReference=" + pricingRuleReference + "]";
    }

    /**
     * Builds a new {@link LoyaltyProgramRewardTier.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link LoyaltyProgramRewardTier.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(id, points, name, definition, createdAt)
                .pricingRuleReference(getPricingRuleReference());
        return builder;
    }

    /**
     * Class to build instances of {@link LoyaltyProgramRewardTier}.
     */
    public static class Builder {
        private String id;
        private int points;
        private String name;
        private LoyaltyProgramRewardDefinition definition;
        private String createdAt;
        private CatalogObjectReference pricingRuleReference;

        /**
         * Initialization constructor.
         * @param  id  String value for id.
         * @param  points  int value for points.
         * @param  name  String value for name.
         * @param  definition  LoyaltyProgramRewardDefinition value for definition.
         * @param  createdAt  String value for createdAt.
         */
        public Builder(String id, int points, String name,
                LoyaltyProgramRewardDefinition definition, String createdAt) {
            this.id = id;
            this.points = points;
            this.name = name;
            this.definition = definition;
            this.createdAt = createdAt;
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
         * Setter for points.
         * @param  points  int value for points.
         * @return Builder
         */
        public Builder points(int points) {
            this.points = points;
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
         * Setter for pricingRuleReference.
         * @param  pricingRuleReference  CatalogObjectReference value for pricingRuleReference.
         * @return Builder
         */
        public Builder pricingRuleReference(CatalogObjectReference pricingRuleReference) {
            this.pricingRuleReference = pricingRuleReference;
            return this;
        }

        /**
         * Builds a new {@link LoyaltyProgramRewardTier} object using the set fields.
         * @return {@link LoyaltyProgramRewardTier}
         */
        public LoyaltyProgramRewardTier build() {
            return new LoyaltyProgramRewardTier(id, points, name, definition, createdAt,
                    pricingRuleReference);
        }
    }
}
