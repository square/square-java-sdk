
package com.squareup.square.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.apimatic.core.types.OptionalNullable;
import java.util.Objects;

/**
 * This is a model class for CheckoutLocationSettingsPolicy type.
 */
public class CheckoutLocationSettingsPolicy {
    private final OptionalNullable<String> uid;
    private final OptionalNullable<String> title;
    private final OptionalNullable<String> description;

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  title  String value for title.
     * @param  description  String value for description.
     */
    @JsonCreator
    public CheckoutLocationSettingsPolicy(
            @JsonProperty("uid") String uid,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description) {
        this.uid = OptionalNullable.of(uid);
        this.title = OptionalNullable.of(title);
        this.description = OptionalNullable.of(description);
    }

    /**
     * Initialization constructor.
     * @param  uid  String value for uid.
     * @param  title  String value for title.
     * @param  description  String value for description.
     */

    protected CheckoutLocationSettingsPolicy(OptionalNullable<String> uid,
            OptionalNullable<String> title, OptionalNullable<String> description) {
        this.uid = uid;
        this.title = title;
        this.description = description;
    }

    /**
     * Internal Getter for Uid.
     * A unique ID to identify the policy when making changes. You must set the UID for policy
     * updates, but it’s optional when setting new policies.
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
     * A unique ID to identify the policy when making changes. You must set the UID for policy
     * updates, but it’s optional when setting new policies.
     * @return Returns the String
     */
    @JsonIgnore
    public String getUid() {
        return OptionalNullable.getFrom(uid);
    }

    /**
     * Internal Getter for Title.
     * The title of the policy. This is required when setting the description, though you can update
     * it in a different request.
     * @return Returns the Internal String
     */
    @JsonGetter("title")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetTitle() {
        return this.title;
    }

    /**
     * Getter for Title.
     * The title of the policy. This is required when setting the description, though you can update
     * it in a different request.
     * @return Returns the String
     */
    @JsonIgnore
    public String getTitle() {
        return OptionalNullable.getFrom(title);
    }

    /**
     * Internal Getter for Description.
     * The description of the policy.
     * @return Returns the Internal String
     */
    @JsonGetter("description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonSerialize(using = OptionalNullable.Serializer.class)
    protected OptionalNullable<String> internalGetDescription() {
        return this.description;
    }

    /**
     * Getter for Description.
     * The description of the policy.
     * @return Returns the String
     */
    @JsonIgnore
    public String getDescription() {
        return OptionalNullable.getFrom(description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutLocationSettingsPolicy)) {
            return false;
        }
        CheckoutLocationSettingsPolicy other = (CheckoutLocationSettingsPolicy) obj;
        return Objects.equals(uid, other.uid)
            && Objects.equals(title, other.title)
            && Objects.equals(description, other.description);
    }

    /**
     * Converts this CheckoutLocationSettingsPolicy into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "CheckoutLocationSettingsPolicy [" + "uid=" + uid + ", title=" + title
                + ", description=" + description + "]";
    }

    /**
     * Builds a new {@link CheckoutLocationSettingsPolicy.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CheckoutLocationSettingsPolicy.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.uid = internalGetUid();
        builder.title = internalGetTitle();
        builder.description = internalGetDescription();
        return builder;
    }

    /**
     * Class to build instances of {@link CheckoutLocationSettingsPolicy}.
     */
    public static class Builder {
        private OptionalNullable<String> uid;
        private OptionalNullable<String> title;
        private OptionalNullable<String> description;



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
         * Setter for title.
         * @param  title  String value for title.
         * @return Builder
         */
        public Builder title(String title) {
            this.title = OptionalNullable.of(title);
            return this;
        }

        /**
         * UnSetter for title.
         * @return Builder
         */
        public Builder unsetTitle() {
            title = null;
            return this;
        }

        /**
         * Setter for description.
         * @param  description  String value for description.
         * @return Builder
         */
        public Builder description(String description) {
            this.description = OptionalNullable.of(description);
            return this;
        }

        /**
         * UnSetter for description.
         * @return Builder
         */
        public Builder unsetDescription() {
            description = null;
            return this;
        }

        /**
         * Builds a new {@link CheckoutLocationSettingsPolicy} object using the set fields.
         * @return {@link CheckoutLocationSettingsPolicy}
         */
        public CheckoutLocationSettingsPolicy build() {
            return new CheckoutLocationSettingsPolicy(uid, title, description);
        }
    }
}
