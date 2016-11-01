package com.yambay.job.web;

import com.yambay.job.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chrisp on 5/10/16.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JobController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;

    @Before
    public void setUp() throws Exception {

       /* mockMvc = MockMvcBuilders.standaloneSetup(new JobController())
                .setHandlerExceptionResolvers(createExceptionResolver())
                .build();*/
        // FileSystemUtils.deleteRecursively(new File("target/generated-snippets"));

        JobView sampleJob = getDummyJob();

        given(this.jobService.getJob("UKPN_OMS","1234")).willReturn(sampleJob);
        given(this.jobService.getJob("UKPN_OMS","9999")).willThrow(new JobNotFoundException("UKPN_OMS", "9999"));

    }


    @Test
    public void createJob() throws Exception {
    }

    @Test
    public void getJob() throws Exception {

        this.mockMvc
                .perform(
                        get("/job/{jobSource}/{jobCode}", "UKPN_OMS", "1234").accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Remove Fuse from Subiaco Square")))
                .andDo(document("get-job",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(parameterWithName("jobSource").description("A unique identifier of the source system for the job"),
                                parameterWithName("jobCode").description("A unique identifier for the job within the specified source system")),
                        responseFields(
                                fieldWithPath("jobSource").description("The external source system of the job"),
                                fieldWithPath("jobCode").description("External identifier of the job record"),
                                fieldWithPath("attentionComment").description("The field used for any attention comments"),
                                fieldWithPath("jobType").description("The type of work for the job"),
                                fieldWithPath("latitude").description("The latitude for the primary location"),
                                fieldWithPath("longitude").description("The longitude for the primary location"),
                                fieldWithPath("scheduleDate").description("The date the job is scheduled to be done"),
                                fieldWithPath("jobSummary").description("A descriptive summary of the job"),
                                fieldWithPath("description").description("A full description of the job"),
                                fieldWithPath("jobListSummary").description("A descriptive summary of the job to be presented in list views"),
                                fieldWithPath("displayOrder").description("Used to order the jobs in job list"),
                                fieldWithPath("attentionFlag").description("Indicates if the attention indicator should be displayed against the job"),
                                fieldWithPath("jobListColumn1").optional().description("The content to display in the first column of the job list view"),
                                fieldWithPath("jobListColumn2").description("The content to display in the second column of the job list view"),
                                fieldWithPath("supervisorUser").description("The external userId of the supervisor"),

                                fieldWithPath("operations.[].externalId").description("The external identifier for the operation"),

                                fieldWithPath("operations.[].operationDisplayOrder").description("Used to order the operations in the operation list"),
                                fieldWithPath("operations.[].operationType").description("The type of operation"),
                                fieldWithPath("operations.[].operationStatus").description("The status of the operation"),
                                fieldWithPath("operations.[].displayedState").description("The displayed description for the operation status"),
                                fieldWithPath("operations.[].operationDisplayText").description("The descriptive text to display for the operation"),
                                fieldWithPath("operations.[].operationSummary").description("A descriptive summary for the operation"),
                                fieldWithPath("operations.[].operationDisplayId").description("The id to display for the operation"),
                                fieldWithPath("operations.[].operationStatusFlowId").description("Determines the status flow for the operation"),
                                fieldWithPath("operations.[].userId").description("The external userId assigned to the operation"),
                                fieldWithPath("operations.[].operationNotes").description("Notes for the operation"),
                                fieldWithPath("operations.[].operationInstructedTime").description("The time the operation was instructed"),
                                fieldWithPath("operations.[].operationConfirmedTime").description("The time the operation was confirmed"),
                                fieldWithPath("operations.[].operationAbortedTime").description("The time the operation was aborted"),
                                fieldWithPath("operations.[].operationComponentId").description("The external identifier for the component"),
                                fieldWithPath("operations.[].operationComponentName").description("The descriptive name for the component"),
                                fieldWithPath("operations.[].location").description("The description of the location for the operation"),
                                fieldWithPath("operations.[].circuit").description("The name of the circuit for the operation"),
                                fieldWithPath("operations.[].action").description("The action to be executed for this operation"),
                                fieldWithPath("operations.[].text").description("Additional text related to the operation"),
                                fieldWithPath("operations.[].documentId").description("The identifier of the associated document"),
                                fieldWithPath("operations.[].documentRef").description("The external identifier of the associated document"),
                                fieldWithPath("operations.[].documentDetails").description("A string representation of the associated document details")


                        )
                        )

                );

    }

/*
    @Test(expected = JobNotFoundException.class)
    public void getJobNotFound() throws Exception {

        this.mockMvc
                .perform(
                        get("/job/{jobSource}/{jobCode}", "UKPN_OMS", "9999").accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Job with jobSource:")))
                .andExpect(content().string(containsString(" does not exist")))
                .andDo(document("get-job-not-found",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())
                        )
                );

    }*/


    public JobView getDummyJob() {
        JobView job = new JobView();
        job.setJobSource("UKPN_OMS");
        job.setJobCode("1234");
        job.setAttentionComment("Attention!!!");
        job.setAttentionFlag(1);
        job.setDescription("Remove Fuse from Subiaco Square");
        job.setDisplayOrder("1");
        job.setJobListColumn1("col1");
        job.setJobListColumn2("col2");
        job.setJobListSummary("Remove Fuse");
        job.setJobType("LV");
        job.setLatitude("56.0");
        job.setLongitude("-1.1");
        job.setScheduleDate(new Date());
        job.setJobSummary("Remove Fuse from Subiaco Square");
        job.setSupervisorUser("roys");

        OperationView operation = new OperationView();
        operation.setAction("Open");
        operation.setCircuit("Subiaco 1");
        operation.setDisplayedState("Confirmed");
        operation.setLocation("Subiaco Square");
        operation.setOperationComponentId("ALIAS-1234-A");
        operation.setOperationComponentName("CB-Subiaco");
        operation.setOperationConfirmedTime(new Date());
        operation.setOperationStatus("1");
        operation.setOperationSummary("Remove Fuse");
        operation.setOperationType("4");

        List<OperationView> operations = new ArrayList<>();
        operations.add(operation);
        job.setOperations(operations);

        return job;

    }

}