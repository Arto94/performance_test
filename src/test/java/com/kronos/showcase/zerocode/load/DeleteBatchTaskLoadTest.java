package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.DeleteBatchTaskTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = DeleteBatchTaskTest.class, testMethod = "delete_batch_task")
@LoadWith("delete_batch_task_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class DeleteBatchTaskLoadTest {
}
