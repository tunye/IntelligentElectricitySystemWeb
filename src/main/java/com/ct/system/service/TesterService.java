package com.ct.system.service;

import com.ct.system.bean.Tester;
import com.ct.system.dao.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesterService {
    @Autowired
    private TesterRepository testerRepository;

    public Tester create() {
        Tester teacher = Tester.createOne();
        return testerRepository.save(teacher);
    }

    public Tester getById(String id) {
        return testerRepository.findById(id);
    }
}
