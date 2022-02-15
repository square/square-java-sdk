
# Utility Classes Documentation

## ApiHelper Class

This is a Helper class with commonly used utilities for the SDK.

### Fields

| Name | Description | Type |
|  --- | --- | --- |
| mapper | Deserialization of Json data. | `ObjectMapper` |

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `serialize(Object obj)` | Json Serialization of a given object. | `String` |
| `deserialize(String json)` | Json deserialization of the given Json string. | `LinkedHashMap<String, Object>` |
| `deserialize(String json, Class<T> clazz)` | Json deserialization of the given Json string. | `<T extends Object> T` |
| `deserialize(String json, TypeReference<T> typeReference)` | JSON Deserialization of the given json string. | `<T extends Object> T` |
| `deserializeArray(String json, Class<T[]> classArray)` | JSON Deserialization of the given json string. | `<T extends Object> List<T>` |

## FileWrapper Class

Class to wrap file and contentType to be sent as part of a HTTP request.

### Constructors

| Name | Description |
|  --- | --- |
| `FileWrapper(File file)` | Initialization constructor. |
| `FileWrapper(File file, String contentType)` | Initialization constructor. |

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `getFile()` | File instance. | `File` |
| `getContentType()` | Content type of the file. | `String` |

## JsonObject Class

Class to wrap any JSON object.

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `fromJsonString(String jsonString)` | Initializes JsonObject instance with string json. | `JsonObject` |
| `getStoredObject()` | Getter for stored object. | `Object` |
| `toString()` | String representation of stored JSON. | `String` |

## JsonValue Class

Class to wrap any JSON value.

### Methods

| Name | Description | Return Type |
|  --- | --- | --- |
| `fromString(String value)` | Initializes JsonValue instance with string value. | `JsonValue` |
| `fromBoolean(Boolean value)` | Initializes JsonValue instance with boolean value. | `JsonValue` |
| `fromInteger(Integer value)` | Initializes JsonValue instance with integer value. | `JsonValue` |
| `fromLong(Long value)` | Initializes JsonValue instance with long value. | `JsonValue` |
| `fromDouble(Double value)` | Initializes JsonValue instance with double value. | `JsonValue` |
| `fromObject(Object value)` | Initializes JsonValue instance with any object value. | `JsonValue` |
| `fromArray(List<T> values)` | Initializes JsonValue instance with array of any type. | `JsonValue` |
| `getStoredObject()` | Getter for stored object. | `Object` |
| `toString()` | String representation of stored JSON. | `String` |


