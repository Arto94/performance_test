package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.BatchEventDTO;
import com.kronos.showcase.zerocode.model.ObjectRef;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_EVENT_CREATE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("create_batch_event_load_config.properties")
public class CreateBatchEventTest {
    private HttpEntity<BatchEventDTO> request;

    @Before
    public void setUp() {
        BatchEventDTO batchEventDTO = new BatchEventDTO();
        batchEventDTO.setActive(true);
        batchEventDTO.setContext("context");
        batchEventDTO.setDescription("desc");
        batchEventDTO.setName(String.valueOf(System.nanoTime()));
        List<ObjectRef> refs = new ArrayList<>();
        ObjectRef objectRef = new ObjectRef(1L, "task4");
        refs.add(objectRef);
        objectRef = new ObjectRef(2L, "task4");
        refs.add(objectRef);
        objectRef = new ObjectRef(3L, "task4");
        refs.add(objectRef);
        objectRef = new ObjectRef(4L, "task4");
        refs.add(objectRef);
        objectRef = new ObjectRef(5L, "task4");
        refs.add(objectRef);
        batchEventDTO.setBatchEventTasks(refs);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", getCookies());
        request = new HttpEntity<>(batchEventDTO, headers);
    }

    @Test
    public void create_batch_event() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_EVENT_CREATE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
    }
}
