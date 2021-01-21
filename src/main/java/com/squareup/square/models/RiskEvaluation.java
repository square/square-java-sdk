
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This is a model class for RiskEvaluation type.
 */
public class RiskEvaluation {
    private final String createdAt;
    private final String riskLevel;

    /**
     * Initialization constructor.
     * @param createdAt String value for createdAt.
     * @param riskLevel String value for riskLevel.
     */
    @JsonCreator
    public RiskEvaluation(
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("risk_level") String riskLevel) {
        this.createdAt = createdAt;
        this.riskLevel = riskLevel;
    }

    /**
     * Getter for CreatedAt.
     * The timestamp when payment risk was evaluated, in RFC 3339 format.
     * @return Returns the String
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for RiskLevel.
     * @return Returns the String
     */
    @JsonGetter("risk_level")
    public String getRiskLevel() {
        return this.riskLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, riskLevel);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RiskEvaluation)) {
            return false;
        }
        RiskEvaluation other = (RiskEvaluation) obj;
        return Objects.equals(createdAt, other.createdAt)
            && Objects.equals(riskLevel, other.riskLevel);
    }

    /**
     * Converts this RiskEvaluation into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "RiskEvaluation [" + "createdAt=" + createdAt + ", riskLevel=" + riskLevel + "]";
    }

    /**
     * Builds a new {@link RiskEvaluation.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link RiskEvaluation.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
                .createdAt(getCreatedAt())
                .riskLevel(getRiskLevel());
        return builder;
    }

    /**
     * Class to build instances of {@link RiskEvaluation}.
     */
    public static class Builder {
        private String createdAt;
        private String riskLevel;



        /**
         * Setter for createdAt.
         * @param createdAt String value for createdAt.
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Setter for riskLevel.
         * @param riskLevel String value for riskLevel.
         * @return Builder
         */
        public Builder riskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
            return this;
        }

        /**
         * Builds a new {@link RiskEvaluation} object using the set fields.
         * @return {@link RiskEvaluation}
         */
        public RiskEvaluation build() {
            return new RiskEvaluation(createdAt, riskLevel);
        }
    }
}
