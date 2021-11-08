package com.kronos.showcase.zerocode.uat;

import com.kronos.showcase.zerocode.model.group.BatchGroupWhereObject;
import com.kronos.showcase.zerocode.model.group.CombinationGroupRequest;
import com.kronos.showcase.zerocode.model.group.Where;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static com.kronos.showcase.zerocode.uat.BatchHelper.BATCH_GROUP_DELETE_URL;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getCookies;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getId;
import static com.kronos.showcase.zerocode.uat.BatchHelper.getRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(ZeroCodeUnitRunner.class)
@TargetEnv("delete_batch_group_load_config.properties")
public class DeleteBatchGroupTest {
    private HttpEntity<CombinationGroupRequest> request;

    @Before
    public void setUp() {
        String cookieHeader = getCookies();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieHeader);

        CombinationGroupRequest combinationGroupRequest = new CombinationGroupRequest();
        Where where = new Where();
        BatchGroupWhereObject batchGroupWhereObject = new BatchGroupWhereObject();
        batchGroupWhereObject.setIds(Collections.singletonList(getId()));

        where.setBatchGroups(batchGroupWhereObject);
        combinationGroupRequest.setWhere(where);
        request = new HttpEntity<>(combinationGroupRequest, headers);
    }

    @Test
    public void delete_batch_group() {
        ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(BATCH_GROUP_DELETE_URL, request, String.class);
        assertThat(responseEntity.getStatusCode().value()).isEqualTo(204);
    }
}
