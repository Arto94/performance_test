package com.kronos.showcase.zerocode.uat;

import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_TASK_GET_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("batch_task_load_config.properties")
public class GetBatchTaskTest {
    private HttpEntity<Object> request;

    @Before
    public void setUp() {
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);
        request = new HttpEntity<>(headers);
    }

    @Test
    public void get_batch_task() {
        ResponseEntity<String> responseEntity = getRestTemplate().exchange(BATCH_TASK_GET_URL, HttpMethod.GET, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
    }
}
