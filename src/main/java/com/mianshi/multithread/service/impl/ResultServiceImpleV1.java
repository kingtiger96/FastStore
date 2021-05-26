package com.mianshi.multithread.service.impl;

import com.mianshi.multithread.entity.AssetEntity;
import com.mianshi.multithread.entity.IMCEntity;
import com.mianshi.multithread.entity.ResultEntity;
import com.mianshi.multithread.mapper.ResultMapper;
import com.mianshi.multithread.service.ResultServiceV1;
import com.mianshi.multithread.util.MergeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Callable;

import java.util.concurrent.FutureTask;

@Service
public class ResultServiceImpleV1 implements ResultServiceV1 {
    private static final Logger logger = LoggerFactory.getLogger(ResultServiceV1.class);
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private ResultServiceV1 resultServiceV1;
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void merge(List<String> ips) {
        for(String ip : ips){
            try{
                Callable<AssetEntity> c1 = assetCallable(ip);
                //执行任务并获取Future对象
                FutureTask<AssetEntity> ft1 = new FutureTask<>(c1);
                Thread t1 = new Thread(ft1);
                t1.start();

                AssetEntity asset = ft1.get();

                Callable<List<IMCEntity>> c2 = imcCallable(ip);
                //执行任务并获取Future对象
                FutureTask<List<IMCEntity>> ft2 = new FutureTask<>(c2);
                Thread t2 = new Thread(ft2);
                t2.start();

                List<IMCEntity> imcs = ft2.get();
//                AssetEntity asset = assetCallable(ip);
//                AssetEntity asset = resultMapper.selectAccessList(ip);
//                List<IMCEntity> imcs = resultMapper.selectIMCList(ip);

                t1.join();
                t2.join();
                List<ResultEntity> resultEntityList = MergeUtil.check(asset, imcs);

                resultServiceV1.batchedInsert(resultEntityList);
            }catch (Exception e){
                logger.error("当前ip为{},插入数据库失败",ip);
            }
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void batchedInsert(List<ResultEntity> results) {
        for (ResultEntity r: results) {
            resultMapper.mergeResult(r);
        }
    }

    private Callable<AssetEntity> assetCallable(String ip){

        return new Callable<AssetEntity>(){
            @Override
            public AssetEntity call() throws Exception {
                return resultMapper.selectAccessList(ip);
            }
        };
    }


    private Callable<List<IMCEntity>> imcCallable(String ip){

        return new Callable<List<IMCEntity>>(){
            @Override
            public List<IMCEntity> call() throws Exception {
                return resultMapper.selectIMCList(ip);
            }
        };
    }

}

