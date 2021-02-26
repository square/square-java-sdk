
package com.squareup.square.internal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 * Class to encapsulate fields which are Optional as well as Nullable. It also
 * provides helper methods to create OptionalNullable generic type, and to
 * extract value from it.
 * @param <T> Type of the encapsulated field.
 */
public class OptionalNullable<T> {

    /**
     * Private store for encapsulated object's value.
     */
    private T value;

    private OptionalNullable(T value) {
        this.value = value;
    }

    /**
     * Converts this OptionalNullable into string format.
     * @return String representation of this class
     */
    @Override
    public String toString() {
        return "" + value;
    }

    /**
     * Creates an OptionalNullable instance with the provided value.
     * @param <T>   Type of the provided object.
     * @param value Value of the provided object.
     * @return {@link OptionalNullable} instance encapsulating given value.
     */
    public static <T> OptionalNullable<T> of(T value) {
        return new OptionalNullable<T>(value);
    }

    /**
     * Extracts the encapsulated value from the given OptionalNullable.
     * @param <T>              Type of the expected value.
     * @param optionalNullable OptionalNullable instance to get value.
     * @return Value of the extracted field.
     */
    public static <T> T getFrom(OptionalNullable<T> optionalNullable) {
        return (optionalNullable == null) ? null : optionalNullable.value;
    }

    /**
     * JsonSerializer for the {@link OptionalNullable} instance. It is used to
     * Serialize an {@link OptionalNullable} as its encapsulated object.
     */
    public static class Serializer extends JsonSerializer<OptionalNullable<Object>> {
        @SuppressWarnings("unused")
        @Override
        public void serialize(OptionalNullable<Object> object, JsonGenerator jgen,
                SerializerProvider provider) throws IOException {
            jgen.writeObject(object.value);
        }
    }
}