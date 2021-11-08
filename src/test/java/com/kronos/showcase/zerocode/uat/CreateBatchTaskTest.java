package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.BatchTaskDTO;
import com.kronos.showcase.zerocode.model.BatchTaskItemDTO;
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

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_TASK_CREATE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("create_batch_task_load_config.properties")
public class CreateBatchTaskTest {
    private HttpEntity<BatchTaskDTO> request;

    @Before
    public void setUp() {
        BatchTaskDTO batchTaskDTO = new BatchTaskDTO();
        batchTaskDTO.setActive(true);
        batchTaskDTO.setContext("context");
        batchTaskDTO.setDescription("desc");
        batchTaskDTO.setName(String.valueOf(System.nanoTime()));

        List<BatchTaskItemDTO> batchTaskItemDTOList = new ArrayList<>();
        BatchTaskItemDTO batchTaskItemDTO = new BatchTaskItemDTO();
        batchTaskItemDTO.setActionName(new ObjectRef(1L, "//Organization"));
        batchTaskItemDTO.setActionType(new ObjectRef(120L, "CONSOLIDATE_VOLUME_BUDGET"));
        batchTaskItemDTO.setParameterString("/W1");
        batchTaskItemDTO.setSequenceNumber(1);
        batchTaskItemDTOList.add(batchTaskItemDTO);
        batchTaskDTO.setBatchTaskItems(batchTaskItemDTOList);

        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);
        request = new HttpEntity<>(batchTaskDTO, headers);
    }

    @Test
    public void create_batch_task() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_TASK_CREATE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
    }
}
