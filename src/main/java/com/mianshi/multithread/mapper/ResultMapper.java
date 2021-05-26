package com.mianshi.multithread.mapper;

import com.mianshi.multithread.entity.AssetEntity;
import com.mianshi.multithread.entity.IMCEntity;
import com.mianshi.multithread.entity.ResultEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ResultMapper {
    AssetEntity selectAccessList(String ip);
    List<IMCEntity> selectIMCList(String ip);
    int mergeResult(ResultEntity r);
}
