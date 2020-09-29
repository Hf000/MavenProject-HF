package com.hufei.dao;

import com.hufei.entity.Barrage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Author:hufei
 * @CreateTime:2020-09-29
 * @Description:mongoDB数据库dao
 */
public interface BarrageDao extends MongoRepository<Barrage, Integer> {//基础mongoDB的父接口

    /**根据内容模糊查询**/
    List<Barrage> findByContentLike(String context);

    /**根据时间查询，大于什么时间的数据**/
    List<Barrage> findByTimeGreaterThan(String time);

}
