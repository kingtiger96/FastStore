package com.mianshi.multithread.mapper;

import com.mianshi.multithread.entity.AssetEntity;
import com.mianshi.multithread.entity.ResultEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultMapperTest {
    @Autowired
    private ResultMapper resultMapper;
    
    @Test
    void selectAccessList() {
        AssetEntity assetEntities = resultMapper.selectAccessList("1.1.1.1");
        System.out.println(assetEntities);
    }

    @Test
    void selectIMCList() {
        System.out.println(resultMapper.selectIMCList("1.1.1.1"));
    }

    @Test
    void mergeResult() {
        ResultEntity r = new ResultEntity();
        r.setIp("100.100.0.0");
        r.setUsername("test1");
        r.setAccessTime(new Date());
        resultMapper.mergeResult(r);
    }
}