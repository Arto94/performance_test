package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.GetBatchEventTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = GetBatchEventTest.class, testMethod = "get_batch_event")
@LoadWith("batch_event_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class GetBatchEventLoadTest {
}
