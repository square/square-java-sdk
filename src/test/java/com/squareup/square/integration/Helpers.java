package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.types.Address;
import com.squareup.square.types.CatalogItem;
import com.squareup.square.types.CatalogItemVariation;
import com.squareup.square.types.CatalogObject;
import com.squareup.square.types.CatalogObjectItem;
import com.squareup.square.types.CatalogObjectItemVariation;
import com.squareup.square.types.CatalogPricingType;
import com.squareup.square.types.Country;
import com.squareup.square.types.CreateCustomerRequest;
import com.squareup.square.types.CreateCustomerResponse;
import com.squareup.square.types.CreateLocationRequest;
import com.squareup.square.types.CreateLocationResponse;
import com.squareup.square.types.Currency;
import com.squareup.square.types.Customer;
import com.squareup.square.types.ListLocationsResponse;
import com.squareup.square.types.Location;
import com.squareup.square.types.Money;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public final class Helpers {
    public static Money newTestMoney(long amount) {
        return Money.builder().amount(amount).currency(Currency.USD).build();
    }

    public static CatalogObject createTestCatalogItem(CreateCatalogItemOptions opts) {
        return CatalogObject.item(CatalogObjectItem.builder()
                .id("#" + UUID.randomUUID())
                .presentAtAllLocations(true)
                .itemData(CatalogItem.builder()
                        .name(opts.name)
                        .description(opts.description)
                        .abbreviation(opts.abbreviation)
                        .variations(opts.variations())
                        .build())
                .build());
    }

    public static File getTestFile() {
        try {
            URL fileUrl = Helpers.class.getResource("/testdata/image.jpeg");
            return new File(Objects.requireNonNull(fileUrl).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static String createLocation(SquareClient client) {
        CreateLocationResponse locationsResponse = client.locations()
                .create(CreateLocationRequest.builder()
                        .location(Location.builder()
                                .name("Test location " + UUID.randomUUID())
                                .build())
                        .build());

        Optional<Location> location = locationsResponse.getLocation();
        if (!location.isPresent()) {
            throw new RuntimeException("Could not get location.");
        }
        Optional<String> locationId = location.get().getId();
        if (!locationId.isPresent()) {
            throw new RuntimeException("Could not get location ID.");
        }
        return locationId.get();
    }

    public static CreateCustomerRequest createTestCustomerRequest() {
        return CreateCustomerRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .givenName("Amelia")
                .familyName("Earhart")
                .phoneNumber("1-212-555-4240")
                .note("test customer")
                .address(testAddress())
                .build();
    }

    public static String createTestCustomer(SquareClient client) {
        CreateCustomerResponse response = client.customers().create(createTestCustomerRequest());
        Optional<Customer> customer = response.getCustomer();
        if (!customer.isPresent()) {
            throw new RuntimeException("Could not get customer.");
        }
        Optional<String> customerId = customer.get().getId();
        if (!customerId.isPresent()) {
            throw new RuntimeException("Could not get customer ID.");
        }
        return customerId.get();
    }

    public static Address testAddress() {
        return Address.builder()
                .addressLine1("500 Electric Ave")
                .addressLine2("Suite 600")
                .locality("New York")
                .administrativeDistrictLevel1("NY")
                .postalCode("10003")
                .country(Country.US)
                .build();
    }

    public static String getDefaultLocationId(SquareClient client) {
        ListLocationsResponse response = client.locations().list();
        Optional<List<Location>> locations = response.getLocations();
        if (!locations.isPresent() || locations.get().isEmpty()) {
            throw new RuntimeException("Could not get locations.");
        }
        Optional<String> locationId = locations.get().get(0).getId();
        if (!locationId.isPresent()) {
            throw new RuntimeException("Could not get location ID.");
        }
        return locationId.get();
    }

    public static String newTestSquareId() {
        return "#" + UUID.randomUUID();
    }

    public static final class CreateCatalogItemOptions {
        public String name = "Item " + UUID.randomUUID();
        public String description = "Test item description";
        public String abbreviation = "TST";
        public List<CreateCatalogItemVariationOptions> variationOpts =
                new ArrayList<CreateCatalogItemVariationOptions>() {
                    {
                        add(new CreateCatalogItemVariationOptions());
                    }
                };

        public CreateCatalogItemOptions name(String name) {
            this.name = name;
            return this;
        }

        public CreateCatalogItemOptions description(String description) {
            this.description = description;
            return this;
        }

        public CreateCatalogItemOptions abbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
            return this;
        }

        public CreateCatalogItemOptions variationOpts(List<CreateCatalogItemVariationOptions> variationOpts) {
            this.variationOpts = variationOpts;
            return this;
        }

        public List<CatalogObject> variations() {
            return variationOpts.stream()
                    .map(CreateCatalogItemVariationOptions::variation)
                    .map(itemVariationData -> CatalogObjectItemVariation.builder()
                            .id("#variation" + UUID.randomUUID())
                            .presentAtAllLocations(true)
                            .itemVariationData(itemVariationData)
                            .build())
                    .map(CatalogObject::itemVariation)
                    .collect(Collectors.toList());
        }
    }

    public static final class CreateCatalogItemVariationOptions {
        public String name = "Variation " + UUID.randomUUID();
        public Money priceMoney =
                Money.builder().amount(1000L).currency(Currency.USD).build();

        public CreateCatalogItemVariationOptions name(String name) {
            this.name = name;
            return this;
        }

        public CreateCatalogItemVariationOptions priceMoney(Money priceMoney) {
            this.priceMoney = priceMoney;
            return this;
        }

        public CatalogItemVariation variation() {
            return CatalogItemVariation.builder()
                    .name(this.name)
                    .trackInventory(true)
                    .pricingType(CatalogPricingType.FIXED_PRICING)
                    .priceMoney(priceMoney)
                    .build();
        }
    }
}
