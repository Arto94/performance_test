package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.BatchJobStatusDTO;
import com.kronos.showcase.zerocode.model.BatchJobWhereDTO;
import com.kronos.showcase.zerocode.model.ObjectRef;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static com.kronos.showcase.zerocode.uat.BatchHelper.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("get_batch_job_status_load_config.properties")
public class GetBatchJobStatusTest {
    private HttpEntity<BatchJobStatusDTO> request;

    @Before
    public void setUp() {
        BatchJobStatusDTO batchJobStatusDTO = new BatchJobStatusDTO();
        BatchJobWhereDTO where = new BatchJobWhereDTO();
        where.setStatus("All");
        where.setIncludeBatchDetails(false);
        where.setCreatedBy("system");
        where.setLaunchDate("11/06/2021");
        ObjectRef objectRef = new ObjectRef(1L, "group");
        where.setGroup(objectRef);
        batchJobStatusDTO.setWhere(where);
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);
        request = new HttpEntity<>(batchJobStatusDTO, headers);
    }

    @Test
    public void get_batch_job_status() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_JOB_STATUS_READ_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
    }
}
