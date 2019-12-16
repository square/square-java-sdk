package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class CashDrawerDevice {

    @JsonCreator
    public CashDrawerDevice(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    private final String id;
    private final String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CashDrawerDevice)) {
            return false;
        }
        CashDrawerDevice cashDrawerDevice = (CashDrawerDevice) o;
        return Objects.equals(id, cashDrawerDevice.id) &&
            Objects.equals(name, cashDrawerDevice.name);
    }
    
    /**
     * Getter for Id.
     * The device Square-issued ID
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Name.
     * The device merchant-specified name.
     */
    @JsonGetter("name")
    public String getName() { 
        return this.name;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .name(getName());
            return builder;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder() { }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            name = value;
            return this;
        }

        public CashDrawerDevice build() {
            return new CashDrawerDevice(id,
                name);
        }
    }
}
