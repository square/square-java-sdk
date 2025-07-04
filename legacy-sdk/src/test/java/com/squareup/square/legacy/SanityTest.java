/*
 * Square Connect API
 * Client library for accessing the Square Connect APIs
 *
 * OpenAPI spec version: 2.0
 * Contact: developers@squareup.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.squareup.square.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.squareup.square.legacy.api.CatalogApi;
import com.squareup.square.legacy.api.CustomersApi;
import com.squareup.square.legacy.api.LocationsApi;
import com.squareup.square.legacy.exceptions.ApiException;
import com.squareup.square.legacy.models.Address;
import com.squareup.square.legacy.models.CatalogImage;
import com.squareup.square.legacy.models.CatalogObject;
import com.squareup.square.legacy.models.CreateCatalogImageRequest;
import com.squareup.square.legacy.models.CreateCatalogImageResponse;
import com.squareup.square.legacy.models.CreateCustomerRequest;
import com.squareup.square.legacy.models.CreateCustomerResponse;
import com.squareup.square.legacy.models.Customer;
import com.squareup.square.legacy.models.DeleteCustomerResponse;
import com.squareup.square.legacy.models.ListCustomersResponse;
import com.squareup.square.legacy.models.ListLocationsResponse;
import com.squareup.square.legacy.models.RetrieveCustomerResponse;
import com.squareup.square.legacy.models.UpdateCustomerRequest;
import com.squareup.square.legacy.models.UpdateCustomerResponse;
import com.squareup.square.legacy.utilities.FileWrapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

/**
 * API tests for CatalogApi
 */
public class SanityTest {
    private static final String TEST_GIVEN_NAME = "John";
    private static final String TEST_FAMILY_NAME = "Smith";
    private static final String TEST_ADDRESS_LINE_1 = "1455 Market St";
    private static final String TEST_ADDRESS_LINE_2 = "San Francisco, CA 94103";
    private static final String TEST_UPDATE_FAMILY_NAME = "Jackson";
    private static final String TEST_UPDATE_ADDRESS_LINE_2 = "Seattle, WA";

    private static final Address TEST_ADDRESS = new Address.Builder()
            .addressLine1(TEST_ADDRESS_LINE_1)
            .addressLine2(TEST_ADDRESS_LINE_2)
            .build();

    private static final CreateCustomerRequest TEST_CREATE_CUSTOMER_REQUEST = new CreateCustomerRequest.Builder()
            .givenName(TEST_GIVEN_NAME)
            .familyName(TEST_FAMILY_NAME)
            .address(TEST_ADDRESS)
            .build();

    private static final Address TEST_UPDATE_ADDRESS = new Address.Builder()
            .addressLine1(TEST_ADDRESS_LINE_1)
            .addressLine2(TEST_UPDATE_ADDRESS_LINE_2)
            .build();

    private static final UpdateCustomerRequest TEST_UPDATE_CUSTOMER_REQUEST = new UpdateCustomerRequest.Builder()
            .givenName(TEST_GIVEN_NAME)
            .familyName(TEST_UPDATE_FAMILY_NAME)
            .address(TEST_UPDATE_ADDRESS)
            .build();

    private SquareClient client;

    @Before
    public void setup() throws Exception {
        client = new SquareClient.Builder()
                .environment(Environment.SANDBOX)
                .accessToken(System.getenv().get("TEST_SQUARE_TOKEN"))
                .build();
    }

    // Silencing Test until solution is patched in
    // @Test
    // public void testV2Exception() throws IOException {
    //     SquareClient badClient = new SquareClient.Builder()
    //     .environment(Environment.SANDBOX)
    //     .accessToken("BAD_TOKEN")
    //     .build();

    //     LocationsApi api = badClient.getLocationsApi();

    //     try {
    //         api.listLocations();
    //     }
    //     catch(ApiException e) {
    //         assertEquals(e.getResponseCode(), 401);
    //         List<Error> errors =  e.getErrors();
    //         assertEquals(errors.get(0).getCategory(), "AUTHENTICATION_ERROR");
    //         assertEquals(errors.get(0).getCode(), "UNAUTHORIZED");
    //     }
    // }

    @Test
    public void testFileUpload() throws ApiException, IOException {
        CatalogApi api = client.getCatalogApi();

        CatalogImage imageData =
            new CatalogImage.Builder().caption("Image for File Upload Test").build();

        CatalogObject image = new CatalogObject.Builder("IMAGE", "#java_sdk_test")
            .imageData(imageData)
            .build();

        String idempotencyKey = UUID.randomUUID().toString();
        CreateCatalogImageRequest request = new CreateCatalogImageRequest.Builder(idempotencyKey, image).build();

        String imgPath = Paths.get(System.getProperty("user.dir").toString(), "src/test/resources/square.png")
            .toString();
        File imageFile = new File(imgPath);

        CreateCatalogImageResponse result = api.createCatalogImage(request, new FileWrapper(imageFile, "image/jpeg"));

        assertNotNull(result.getImage().getImageData().getUrl());

        // Remove the image and clean up
        api.deleteCatalogObject(result.getImage().getId());
    }

    @Test
    public void testResponse() throws ApiException, IOException {
        LocationsApi api = client.getLocationsApi();
        ListLocationsResponse res = api.listLocations();
        assertEquals(res.getContext().getResponse().getStatusCode(), 200);
    }

    @Test
    public void testV2CustomerCycle() throws ApiException, IOException {
        CustomersApi api = client.getCustomersApi();
        ListCustomersResponse listCustomersRes = api.listCustomers(null, null, null, null, null);

        // Create Customer
        CreateCustomerResponse createCustomerRes = api.createCustomer(TEST_CREATE_CUSTOMER_REQUEST);
        Customer createdCustomer = createCustomerRes.getCustomer();
        String createdCustomerId = createdCustomer.getId();
        assertEquals(createdCustomer.getAddress().getAddressLine1(), TEST_ADDRESS_LINE_1);
        assertEquals(createdCustomer.getAddress().getAddressLine2(), TEST_ADDRESS_LINE_2);
        assertEquals(createdCustomer.getGivenName(), TEST_GIVEN_NAME);
        assertEquals(createdCustomer.getFamilyName(), TEST_FAMILY_NAME);

        // Retrieve Customer
        RetrieveCustomerResponse retrieveCustomerRes = api.retrieveCustomer(createdCustomerId);
        Customer retrieveCustomer = retrieveCustomerRes.getCustomer();
        assertEquals(retrieveCustomer.getAddress().getAddressLine1(), TEST_ADDRESS_LINE_1);
        assertEquals(retrieveCustomer.getAddress().getAddressLine2(), TEST_ADDRESS_LINE_2);
        assertEquals(retrieveCustomer.getGivenName(), TEST_GIVEN_NAME);
        assertEquals(retrieveCustomer.getFamilyName(), TEST_FAMILY_NAME);

        // Update Customer
        UpdateCustomerResponse updateCustomerRes = api.updateCustomer(createdCustomerId, TEST_UPDATE_CUSTOMER_REQUEST);
        Customer updatedCustomer = updateCustomerRes.getCustomer();
        assertEquals(updatedCustomer.getAddress().getAddressLine1(), TEST_ADDRESS_LINE_1);
        assertEquals(updatedCustomer.getAddress().getAddressLine2(), TEST_UPDATE_ADDRESS_LINE_2);
        assertEquals(updatedCustomer.getGivenName(), TEST_GIVEN_NAME);
        assertEquals(updatedCustomer.getFamilyName(), TEST_UPDATE_FAMILY_NAME);

        // Delete Customer
        DeleteCustomerResponse deleteCustomerRes = api.deleteCustomer(createdCustomerId, null);
        assertEquals(deleteCustomerRes.getErrors(), null);
    }
}
