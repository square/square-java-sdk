package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.catalog.types.UpsertCatalogObjectRequest;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.types.BatchChangeInventoryRequest;
import com.squareup.square.types.BatchChangeInventoryResponse;
import com.squareup.square.types.BatchGetInventoryCountsRequest;
import com.squareup.square.types.BatchRetrieveInventoryChangesRequest;
import com.squareup.square.types.CatalogItem;
import com.squareup.square.types.CatalogItemVariation;
import com.squareup.square.types.CatalogObject;
import com.squareup.square.types.CatalogObjectItem;
import com.squareup.square.types.CatalogObjectItemVariation;
import com.squareup.square.types.CatalogPricingType;
import com.squareup.square.types.ChangesInventoryRequest;
import com.squareup.square.types.GetAdjustmentInventoryRequest;
import com.squareup.square.types.GetInventoryAdjustmentResponse;
import com.squareup.square.types.GetInventoryPhysicalCountResponse;
import com.squareup.square.types.GetInventoryRequest;
import com.squareup.square.types.GetPhysicalCountInventoryRequest;
import com.squareup.square.types.InventoryAdjustment;
import com.squareup.square.types.InventoryChange;
import com.squareup.square.types.InventoryChangeType;
import com.squareup.square.types.InventoryCount;
import com.squareup.square.types.InventoryPhysicalCount;
import com.squareup.square.types.InventoryState;
import com.squareup.square.types.UpsertCatalogObjectResponse;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class InventoryTest {
    private SquareClient client;
    private String locationId;
    private String itemVariationId;
    private String physicalCountId;

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();
        locationId = Helpers.getDefaultLocationId(client);

        // Create test catalog object
        CatalogObject catalogObject = CatalogObject.item(CatalogObjectItem.builder()
                .id("#single-item")
                .presentAtAllLocations(true)
                .itemData(CatalogItem.builder()
                        .name("Coffee")
                        .description("Strong coffee")
                        .abbreviation("C")
                        .variations(new ArrayList<CatalogObject>() {
                            {
                                add(CatalogObject.itemVariation(CatalogObjectItemVariation.builder()
                                        .id("#colombian-coffee")
                                        .presentAtAllLocations(true)
                                        .itemVariationData(CatalogItemVariation.builder()
                                                .name("Colombian Fair Trade")
                                                .trackInventory(true)
                                                .pricingType(CatalogPricingType.FIXED_PRICING)
                                                .priceMoney(Helpers.newTestMoney(100))
                                                .build())
                                        .build()));
                            }
                        })
                        .build())
                .build());

        UpsertCatalogObjectResponse catalogResponse = client.catalog()
                .object()
                .upsert(UpsertCatalogObjectRequest.builder()
                        .idempotencyKey(UUID.randomUUID().toString())
                        .object(catalogObject)
                        .build());
        if (!catalogResponse.getCatalogObject().isPresent()) {
            throw new RuntimeException("Catalog object is null.");
        }

        CatalogObjectItem item = catalogObject.getItem().get();
        Optional<List<CatalogObject>> variations = item.getItemData().get().getVariations();
        if (!variations.isPresent() || variations.get().isEmpty()) {
            throw new RuntimeException("Variations are null or empty.");
        }
        itemVariationId = catalogResponse.getIdMappings().get().stream()
                .filter(mapping -> mapping.getClientObjectId().isPresent())
                .filter(mapping -> mapping.getClientObjectId()
                        .get()
                        .equals(variations.get().get(0).getItemVariation().get().getId()))
                .findFirst()
                .get()
                .getObjectId()
                .get();

        // Create initial inventory adjustment
        InventoryAdjustment adjustment = InventoryAdjustment.builder()
                .fromState(InventoryState.NONE)
                .toState(InventoryState.IN_STOCK)
                .locationId(locationId)
                .catalogObjectId(itemVariationId)
                .quantity("100")
                .occurredAt(OffsetDateTime.now().minusHours(8).format(DateTimeFormatter.ISO_INSTANT))
                .build();

        BatchChangeInventoryRequest changeRequest = BatchChangeInventoryRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .changes(new ArrayList<InventoryChange>() {
                    {
                        add(InventoryChange.builder()
                                .type(InventoryChangeType.ADJUSTMENT)
                                .adjustment(adjustment)
                                .build());
                    }
                })
                .build();
        BatchChangeInventoryResponse response = client.inventory().batchCreateChanges(changeRequest);

        Optional<List<InventoryChange>> changes = response.getChanges();
        if (!changes.isPresent()) {
            throw new RuntimeException("Changes are null.");
        }
        changes.get().get(0).getAdjustment();
        if (!changes.get().get(0).getAdjustment().isPresent()) {
            throw new RuntimeException("Adjustment is null.");
        }
        Optional<String> adjustmentId =
                changes.get().get(0).getAdjustment().get().getId();
        if (!adjustmentId.isPresent()) {
            throw new RuntimeException("Adjustment ID is null.");
        }

        // Create physical count
        InventoryChange physicalCount = InventoryChange.builder()
                .type(InventoryChangeType.PHYSICAL_COUNT)
                .physicalCount(InventoryPhysicalCount.builder()
                        .catalogObjectId(itemVariationId)
                        .locationId(locationId)
                        .quantity("1")
                        .state(InventoryState.IN_STOCK)
                        .occurredAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                        .build())
                .build();

        BatchChangeInventoryRequest physicalCountRequest = BatchChangeInventoryRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .changes(new ArrayList<InventoryChange>() {
                    {
                        add(physicalCount);
                    }
                })
                .build();
        client.inventory().batchCreateChanges(physicalCountRequest);

        SyncPagingIterable<InventoryChange> physicalChangesResponse = client.inventory()
                .batchGetChanges(BatchRetrieveInventoryChangesRequest.builder()
                        .types(new ArrayList<InventoryChangeType>() {
                            {
                                add(InventoryChangeType.PHYSICAL_COUNT);
                            }
                        })
                        .catalogObjectIds(new ArrayList<String>() {
                            {
                                add(itemVariationId);
                            }
                        })
                        .locationIds(new ArrayList<String>() {
                            {
                                add(locationId);
                            }
                        })
                        .build());
        Iterator<InventoryChange> physicalChanges = physicalChangesResponse.iterator();
        InventoryChange physicalChange = physicalChanges.next();
        if (!physicalChange.getPhysicalCount().isPresent()) {
            throw new RuntimeException("Physical count is null.");
        }
        if (!physicalChange.getPhysicalCount().get().getId().isPresent()) {
            throw new RuntimeException("Physical count ID is null.");
        }
        physicalCountId = physicalChange.getPhysicalCount().get().getId().get();
    }

    @Test
    public void testBatchChangeInventory() {
        InventoryAdjustment adjustment = InventoryAdjustment.builder()
                .fromState(InventoryState.NONE)
                .toState(InventoryState.IN_STOCK)
                .locationId(locationId)
                .catalogObjectId(itemVariationId)
                .quantity("50")
                .occurredAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                .build();

        BatchChangeInventoryRequest changeRequest = BatchChangeInventoryRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .changes(new ArrayList<InventoryChange>() {
                    {
                        add(InventoryChange.builder()
                                .type(InventoryChangeType.ADJUSTMENT)
                                .adjustment(adjustment)
                                .build());
                    }
                })
                .build();
        BatchChangeInventoryResponse response = client.inventory().batchCreateChanges(changeRequest);

        Assertions.assertTrue(response.getChanges().isPresent());
        Assertions.assertFalse(response.getChanges().get().isEmpty());
        Assertions.assertEquals(
                InventoryState.IN_STOCK,
                response.getChanges()
                        .get()
                        .get(0)
                        .getAdjustment()
                        .get()
                        .getToState()
                        .get());
        Assertions.assertEquals(
                "50",
                response.getChanges()
                        .get()
                        .get(0)
                        .getAdjustment()
                        .get()
                        .getQuantity()
                        .get());
    }

    @Test
    public void testBatchRetrieveInventoryChanges() {
        BatchRetrieveInventoryChangesRequest retrieveRequest = BatchRetrieveInventoryChangesRequest.builder()
                .catalogObjectIds(new ArrayList<String>() {
                    {
                        add(itemVariationId);
                    }
                })
                .build();
        SyncPagingIterable<InventoryChange> response = client.inventory().batchGetChanges(retrieveRequest);
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testBatchRetrieveInventoryCounts() {
        BatchGetInventoryCountsRequest retrieveRequest = BatchGetInventoryCountsRequest.builder()
                .catalogObjectIds(new ArrayList<String>() {
                    {
                        add(itemVariationId);
                    }
                })
                .build();
        SyncPagingIterable<InventoryCount> response = client.inventory().batchGetCounts(retrieveRequest);
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testRetrieveInventoryChanges() {
        SyncPagingIterable<InventoryChange> response = client.inventory()
                .changes(ChangesInventoryRequest.builder()
                        .catalogObjectId(itemVariationId)
                        .build());
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testRetrieveInventoryCount() {
        SyncPagingIterable<InventoryCount> response = client.inventory()
                .get(GetInventoryRequest.builder()
                        .catalogObjectId(itemVariationId)
                        .build());
        Assertions.assertFalse(response.getItems().isEmpty());
    }

    @Test
    public void testRetrieveInventoryPhysicalCount() {
        GetInventoryPhysicalCountResponse response = client.inventory()
                .getPhysicalCount(GetPhysicalCountInventoryRequest.builder()
                        .physicalCountId(physicalCountId)
                        .build());

        Assertions.assertTrue(response.getCount().isPresent());
    }

    @Test
    public void testRetrieveInventoryAdjustment() {
        InventoryAdjustment adjustment = InventoryAdjustment.builder()
                .fromState(InventoryState.NONE)
                .toState(InventoryState.IN_STOCK)
                .locationId(locationId)
                .catalogObjectId(itemVariationId)
                .quantity("10")
                .occurredAt(OffsetDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
                .build();

        BatchChangeInventoryRequest changeRequest = BatchChangeInventoryRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .changes(new ArrayList<InventoryChange>() {
                    {
                        add(InventoryChange.builder()
                                .type(InventoryChangeType.ADJUSTMENT)
                                .adjustment(adjustment)
                                .build());
                    }
                })
                .build();
        BatchChangeInventoryResponse response = client.inventory().batchCreateChanges(changeRequest);

        Optional<List<InventoryChange>> changes = response.getChanges();
        if (!changes.isPresent()) {
            throw new RuntimeException("Changes are null.");
        }
        if (!changes.get().get(0).getAdjustment().isPresent()) {
            throw new RuntimeException("Adjustment is null.");
        }
        if (!changes.get().get(0).getAdjustment().get().getId().isPresent()) {
            throw new RuntimeException("Adjustment ID is null.");
        }
        String adjustmentId = changes.get().get(0).getAdjustment().get().getId().get();
        GetInventoryAdjustmentResponse retrieveResponse = client.inventory()
                .getAdjustment(GetAdjustmentInventoryRequest.builder()
                        .adjustmentId(adjustmentId)
                        .build());
        Optional<InventoryAdjustment> retrieveAdjustment = retrieveResponse.getAdjustment();
        if (!retrieveAdjustment.isPresent()) {
            throw new RuntimeException("Retrieve adjustment is null.");
        }
        Optional<String> retrieveAdjustmentId = retrieveAdjustment.get().getId();
        if (!retrieveAdjustmentId.isPresent()) {
            throw new RuntimeException("Retrieve adjustment ID is null.");
        }

        Assertions.assertTrue(retrieveResponse.getAdjustment().isPresent());
        Assertions.assertEquals(adjustmentId, retrieveAdjustmentId.get());
    }
}
