package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.task.BatchTaskWhereObject;
import com.kronos.showcase.zerocode.model.task.CombinationTaskRequest;
import com.kronos.showcase.zerocode.model.task.Where;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_TASK_DELETE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getId;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("delete_batch_task_load_config.properties")
public class DeleteBatchTaskTest {
    private HttpEntity<CombinationTaskRequest> request;

    @Before
    public void setUp() {
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);

        CombinationTaskRequest combinationTaskRequest = new CombinationTaskRequest();
        Where where = new Where();
        BatchTaskWhereObject batchTaskWhereObject = new BatchTaskWhereObject();
        batchTaskWhereObject.setIds(Collections.singletonList(getId()));

        where.setBatchTasks(batchTaskWhereObject);
        combinationTaskRequest.setWhere(where);
        request = new HttpEntity<>(combinationTaskRequest, headers);
    }

    @Test
    public void delete_batch_task() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_TASK_DELETE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(204);
    }
}
