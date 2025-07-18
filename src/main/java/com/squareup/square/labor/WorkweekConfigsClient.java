/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.labor;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.RequestOptions;
import com.squareup.square.core.SyncPagingIterable;
import com.squareup.square.labor.types.ListWorkweekConfigsRequest;
import com.squareup.square.labor.types.UpdateWorkweekConfigRequest;
import com.squareup.square.types.UpdateWorkweekConfigResponse;
import com.squareup.square.types.WorkweekConfig;

public class WorkweekConfigsClient {
    protected final ClientOptions clientOptions;

    private final RawWorkweekConfigsClient rawClient;

    public WorkweekConfigsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawWorkweekConfigsClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawWorkweekConfigsClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Returns a list of <code>WorkweekConfig</code> instances for a business.
     */
    public SyncPagingIterable<WorkweekConfig> list() {
        return this.rawClient.list().body();
    }

    /**
     * Returns a list of <code>WorkweekConfig</code> instances for a business.
     */
    public SyncPagingIterable<WorkweekConfig> list(ListWorkweekConfigsRequest request) {
        return this.rawClient.list(request).body();
    }

    /**
     * Returns a list of <code>WorkweekConfig</code> instances for a business.
     */
    public SyncPagingIterable<WorkweekConfig> list(ListWorkweekConfigsRequest request, RequestOptions requestOptions) {
        return this.rawClient.list(request, requestOptions).body();
    }

    /**
     * Updates a <code>WorkweekConfig</code>.
     */
    public UpdateWorkweekConfigResponse get(UpdateWorkweekConfigRequest request) {
        return this.rawClient.get(request).body();
    }

    /**
     * Updates a <code>WorkweekConfig</code>.
     */
    public UpdateWorkweekConfigResponse get(UpdateWorkweekConfigRequest request, RequestOptions requestOptions) {
        return this.rawClient.get(request, requestOptions).body();
    }
}
