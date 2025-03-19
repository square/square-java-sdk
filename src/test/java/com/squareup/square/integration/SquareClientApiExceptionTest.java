package com.squareup.square.integration;

import com.squareup.square.core.SquareApiException;
import com.squareup.square.types.Error;
import com.squareup.square.types.ErrorCategory;
import com.squareup.square.types.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class SquareClientApiExceptionTest {

    @Test
    public void testExceptionWithoutBody() {
        SquareApiException exception = new SquareApiException("Message", 400, null);

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(
                ErrorCode.valueOf("UNKNOWN"), exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertFalse(exception.errors().get(0).getField().isPresent());
        Assertions.assertFalse(exception.errors().get(0).getDetail().isPresent());
    }

    @Test
    public void testExceptionWithV1Error() {
        SquareApiException exception = new SquareApiException("Message", 400, new HashMap<String, String>() {
            {
                put("type", "INVALID_VALUE");
                put("message", "Invalid field value");
                put("field", "customer_id");
            }
        });

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(
                ErrorCode.INVALID_VALUE, exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertEquals(
                "customer_id", exception.errors().get(0).getField().get());
        Assertions.assertEquals(
                "Invalid field value", exception.errors().get(0).getDetail().get());
    }

    @Test
    public void testExceptionWithV1ErrorWithoutType() {
        SquareApiException exception = new SquareApiException("Message", 400, new HashMap<String, String>() {
            {
                put("message", "Invalid field value");
                put("field", "customer_id");
            }
        });

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(
                ErrorCode.valueOf("UNKNOWN"), exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertEquals(
                "customer_id", exception.errors().get(0).getField().get());
        Assertions.assertEquals(
                "Invalid field value", exception.errors().get(0).getDetail().get());
    }

    @Test
    public void testExceptionWithV2Error() {
        SquareApiException exception =
                new SquareApiException("Message", 400, new HashMap<String, List<Map<String, String>>>() {
                    {
                        put("errors", new ArrayList<Map<String, String>>() {
                            {
                                add(new HashMap<String, String>() {
                                    {
                                        put("category", ErrorCategory.API_ERROR.toString());
                                        put("code", ErrorCode.BAD_REQUEST.toString());
                                        put("detail", "Invalid input");
                                        put("field", "email");
                                    }
                                });
                            }
                        });
                    }
                });

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(ErrorCode.BAD_REQUEST, exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertEquals("email", exception.errors().get(0).getField().get());
        Assertions.assertEquals(
                "Invalid input", exception.errors().get(0).getDetail().get());
    }

    @Test
    public void testExceptionWithV2ErrorAsArray() {
        SquareApiException exception = new SquareApiException("Message", 400, new ArrayList<Object>() {
            {
                add(Error.builder()
                        .category(ErrorCategory.API_ERROR)
                        .code(ErrorCode.BAD_REQUEST)
                        .detail("Invalid input")
                        .field("email")
                        .build());
            }
        });

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(ErrorCode.BAD_REQUEST, exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertEquals("email", exception.errors().get(0).getField().get());
        Assertions.assertEquals(
                "Invalid input", exception.errors().get(0).getDetail().get());
    }

    @Test
    public void testExceptionWithV2ErrorAsObject() {
        SquareApiException exception = new SquareApiException("Message", 400, new HashMap<String, List<Object>>() {
            {
                put("errors", new ArrayList<Object>() {
                    {
                        add(Error.builder()
                                .category(ErrorCategory.API_ERROR)
                                .code(ErrorCode.BAD_REQUEST)
                                .detail("Invalid input")
                                .field("email")
                                .build());
                    }
                });
            }
        });

        Assertions.assertEquals("Message", exception.getMessage());
        Assertions.assertEquals(400, exception.statusCode());
        Assertions.assertEquals(1, exception.errors().size());
        Assertions.assertInstanceOf(Error.class, exception.errors().get(0));
        Assertions.assertEquals(ErrorCode.BAD_REQUEST, exception.errors().get(0).getCode());
        Assertions.assertEquals(
                ErrorCategory.API_ERROR, exception.errors().get(0).getCategory());
        Assertions.assertEquals("email", exception.errors().get(0).getField().get());
        Assertions.assertEquals(
                "Invalid input", exception.errors().get(0).getDetail().get());
    }
}
