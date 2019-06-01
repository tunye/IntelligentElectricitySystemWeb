package com.ct.system.dao;

import com.ct.system.bean.Tester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chentong1 on 2019/6/1.
 */
@Repository
public interface TesterRepository extends JpaRepository<Tester, String> {

    List<Tester> findAll();

    Tester findById(String id);
}
