package com.toquery.framework.demo.test.curd;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.toquery.framework.demo.entity.BizBatisNews;
import com.toquery.framework.demo.service.IBizBatisNewsService;
import com.toquery.framework.demo.test.BaseSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author toquery
 * @version 1
 */
@Slf4j
public class ServiceMybatisCurdTest extends BaseSpringTest {

    @Resource
    private IBizBatisNewsService myBatisDemoService;

    @Test
    public void curd() {
        BizBatisNews save = myBatisDemoService.save(new BizBatisNews("save-test", new Date()));
        log.info("插入的数据 save ：\n{}", JSON.toJSONString(save));

        List<BizBatisNews> saveAll = myBatisDemoService.save(Lists.newArrayList(
                new BizBatisNews("saveAll-test", new Date()),
                new BizBatisNews("saveAll-test", new Date())
        ));
        log.info("插入的数据 saveBatch ：\n{}", JSON.toJSONString(saveAll));

        BizBatisNews updateEntity = myBatisDemoService.update(save.getId(), "update-entity");
        log.info("插入的数据 updateEntity ：\n{}", JSON.toJSONString(updateEntity));


        save.setName("save-test-update");
        BizBatisNews update = myBatisDemoService.update(save, Sets.newHashSet("name"));
        log.info("修改的数据 update ：\n{}", JSON.toJSONString(update));

        saveAll.forEach(item -> item.setName("saveAll-test-update"));
        List<BizBatisNews> updateList = myBatisDemoService.update(saveAll, Sets.newHashSet("name"));
        log.info("修改的数据 updateList ：\n{}", JSON.toJSONString(updateList));

        BizBatisNews getOne = myBatisDemoService.getById(save.getId());
        log.info("查询的数据 getOne ：\n{}", JSON.toJSONString(getOne));

        myBatisDemoService.deleteById(save.getId());
        log.info("删除的数据 deleteById ：\n{}", JSON.toJSONString(save));

        BizBatisNews getByName = myBatisDemoService.getByName("123");
        log.info("查询的数据 getByName ：\n{}", JSON.toJSONString(getByName));

        List<BizBatisNews> findAll = myBatisDemoService.find(null);
        log.info("查询的数据 findAll ：\n{}", JSON.toJSONString(findAll));


        List<Long> ids = findAll.stream().map(BizBatisNews::getId).collect(Collectors.toList());
        log.info("将要执行方法 deleteById 需要删除的id有 ：\n{}", JSON.toJSONString(ids));
        myBatisDemoService.deleteByIds(ids);
        log.info("查询的数据 deleteById ：\n{}", JSON.toJSONString(save));

    }
}
