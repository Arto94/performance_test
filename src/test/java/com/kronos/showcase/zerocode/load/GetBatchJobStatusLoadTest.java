package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.GetBatchJobStatusTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = GetBatchJobStatusTest.class, testMethod = "get_batch_job_status")
@LoadWith("get_batch_job_status_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class GetBatchJobStatusLoadTest {
}
