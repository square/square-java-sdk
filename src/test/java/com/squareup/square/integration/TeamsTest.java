package com.squareup.square.integration;

import com.squareup.square.SquareClient;
import com.squareup.square.teammembers.types.UpdateWageSettingRequest;
import com.squareup.square.types.BatchCreateTeamMembersRequest;
import com.squareup.square.types.BatchCreateTeamMembersResponse;
import com.squareup.square.types.BatchUpdateTeamMembersRequest;
import com.squareup.square.types.BatchUpdateTeamMembersResponse;
import com.squareup.square.types.CreateTeamMemberRequest;
import com.squareup.square.types.CreateTeamMemberResponse;
import com.squareup.square.types.GetTeamMemberResponse;
import com.squareup.square.types.GetTeamMembersRequest;
import com.squareup.square.types.JobAssignment;
import com.squareup.square.types.JobAssignmentPayType;
import com.squareup.square.types.Money;
import com.squareup.square.types.SearchTeamMembersRequest;
import com.squareup.square.types.SearchTeamMembersResponse;
import com.squareup.square.types.TeamMember;
import com.squareup.square.types.UpdateTeamMemberRequest;
import com.squareup.square.types.UpdateTeamMembersRequest;
import com.squareup.square.types.UpdateWageSettingResponse;
import com.squareup.square.types.WageSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Skipped due to server-side SquareApiException errors")
public final class TeamsTest {
    private SquareClient client;
    private String memberId;
    private List<String> bulkMemberIds = new ArrayList<>();

    @BeforeEach
    public void before() {
        client = TestClientFactory.create();

        // Create team member for testing
        CreateTeamMemberRequest createRequest = CreateTeamMemberRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .teamMember(TeamMember.builder()
                        .givenName("Sherlock")
                        .familyName("Holmes")
                        .build())
                .build();
        CreateTeamMemberResponse memberResponse = client.teamMembers().create(createRequest);
        Optional<TeamMember> member = memberResponse.getTeamMember();
        if (!member.isPresent() || !member.get().getId().isPresent()) {
            throw new RuntimeException("Member is null or ID is null.");
        }
        memberId = member.get().getId().get();

        // Create bulk team members for testing
        BatchCreateTeamMembersRequest bulkRequest = BatchCreateTeamMembersRequest.builder()
                .teamMembers(new HashMap<String, CreateTeamMemberRequest>() {
                    {
                        put(
                                "id1",
                                CreateTeamMemberRequest.builder()
                                        .teamMember(TeamMember.builder()
                                                .givenName("Donatello")
                                                .familyName("Splinter")
                                                .build())
                                        .build());
                        put(
                                "id2",
                                CreateTeamMemberRequest.builder()
                                        .teamMember(TeamMember.builder()
                                                .givenName("Leonardo")
                                                .familyName("Splinter")
                                                .build())
                                        .build());
                    }
                })
                .build();
        BatchCreateTeamMembersResponse bulkResponse = client.teamMembers().batchCreate(bulkRequest);
        for (Map.Entry<String, CreateTeamMemberResponse> result :
                bulkResponse.getTeamMembers().orElse(new HashMap<>()).entrySet()) {
            Optional<TeamMember> teamMember = result.getValue().getTeamMember();
            if (!teamMember.isPresent() || !teamMember.get().getId().isPresent()) {
                throw new RuntimeException("Team member is null or ID is null.");
            }
            bulkMemberIds.add(teamMember.get().getId().get());
        }
    }

    @Test
    public void testSearchTeamMembers() {
        SearchTeamMembersRequest searchRequest =
                SearchTeamMembersRequest.builder().limit(1).build();
        SearchTeamMembersResponse response = client.teamMembers().search(searchRequest);

        Assertions.assertTrue(response.getTeamMembers().isPresent());
        Assertions.assertFalse(response.getTeamMembers().get().isEmpty());
    }

    @Test
    public void testCreateTeamMember() {
        CreateTeamMemberRequest createRequest = CreateTeamMemberRequest.builder()
                .idempotencyKey(UUID.randomUUID().toString())
                .teamMember(TeamMember.builder()
                        .givenName("John")
                        .familyName("Watson")
                        .build())
                .build();
        CreateTeamMemberResponse response = client.teamMembers().create(createRequest);

        Assertions.assertTrue(response.getTeamMember().isPresent());
        Assertions.assertEquals(
                "John", response.getTeamMember().get().getGivenName().get());
        Assertions.assertEquals(
                "Watson", response.getTeamMember().get().getFamilyName().get());
    }

    @Test
    public void testRetrieveTeamMember() {
        GetTeamMemberResponse response = client.teamMembers()
                .get(GetTeamMembersRequest.builder().teamMemberId(memberId).build());

        Assertions.assertTrue(response.getTeamMember().isPresent());
        Assertions.assertEquals(memberId, response.getTeamMember().get().getId().get());
    }

    @Test
    public void testUpdateTeamMember() {
        UpdateTeamMembersRequest updateRequest = UpdateTeamMembersRequest.builder()
                .teamMemberId(memberId)
                .body(UpdateTeamMemberRequest.builder()
                        .teamMember(TeamMember.builder()
                                .givenName("Agent")
                                .familyName("Smith")
                                .build())
                        .build())
                .build();
        client.teamMembers().update(updateRequest);
        GetTeamMemberResponse getResponse = client.teamMembers()
                .get(GetTeamMembersRequest.builder().teamMemberId(memberId).build());

        Optional<TeamMember> teamMember = getResponse.getTeamMember();
        Assertions.assertTrue(teamMember.isPresent());
        Assertions.assertEquals("Agent", teamMember.get().getGivenName().get());
        Assertions.assertEquals("Smith", teamMember.get().getFamilyName().get());
    }

    @Test
    public void testUpdateWageSetting() {
        UpdateWageSettingRequest updateRequest = UpdateWageSettingRequest.builder()
                .teamMemberId(memberId)
                .wageSetting(WageSetting.builder()
                        .jobAssignments(new ArrayList<JobAssignment>() {
                            {
                                add(JobAssignment.builder()
                                        .payType(JobAssignmentPayType.HOURLY)
                                        .hourlyRate(Helpers.newTestMoney(2500))
                                        .jobTitle("Math tutor")
                                        .build());
                            }
                        })
                        .build())
                .build();
        UpdateWageSettingResponse response = client.teamMembers().wageSetting().update(updateRequest);

        Assertions.assertTrue(response.getWageSetting().isPresent());
        Optional<List<JobAssignment>> jobAssignments =
                response.getWageSetting().get().getJobAssignments();
        Assertions.assertTrue(jobAssignments.isPresent());
        Assertions.assertFalse(jobAssignments.get().isEmpty());
        Assertions.assertEquals(
                "Math tutor", jobAssignments.get().get(0).getJobTitle().get());
        Optional<Money> hourlyRate = jobAssignments.get().get(0).getHourlyRate();
        Assertions.assertTrue(hourlyRate.isPresent());
        Assertions.assertEquals(2500, hourlyRate.get().getAmount().get());
    }

    @Test
    public void testBatchUpdateTeamMembers() {
        BatchUpdateTeamMembersRequest updateRequest = BatchUpdateTeamMembersRequest.builder()
                .teamMembers(new HashMap<String, UpdateTeamMemberRequest>() {
                    {
                        put(
                                bulkMemberIds.get(0),
                                UpdateTeamMemberRequest.builder()
                                        .teamMember(TeamMember.builder()
                                                .givenName("Raphael")
                                                .familyName("Splinter")
                                                .build())
                                        .build());
                        put(
                                bulkMemberIds.get(1),
                                UpdateTeamMemberRequest.builder()
                                        .teamMember(TeamMember.builder()
                                                .givenName("Leonardo")
                                                .familyName("Splinter")
                                                .build())
                                        .build());
                    }
                })
                .build();
        BatchUpdateTeamMembersResponse response = client.teamMembers().batchUpdate(updateRequest);

        Assertions.assertTrue(response.getTeamMembers().isPresent());
        Assertions.assertEquals(2, response.getTeamMembers().get().size());
    }
}
