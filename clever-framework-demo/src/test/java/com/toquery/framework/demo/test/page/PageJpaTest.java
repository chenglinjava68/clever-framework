package com.toquery.framework.demo.test.page;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.toquery.framework.demo.entity.BizJpaNews;
import com.toquery.framework.demo.service.IBizJpaNewsService;
import com.toquery.framework.demo.test.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author toquery
 * @version 1
 */
@Slf4j
public class PageJpaTest extends BaseSpringTest {


    @Resource
    private IBizJpaNewsService jpaDemoService;

    @Test
    public void insertData() {
        int size = 12;

        List<BizJpaNews> saveAll = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            BizJpaNews tbJpaDemo = new BizJpaNews("test-page-" + (i + 1),size - i - 1, new Date());
            saveAll.add(tbJpaDemo);
        }
        saveAll = jpaDemoService.save(saveAll);
        log.info("插入的数据 saveBatch ：\n{}", JSON.toJSONString(saveAll));
    }
}
