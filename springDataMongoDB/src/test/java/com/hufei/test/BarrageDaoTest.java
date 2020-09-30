package com.hufei.test;

import com.hufei.dao.BarrageDao;
import com.hufei.entity.Barrage;
import com.hufei.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.ConstructorProperties;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * @Author:hufei
 * @CreateTime:2020-09-29
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-MongoDB.xml"})
public class BarrageDaoTest {

    @Autowired
    private BarrageDao barrageDao;

    @Test
    public void testSave() {//保存一条数据
        Barrage barrage = new Barrage();
        barrage.setId(1);
        barrage.setContent("测试一下");
        barrage.setTime(DateUtils.getCurrentTime());
        barrageDao.save(barrage);
    }

    @Test
    public void testUpdate() {//更新
        Barrage barrage = new Barrage();
        barrage.setId(7);
        barrage.setContent("测试一下007");
        barrage.setTime(DateUtils.getCurrentTime());
        barrageDao.save(barrage);
    }

    @Test
    public void testDeleete() {//删除
        barrageDao.deleteById(1);
    }

    @Test
    public void testMakeData() {
        Barrage barrage = null;
        for (int i = 1; i <= 10; i++) {
            barrage = new Barrage();
            barrage.setId(i);
            barrage.setContent("测试一下00"+i);
            barrage.setTime(DateUtils.getCurrentTime());
            barrageDao.save(barrage);
        }
    }

    @Test
    public void testfindAll() {//查询所有
        List<Barrage> list = barrageDao.findAll();
        for (Barrage barrage : list) {
            System.out.println(barrage);
        }
    }

    @Test
    public void testfindById() {//根据id查询
        Optional<Barrage> byId = barrageDao.findById(5);
        System.out.println(byId.get());
    }

    @Test
    public void testfindByCondition() {
        Sort sort = Sort.by(Sort.Order.desc("time"));//设置排序条件
        PageRequest page = PageRequest.of(1, 5, sort);//分页
        Page<Barrage> all = barrageDao.findAll(page);
        for (Barrage barrage : all) {
            System.out.println(barrage);
        }
    }

    @Test
    public void testfindByContextLike() {
        List<Barrage> list = barrageDao.findByContentLike("001");
        for (Barrage barrage : list) {
            System.out.println(barrage);
        }
    }

    @Test
    public void testfindByTimeGreaterThan() {
        List<Barrage> list = barrageDao.findByTimeGreaterThan("2020-09-29 05:21:22");
        for (Barrage barrage : list) {
            System.out.println(barrage);
        }
    }

}
