package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.BatchGroupDTO;
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

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_GROUP_CREATE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("create_batch_group_load_config.properties")
public class CreateBatchGroupTest {
    private HttpEntity<BatchGroupDTO> request;

    @Before
    public void setUp() {
        BatchGroupDTO batchGroupDTO = new BatchGroupDTO();
        batchGroupDTO.setActive(true);
        batchGroupDTO.setDescription("desc");
        batchGroupDTO.setName(String.valueOf(System.nanoTime()));
        List<ObjectRef> refs = new ArrayList<>();
        ObjectRef objectRef = new ObjectRef(1L, "event");
        refs.add(objectRef);
        objectRef = new ObjectRef(2L, "event");
        refs.add(objectRef);
        objectRef = new ObjectRef(3L, "event");
        refs.add(objectRef);
        objectRef = new ObjectRef(4L, "event");
        refs.add(objectRef);
        objectRef = new ObjectRef(5L, "event");
        refs.add(objectRef);
        batchGroupDTO.setBatchEvents(refs);
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);
        request = new HttpEntity<>(batchGroupDTO, headers);
    }

    @Test
    public void create_batch_group() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_GROUP_CREATE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
    }
}
