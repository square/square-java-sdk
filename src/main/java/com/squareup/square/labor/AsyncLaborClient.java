/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.squareup.square.labor;

import com.squareup.square.core.ClientOptions;
import com.squareup.square.core.Suppliers;
import java.util.function.Supplier;

public class AsyncLaborClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<AsyncBreakTypesClient> breakTypesClient;

    protected final Supplier<AsyncEmployeeWagesClient> employeeWagesClient;

    protected final Supplier<AsyncShiftsClient> shiftsClient;

    protected final Supplier<AsyncTeamMemberWagesClient> teamMemberWagesClient;

    protected final Supplier<AsyncWorkweekConfigsClient> workweekConfigsClient;

    public AsyncLaborClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.breakTypesClient = Suppliers.memoize(() -> new AsyncBreakTypesClient(clientOptions));
        this.employeeWagesClient = Suppliers.memoize(() -> new AsyncEmployeeWagesClient(clientOptions));
        this.shiftsClient = Suppliers.memoize(() -> new AsyncShiftsClient(clientOptions));
        this.teamMemberWagesClient = Suppliers.memoize(() -> new AsyncTeamMemberWagesClient(clientOptions));
        this.workweekConfigsClient = Suppliers.memoize(() -> new AsyncWorkweekConfigsClient(clientOptions));
    }

    public AsyncBreakTypesClient breakTypes() {
        return this.breakTypesClient.get();
    }

    public AsyncEmployeeWagesClient employeeWages() {
        return this.employeeWagesClient.get();
    }

    public AsyncShiftsClient shifts() {
        return this.shiftsClient.get();
    }

    public AsyncTeamMemberWagesClient teamMemberWages() {
        return this.teamMemberWagesClient.get();
    }

    public AsyncWorkweekConfigsClient workweekConfigs() {
        return this.workweekConfigsClient.get();
    }
}
