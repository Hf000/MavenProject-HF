package com.hufei.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @Author:hufei
 * @CreateTime:2020-09-29
 * @Description:
 */
@Document("Barrage")//使用此注解建立该实体类和mongoDB数据中collection的映射关系
@Data
public class Barrage {
    @Id//用来标识主键
    private int id;
//    @Field//此注解来建立实体中属性和collection中document的字段关系，如果省略标识名称保持一致
    private String content;
    private String time;
}
