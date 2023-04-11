package com.lingjie.oasystem.controller;


import com.alibaba.fastjson.JSON;
import com.lingjie.oasystem.common.BaseController;
import com.lingjie.oasystem.dao.entity.LingJieAnZhuang;
import com.lingjie.oasystem.dao.mapper.LingJieAnZhuangMapper;
import com.lingjie.oasystem.util.DateUtil;
import com.lingjie.oasystem.vo.LingJieAnZhuangVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping(value = "/all")
public class LingjieAnZhuangController extends BaseController {


    @Autowired
    private LingJieAnZhuangMapper lingJieAnZhuangMapper;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;


    @RequestMapping(value = "/lingjieanzhuangAll", method = RequestMethod.POST)
    @ResponseBody
    public LingJieAnZhuangVO createOrder(@RequestBody LingJieAnZhuang orderCreateIn) {

        LingJieAnZhuang lingJieAnZhuang = lingJieAnZhuangMapper.selectById(5);

        LingJieAnZhuangVO lingJieAnZhuangVO = this.copyBean(lingJieAnZhuang, LingJieAnZhuangVO.class);

        lingJieAnZhuangVO.setCreateTime(DateUtil.format(lingJieAnZhuang.getCreateTime(),DateUtil.FORMAT_YYYYMMDDHHMISS));
        lingJieAnZhuangVO.setUpdateTime(DateUtil.format(lingJieAnZhuang.getUpdateTime(),DateUtil.FORMAT_YYYYMMDDHHMISS));

        logger.info("输出信息：{}",JSON.toJSONString(lingJieAnZhuangVO));

        redisTemplate.opsForValue().set("xiaoyu222","6666666");

        String xiaoyu222 = (String)redisTemplate.opsForValue().get("xiaoyu222");

        Hashtable hashtable = new Hashtable();
        hashtable.put("aaaa","bbbb");

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("aaaa","bbbbb");

        Stack<String> strings = new Stack<>();

        strings.add("ssss");
        strings.add("bbbb");



        ConcurrentHashMap cc = new ConcurrentHashMap();
        cc.put("ssss","bbbb");

        logger.info("xiaoyu222,{}",xiaoyu222);

        return lingJieAnZhuangVO;



    }




}
