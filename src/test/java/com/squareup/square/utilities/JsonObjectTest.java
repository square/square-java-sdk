package com.squareup.square.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class JsonObjectTest {
  @Test
  public void EmptyObjectTest() throws IOException {
    JsonObject obj = JsonObject.fromJsonString("{}");
    assertEquals("{}", obj.toString());
    assertEquals(new LinkedHashMap<String, Object>(), obj.getStoredObject());
  }

  @Test
  public void NonEmptyObjectTest() throws IOException {
    JsonObject obj = JsonObject.fromJsonString("{\n"
        + "  \"stringProp\": \"test 1\",\n"
        + "  \"boolProp\": true,\n"
        + "  \"numProp\": 5.12,\n"
        + "  \"arrayProp\": [\"test 2\"],\n"
        + "  \"objProp\": {\n"
        + "    \"childProp\": true\n"
        + "  },\n"
        + "  \"nullProp\": null\n"
        + "}");

    assertEquals("{\"stringProp\":\"test 1\",\"boolProp\":true,\"numProp\":5.12,\"arrayProp\":[\"test 2\"],\"objProp\":{\"childProp\":true},\"nullProp\":null}", obj.toString());

    Map<String, Object> expected = new LinkedHashMap<>();
    expected.put("stringProp", "test 1");
    expected.put("boolProp", true);
    expected.put("numProp", 5.12);
    expected.put("arrayProp", new ArrayList<>(Collections.singletonList("test 2")));
    Map<String, Object> childObjValue = new LinkedHashMap<>();
    childObjValue.put("childProp", true);
    expected.put("objProp", childObjValue);
    expected.put("nullProp", null);
    assertEquals(expected, obj.getStoredObject());
  }

  @Test
  public void NonObjectTest() {
    IOException ex = assertThrows(IOException.class, () -> JsonObject.fromJsonString("true"));
    assertEquals("Provided JSON string must contain a valid JSON object.", ex.getMessage());
    ex = assertThrows(IOException.class, () -> JsonObject.fromJsonString("\"hello world\""));
    assertEquals("Provided JSON string must contain a valid JSON object.", ex.getMessage());
    ex = assertThrows(IOException.class, () -> JsonObject.fromJsonString("123"));
    assertEquals("Provided JSON string must contain a valid JSON object.", ex.getMessage());
    ex = assertThrows(IOException.class, () -> JsonObject.fromJsonString("[]"));
    assertEquals("Provided JSON string must contain a valid JSON object.", ex.getMessage());
  }
}
