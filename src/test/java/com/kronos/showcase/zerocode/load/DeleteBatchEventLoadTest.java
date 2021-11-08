package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.DeleteBatchEventTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = DeleteBatchEventTest.class, testMethod = "delete_batch_event")
@LoadWith("delete_batch_event_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class DeleteBatchEventLoadTest {
}
