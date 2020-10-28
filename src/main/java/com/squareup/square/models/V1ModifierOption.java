
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareup.square.http.client.HttpContext;
import java.util.Objects;


/**
 * This is a model class for V1ModifierOption type.
 */
public class V1ModifierOption {
    private HttpContext httpContext;
    private final String id;
    private final String name;
    private final V1Money priceMoney;
    private final Boolean onByDefault;
    private final Integer ordinal;
    private final String modifierListId;
    private final String v2Id;

    /**
     * Initialization constructor.
     * @param id String value for id.
     * @param name String value for name.
     * @param priceMoney V1Money value for priceMoney.
     * @param onByDefault Boolean value for onByDefault.
     * @param ordinal Integer value for ordinal.
     * @param modifierListId String value for modifierListId.
     * @param v2Id String value for v2Id.
     */
    @JsonCreator
    public V1ModifierOption(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("price_money") V1Money priceMoney,
            @JsonProperty("on_by_default") Boolean onByDefault,
            @JsonProperty("ordinal") Integer ordinal,
            @JsonProperty("modifier_list_id") String modifierListId,
            @JsonProperty("v2_id") String v2Id) {
        this.id = id;
        this.name = name;
        this.priceMoney = priceMoney;
        this.onByDefault = onByDefault;
        this.ordinal = ordinal;
        this.modifierListId = modifierListId;
        this.v2Id = v2Id;
    }

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Id.
     * The modifier option's unique ID.
     * @return Returns the String
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for Name.
     * The modifier option's name.
     * @return Returns the String
     */
    @JsonGetter("name")
    public String getName() {
        return this.name;
    }

    /**
     * Getter for PriceMoney.
     * @return Returns the V1Money
     */
    @JsonGetter("price_money")
    public V1Money getPriceMoney() {
        return this.priceMoney;
    }

    /**
     * Getter for OnByDefault.
     * If true, the modifier option is the default option in a modifier list for which
     * selection_type is SINGLE.
     * @return Returns the Boolean
     */
    @JsonGetter("on_by_default")
    public Boolean getOnByDefault() {
        return this.onByDefault;
    }

    /**
     * Getter for Ordinal.
     * Indicates the modifier option's list position when displayed in Square Point of Sale and the
     * merchant dashboard. If more than one modifier option in the same modifier list has the same
     * ordinal value, those options are displayed in alphabetical order.
     * @return Returns the Integer
     */
    @JsonGetter("ordinal")
    public Integer getOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for ModifierListId.
     * The ID of the modifier list the option belongs to.
     * @return Returns the String
     */
    @JsonGetter("modifier_list_id")
    public String getModifierListId() {
        return this.modifierListId;
    }

    /**
     * Getter for V2Id.
     * The ID of the CatalogObject in the Connect v2 API. Objects that are shared across multiple
     * locations share the same v2 ID.
     * @return Returns the String
     */
    @JsonGetter("v2_id")
    public String getV2Id() {
        return this.v2Id;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, priceMoney, onByDefault, ordinal, modifierListId, v2Id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1ModifierOption)) {
            return false;
        }
        V1ModifierOption other = (V1ModifierOption) obj;
        return Objects.equals(id, other.id)
            && Objects.equals(name, other.name)
            && Objects.equals(priceMoney, other.priceMoney)
            && Objects.equals(onByDefault, other.onByDefault)
            && Objects.equals(ordinal, other.ordinal)
            && Objects.equals(modifierListId, other.modifierListId)
            && Objects.equals(v2Id, other.v2Id);
    }

    /**
     * Builds a new {@link V1ModifierOption.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1ModifierOption.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName())
            .priceMoney(getPriceMoney())
            .onByDefault(getOnByDefault())
            .ordinal(getOrdinal())
            .modifierListId(getModifierListId())
            .v2Id(getV2Id());
        return builder;
    }

    /**
     * Class to build instances of {@link V1ModifierOption}.
     */
    public static class Builder {
        private HttpContext httpContext;
        private String id;
        private String name;
        private V1Money priceMoney;
        private Boolean onByDefault;
        private Integer ordinal;
        private String modifierListId;
        private String v2Id;



        /**
         * Setter for httpContext.
         * @param httpContext HttpContext value for httpContext.
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }

        /**
         * Setter for id.
         * @param id String value for id.
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Setter for name.
         * @param name String value for name.
         * @return Builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Setter for priceMoney.
         * @param priceMoney V1Money value for priceMoney.
         * @return Builder
         */
        public Builder priceMoney(V1Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        /**
         * Setter for onByDefault.
         * @param onByDefault Boolean value for onByDefault.
         * @return Builder
         */
        public Builder onByDefault(Boolean onByDefault) {
            this.onByDefault = onByDefault;
            return this;
        }

        /**
         * Setter for ordinal.
         * @param ordinal Integer value for ordinal.
         * @return Builder
         */
        public Builder ordinal(Integer ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Setter for modifierListId.
         * @param modifierListId String value for modifierListId.
         * @return Builder
         */
        public Builder modifierListId(String modifierListId) {
            this.modifierListId = modifierListId;
            return this;
        }

        /**
         * Setter for v2Id.
         * @param v2Id String value for v2Id.
         * @return Builder
         */
        public Builder v2Id(String v2Id) {
            this.v2Id = v2Id;
            return this;
        }

        /**
         * Builds a new {@link V1ModifierOption} object using the set fields.
         * @return {@link V1ModifierOption}
         */
        public V1ModifierOption build() {
            V1ModifierOption model =
                    new V1ModifierOption(id,
                            name,
                            priceMoney,
                            onByDefault,
                            ordinal,
                            modifierListId,
                            v2Id);
            model.httpContext = httpContext;
            return model;
        }
    }
}
