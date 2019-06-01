package com.ct.system.bean;

import com.alibaba.fastjson.JSON;
import com.ct.system.util.Utils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by chentong1 on 2019/6/1.
 */
@Entity
@Table(name = "tester")
public class Tester {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "assigned")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32, nullable = false)
    public String id;
    @Column(name = "visitor_time", nullable = false)
    public long visitorTime;

    public static Tester createOne() {
        Tester tester = new Tester();
        tester.id = Utils.generateUid();
        tester.visitorTime = System.currentTimeMillis();
        return tester;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
