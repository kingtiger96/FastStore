package com.mianshi.multithread.util;

import com.mianshi.multithread.entity.AssetEntity;
import com.mianshi.multithread.entity.IMCEntity;
import com.mianshi.multithread.entity.ResultEntity;

import java.util.ArrayList;
import java.util.List;

public class MergeUtil {
    public static List<ResultEntity> check(AssetEntity assetEntity, List<IMCEntity> list){
        List<ResultEntity> resultList = new ArrayList<>();
        for(IMCEntity imc:list){
            ResultEntity result = new ResultEntity();
            result.setIp(assetEntity.getIp());
            result.setUsername(assetEntity.getUsername());
            result.setAccessTime(imc.getAccessTime());
            resultList.add(result);
        }
        return resultList;
    }
}
