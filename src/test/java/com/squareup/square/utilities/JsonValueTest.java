
package com.squareup.square.utilities;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import com.squareup.square.models.BusinessHoursPeriod;

import org.junit.Test;

public class JsonValueTest {
  @Test
  public void StringValueTest() {
    JsonValue value = JsonValue.fromString("hello world");
    assertEquals("\"hello world\"", value.toString());
    value = JsonValue.fromString("null");
    assertEquals("\"null\"", value.toString());
    value = JsonValue.fromString(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void BooleanValueTest() {
    JsonValue value = JsonValue.fromBoolean(true);
    assertEquals("true", value.toString());
    value = JsonValue.fromBoolean(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void IntegerValueTest() {
    JsonValue value = JsonValue.fromInteger(123);
    assertEquals("123", value.toString());
    value = JsonValue.fromInteger(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void LongValueTest() {
    JsonValue value = JsonValue.fromLong(123L);
    assertEquals("123", value.toString());
    value = JsonValue.fromLong(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void DoubleValueTest() {
    JsonValue value = JsonValue.fromDouble(123D);
    assertEquals("123.0", value.toString());
    value = JsonValue.fromDouble(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void ObjectValueTest() {
    JsonValue value = JsonValue.fromObject(new BusinessHoursPeriod("Monday", "0800", "1700"));
    assertEquals("{\"day_of_week\":\"Monday\",\"start_local_time\":\"0800\",\"end_local_time\":\"1700\"}", value.toString());
    value = JsonValue.fromObject(null);
    assertEquals("null", value.toString());
  }

  @Test
  public void ArrayValueTest() {
    JsonValue value = JsonValue.fromArray(Arrays.asList("val1", "val2"));
    assertEquals("[\"val1\",\"val2\"]", value.toString());
    value = JsonValue.fromArray(null);
    assertEquals("null", value.toString());
  }
}
