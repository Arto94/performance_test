package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.CreateBatchTaskTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = CreateBatchTaskTest.class, testMethod = "create_batch_task")
@LoadWith("create_batch_task_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class CreateBatchTaskLoadTest {
}
