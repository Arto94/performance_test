package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.event.BatchEventWhereObject;
import com.kronos.showcase.zerocode.model.event.CombinationEventRequest;
import com.kronos.showcase.zerocode.model.event.Where;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_EVENT_DELETE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getId;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("delete_batch_event_load_config.properties")
public class DeleteBatchEventTest {
    private HttpEntity<CombinationEventRequest> request;

    @Before
    public void setUp() {
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);

        CombinationEventRequest combinationEventRequest = new CombinationEventRequest();
        Where where = new Where();
        BatchEventWhereObject batchEventWhereObject = new BatchEventWhereObject();
        batchEventWhereObject.setIds(Collections.singletonList(getId()));

        where.setBatchEvents(batchEventWhereObject);
        combinationEventRequest.setWhere(where);
        request = new HttpEntity<>(combinationEventRequest, headers);
    }

    @Test
    public void delete_batch_event() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_EVENT_DELETE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(204);
    }
}
