package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.catalog.types.CreateImagesRequest;
import com.squareup.square.catalog.types.DeleteObjectRequest;
import com.squareup.square.catalog.types.UpsertCatalogObjectRequest;
import com.squareup.square.core.ObjectMappers;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SyncPage;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.BatchDeleteCatalogObjectsRequest;
import com.squareup.square.types.BatchDeleteCatalogObjectsResponse;
import com.squareup.square.types.BatchGetCatalogObjectsRequest;
import com.squareup.square.types.BatchGetCatalogObjectsResponse;
import com.squareup.square.types.BatchUpsertCatalogObjectsRequest;
import com.squareup.square.types.BatchUpsertCatalogObjectsResponse;
import com.squareup.square.types.CatalogIdMapping;
import com.squareup.square.types.CatalogImage;
import com.squareup.square.types.CatalogInfoResponse;
import com.squareup.square.types.CatalogItem;
import com.squareup.square.types.CatalogItemVariation;
import com.squareup.square.types.CatalogModifier;
import com.squareup.square.types.CatalogModifierList;
import com.squareup.square.types.CatalogObject;
import com.squareup.square.types.CatalogObjectBatch;
import com.squareup.square.types.CatalogObjectImage;
import com.squareup.square.types.CatalogObjectItem;
import com.squareup.square.types.CatalogObjectItemVariation;
import com.squareup.square.types.CatalogObjectModifier;
import com.squareup.square.types.CatalogObjectModifierList;
import com.squareup.square.types.CatalogObjectTax;
import com.squareup.square.types.CatalogTax;
import com.squareup.square.types.CreateCatalogImageRequest;
import com.squareup.square.types.CreateCatalogImageResponse;
import com.squareup.square.types.DeleteCatalogObjectResponse;
import com.squareup.square.types.ListCatalogRequest;
import com.squareup.square.types.SearchCatalogItemsRequest;
import com.squareup.square.types.SearchCatalogItemsResponse;
import com.squareup.square.types.SearchCatalogObjectsRequest;
import com.squareup.square.types.SearchCatalogObjectsResponse;
import com.squareup.square.types.TaxCalculationPhase;
import com.squareup.square.types.TaxInclusionType;
import com.squareup.square.types.UpdateItemModifierListsRequest;
import com.squareup.square.types.UpdateItemModifierListsResponse;
import com.squareup.square.types.UpdateItemTaxesRequest;
import com.squareup.square.types.UpdateItemTaxesResponse;
import com.squareup.square.types.UpsertCatalogObjectResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public final class CatalogTest {

    private static final int MAX_RETRIES = 5;
    private static final int MAX_TIMEOUT = 120;

    private SquareClient client;
    private String catalogObjectId;
    private String catalogModifierId;
    private String catalogModifierListId;
    private String catalogTaxId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create(MAX_RETRIES);
        CatalogObject catalogItem = Helpers.createTestCatalogItem(new Helpers.CreateCatalogItemOptions());
        UpsertCatalogObjectResponse catalogResponse = client.catalog()
                .object()
                .upsert(UpsertCatalogObjectRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .object(catalogItem)
                        .build());
        Optional<CatalogObject> catalogObject = catalogResponse.getCatalogObject();
        if (!catalogObject.isPresent()) {
            throw new RuntimeException("Failed to create test catalog item");
        }
        CatalogObjectItem catalogObjectItem = catalogObject.get().getItem().get();
        catalogObjectId = catalogObjectItem.getId();
    }

    @Test
    @Disabled("This test is skipped because the Square API locks the catalog and makes the test unreliable")
    public void testBulkCreateAndPaginateCatalogObjects() {
        // Create 100 catalog objects with 1 CatalogItemVariation each
        List<CatalogObject> catalogObjects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            catalogObjects.add(Helpers.createTestCatalogItem(new Helpers.CreateCatalogItemOptions()));
        }

        // Create the catalog objects in a bulk request
        BatchUpsertCatalogObjectsResponse createCatalogObjectsResp = client.catalog()
                .batchUpsert(BatchUpsertCatalogObjectsRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .batches(new ArrayList<CatalogObjectBatch>() {
                            {
                                add(CatalogObjectBatch.builder()
                                        .objects(catalogObjects)
                                        .build());
                            }
                        })
                        .build());

        Optional<List<CatalogObject>> objects = createCatalogObjectsResp.getObjects();
        Assertions.assertTrue(objects.isPresent());
        Assertions.assertEquals(100, objects.get().size());

        // List all catalog objects
        int numberOfPages = 0;
        SyncPagingIterable<CatalogObject> catalogObjectsResp =
                client.catalog().list(ListCatalogRequest.builder().build());
        numberOfPages++;
        SyncPage<CatalogObject> page = catalogObjectsResp.nextPage();
        Assertions.assertEquals(100, page.getItems().size());

        List<CatalogObject> allObjects = new ArrayList<>();

        do {
            allObjects.addAll(page.getItems());
            page = catalogObjectsResp.nextPage();
            numberOfPages++;
        } while (catalogObjectsResp.hasNext());

        Assertions.assertTrue(numberOfPages > 1);

        BatchDeleteCatalogObjectsResponse deleteCatalogObjectsResp = client.catalog()
                .batchDelete(
                        BatchDeleteCatalogObjectsRequest.builder()
                                .objectIds(allObjects.stream()
                                        .map(CatalogObject::getItem)
                                        .map(Optional::get)
                                        .map(CatalogObjectItem::getId)
                                        .collect(Collectors.toList()))
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());
        Optional<List<String>> deletedObjectIds = deleteCatalogObjectsResp.getDeletedObjectIds();
        Assertions.assertTrue(deletedObjectIds.isPresent());
        Assertions.assertEquals(100, deletedObjectIds.get().size());
    }

    @Test
    public void testUploadCatalogImage() {
        // Setup: Create a catalog object to associate the image with
        CatalogObject catalogObject = Helpers.createTestCatalogItem(new Helpers.CreateCatalogItemOptions());
        BatchUpsertCatalogObjectsResponse createCatalogResp = client.catalog()
                .batchUpsert(
                        BatchUpsertCatalogObjectsRequest.builder()
                                .idempotencyKey(UUID.randomUUID().toString())
                                .batches(new ArrayList<CatalogObjectBatch>() {
                                    {
                                        add(CatalogObjectBatch.builder()
                                                .addObjects(catalogObject)
                                                .build());
                                    }
                                })
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Optional<List<CatalogObject>> objects = createCatalogResp.getObjects();
        Assertions.assertTrue(objects.isPresent());
        Assertions.assertEquals(1, objects.get().size());
        CatalogObject createdCatalogObject = objects.get().get(0);
        CatalogObjectItem catalogObjectItem = createdCatalogObject.getItem().get();

        // Create a new catalog image
        String imageName = "Test Image " + UUID.randomUUID();
        CreateCatalogImageResponse createCatalogImageResp = client.catalog()
                .images()
                .create(
                        CreateImagesRequest.builder()
                                .imageFile(Helpers.getTestFile())
                                .request(CreateCatalogImageRequest.builder()
                                        .idempotencyKey(UUID.randomUUID().toString())
                                        .image(CatalogObject.image(CatalogObjectImage.builder()
                                                .id(Helpers.newTestSquareId())
                                                .imageData(CatalogImage.builder()
                                                        .name(imageName)
                                                        .build())
                                                .build()))
                                        .objectId(catalogObjectItem.getId())
                                        .build())
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());
        CatalogObjectImage image =
                createCatalogImageResp.getImage().get().getImage().get();
        Assertions.assertNotNull(image);

        // Cleanup
        client.catalog()
                .batchDelete(
                        BatchDeleteCatalogObjectsRequest.builder()
                                .objectIds(new ArrayList<String>() {
                                    {
                                        add(catalogObjectItem.getId());
                                        add(image.getId());
                                    }
                                })
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());
    }

    @Test
    public void testUpsertCatalogObject() {
        CatalogObject coffee = Helpers.createTestCatalogItem(new Helpers.CreateCatalogItemOptions()
                .name("Coffee")
                .description("Strong coffee")
                .abbreviation("C")
                .variationOpts(new ArrayList<Helpers.CreateCatalogItemVariationOptions>() {
                    {
                        add(new Helpers.CreateCatalogItemVariationOptions()
                                .priceMoney(Helpers.newTestMoney(100))
                                .name("Colombian Fair Trade"));
                    }
                }));

        UpsertCatalogObjectResponse response = client.catalog()
                .object()
                .upsert(
                        UpsertCatalogObjectRequest.builder()
                                .idempotencyKey(UUID.randomUUID().toString())
                                .object(coffee)
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());
        Optional<CatalogObject> catalogObject = response.getCatalogObject();

        Assertions.assertNotNull(response);
        Assertions.assertTrue(catalogObject.isPresent());
        Assertions.assertTrue(catalogObject.get().isItem());
        CatalogObjectItem item = catalogObject.get().getItem().get();
        Optional<CatalogItem> itemData = item.getItemData();
        Assertions.assertTrue(itemData.isPresent());
        Optional<List<CatalogObject>> variations = itemData.get().getVariations();
        Assertions.assertTrue(variations.isPresent());
        Assertions.assertEquals(1, variations.get().size());

        CatalogObject variationObject = variations.get().get(0);
        CatalogObjectItemVariation variation =
                variationObject.getItemVariation().get();
        Optional<CatalogItemVariation> itemVariationData = variation.getItemVariationData();
        Assertions.assertTrue(itemVariationData.isPresent());
        Assertions.assertEquals(
                "Colombian Fair Trade", itemVariationData.get().getName().get());
    }

    @Test
    public void testCatalogInfo() {
        CatalogInfoResponse response = client.catalog()
                .info(RequestOptions.builder().timeout(MAX_TIMEOUT).build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testSearchCatalogObjects() {
        SearchCatalogObjectsRequest searchRequest =
                SearchCatalogObjectsRequest.builder().limit(1).build();
        SearchCatalogObjectsResponse response = client.catalog()
                .search(
                        searchRequest,
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Assertions.assertTrue(response.getObjects().isPresent());
        Assertions.assertFalse(response.getObjects().get().isEmpty());
    }

    @Test
    public void testSearchCatalogItems() {
        SearchCatalogItemsResponse response = client.catalog()
                .searchItems(
                        SearchCatalogItemsRequest.builder().limit(1).build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());
        Assertions.assertNotNull(response);
    }

    @Test
    public void testBatchUpsertCatalogObjects() {
        CatalogObject modifier = CatalogObject.modifier(CatalogObjectModifier.builder()
                .id("#temp-modifier-id")
                .modifierData(CatalogModifier.builder()
                        .name("Limited Time Only Price")
                        .priceMoney(Helpers.newTestMoney(200))
                        .build())
                .build());

        CatalogObject modifierList = CatalogObject.modifierList(CatalogObjectModifierList.builder()
                .id("#temp-modifier-list-id")
                .modifierListData(CatalogModifierList.builder()
                        .name("Special weekend deals")
                        .modifiers(new ArrayList<CatalogObject>() {
                            {
                                add(modifier);
                            }
                        })
                        .build())
                .build());

        CatalogObject tax = CatalogObject.tax(CatalogObjectTax.builder()
                .id("#temp-tax-id")
                .taxData(CatalogTax.builder()
                        .name("Online only Tax")
                        .calculationPhase(TaxCalculationPhase.TAX_SUBTOTAL_PHASE)
                        .inclusionType(TaxInclusionType.ADDITIVE)
                        .percentage("5.0")
                        .appliesToCustomAmounts(true)
                        .enabled(true)
                        .build())
                .build());

        BatchUpsertCatalogObjectsResponse response = client.catalog()
                .batchUpsert(
                        BatchUpsertCatalogObjectsRequest.builder()
                                .idempotencyKey(UUID.randomUUID().toString())
                                .batches(new ArrayList<CatalogObjectBatch>() {
                                    {
                                        add(CatalogObjectBatch.builder()
                                                .objects(new ArrayList<CatalogObject>() {
                                                    {
                                                        add(tax);
                                                        add(modifierList);
                                                    }
                                                })
                                                .build());
                                    }
                                })
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Assertions.assertNotNull(response);
        Optional<List<CatalogObject>> objects = response.getObjects();
        Assertions.assertTrue(objects.isPresent());
        Assertions.assertEquals(2, objects.get().size());

        Optional<List<CatalogIdMapping>> idMappings = response.getIdMappings();
        Assertions.assertTrue(idMappings.isPresent());

        // Store IDs for later use
        catalogTaxId = idMappings.get().stream()
                .filter(mapping -> mapping.getClientObjectId().get().equals("#temp-tax-id"))
                .map(mapping -> mapping.getObjectId().get())
                .findFirst()
                .get();
        catalogModifierId = idMappings.get().stream()
                .filter(mapping -> mapping.getClientObjectId().get().equals("#temp-modifier-id"))
                .map(mapping -> mapping.getObjectId().get())
                .findFirst()
                .get();
        catalogModifierListId = idMappings.get().stream()
                .filter(mapping -> mapping.getClientObjectId().get().equals("#temp-modifier-list-id"))
                .map(mapping -> mapping.getObjectId().get())
                .findFirst()
                .get();
    }

    @Test
    public void testBatchRetrieveCatalogObjects() {
        testBatchUpsertCatalogObjects();

        BatchGetCatalogObjectsResponse response = client.catalog()
                .batchGet(
                        BatchGetCatalogObjectsRequest.builder()
                                .objectIds(new ArrayList<String>() {
                                    {
                                        add(catalogModifierId);
                                        add(catalogModifierListId);
                                        add(catalogTaxId);
                                    }
                                })
                                .build(),
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Assertions.assertTrue(response.getObjects().isPresent());
        Assertions.assertEquals(3, response.getObjects().get().size());
        List<CatalogObject> respObjects = response.getObjects().get();
        Set<String> respObjectIds = respObjects.stream()
                .map(obj -> ObjectMappers.JSON_MAPPER.valueToTree(obj).get("id").textValue())
                .collect(Collectors.toSet());
        Assertions.assertEquals(
                new HashSet<String>() {
                    {
                        add(catalogModifierId);
                        add(catalogModifierListId);
                        add(catalogTaxId);
                    }
                },
                respObjectIds);
    }

    @Test
    public void testUpdateItemTaxes() {
        testBatchUpsertCatalogObjects();

        UpdateItemTaxesRequest updateRequest = UpdateItemTaxesRequest.builder()
                .itemIds(new ArrayList<String>() {
                    {
                        add(catalogObjectId);
                    }
                })
                .taxesToEnable(new ArrayList<String>() {
                    {
                        add(catalogTaxId);
                    }
                })
                .build();
        UpdateItemTaxesResponse response = client.catalog()
                .updateItemTaxes(
                        updateRequest,
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Assertions.assertTrue(response.getUpdatedAt().isPresent());
        Assertions.assertFalse(response.getErrors().isPresent());
    }

    @Test
    public void testUpdateItemModifierLists() {
        testBatchUpsertCatalogObjects();

        UpdateItemModifierListsRequest updateRequest = UpdateItemModifierListsRequest.builder()
                .itemIds(new ArrayList<String>() {
                    {
                        add(catalogObjectId);
                    }
                })
                .modifierListsToEnable(new ArrayList<String>() {
                    {
                        add(catalogModifierListId);
                    }
                })
                .build();
        UpdateItemModifierListsResponse response = client.catalog()
                .updateItemModifierLists(
                        updateRequest,
                        RequestOptions.builder().timeout(MAX_TIMEOUT).build());

        Assertions.assertTrue(response.getUpdatedAt().isPresent());
        Assertions.assertFalse(response.getErrors().isPresent());
    }

    @Test
    public void testDeleteCatalogObject() {
        DeleteObjectRequest deleteRequest =
                DeleteObjectRequest.builder().objectId(catalogObjectId).build();
        DeleteCatalogObjectResponse response = client.catalog().object().delete(deleteRequest);

        Assertions.assertNotNull(response);
    }
}
