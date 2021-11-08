package com.kronos.showcase.zerocode.load;

import com.kronos.showcase.zerocode.uat.GetBatchGroupTest;
import org.jsmart.zerocode.core.domain.LoadWith;
import org.jsmart.zerocode.core.domain.TestMapping;
import org.jsmart.zerocode.core.runner.parallel.ZeroCodeLoadRunner;
import org.junit.runner.RunWith;

@TestMapping(testClass = GetBatchGroupTest.class, testMethod = "get_batch_group")
@LoadWith("batch_group_load_config.properties")
@RunWith(ZeroCodeLoadRunner.class)
public class GetBatchGroupLoadTest {
}
