package com.mianshi.multithread.service.impl;

import com.mianshi.multithread.service.ResultServiceV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultServiceImpleV1Test {
    @Autowired
    private ResultServiceV1 resultServiceV1;

    @Test
    void merge() {
        List<String> ips = new ArrayList<>();

        ips.add("0.0.0.0");
        ips.add("1.1.1.1");
        ips.add("2.2.2.2");
        ips.add("3.3.3.3");
        ips.add("4.4.4.4");


        resultServiceV1.merge(ips);
    }

    @Test
    void batchedInsert() {
    }
}