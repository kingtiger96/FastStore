package com.mianshi.multithread.service;

import com.mianshi.multithread.entity.ResultEntity;

import java.util.List;

public interface ResultServiceV1 {
    void merge(List<String> ips);
    void batchedInsert(List<ResultEntity> results);
}
