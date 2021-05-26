package com.mianshi.multithread.controller;

import com.mianshi.multithread.service.ResultServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResultController {
    @Autowired
    private ResultServiceV1 resultServiceV1;
    @RequestMapping(path = "/merge", method = RequestMethod.POST)
    @ResponseBody
    public void insert(){
        //resultServiceV1.merge();
    }
}
