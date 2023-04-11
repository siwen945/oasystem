package com.lingjie.oasystem.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BaseController {

    /**
     * 日志输出对象
     */
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 请求头中的多语言标识
     */
    protected static final String HEADER_LANG = "x-unex-locale";


    /**
     * JavaBean对象复制(隐含基本数据类型转换，所以用JSON转换)
     *
     * @param source JavaBean对象
     * @param targetClazz 目标JavaBean类型
     * @return 目标JavaBean对象
     */
    protected <T> T copyBean(Object source, Class<T> targetClazz) {
        return JSON.parseObject(JSON.toJSONString(source), targetClazz);
    }

    /**
     * JavaBean对象复制(隐含基本数据类型转换，所以用JSON转换)
     *
     * @param source JavaBean对象
     * @param targetClazz 目标JavaBean类型
     * @return 目标JavaBean对象
     */
    protected <T> List<T> copyList(Object source, Class<T> targetClazz) {
        return JSON.parseArray(JSON.toJSONString(source), targetClazz);
    }


    /**
     * @Description: 把当前的JSON对象转换成指定的JavaBean对象
     * @Author: xiaoyu.li
     * @Date: 2020/9/15 17:15
     * @param obj: JSON对象(RestTemplate#postForObject的返回对象类型)
     * @param clazz: 期望的JavaBean对象类型
     * @return: JavaBean对象 T
     **/
    protected <T> T castBean(Object obj, Class<T> clazz) {

        if (null == obj) {
            return null;
        }
        try {
            if (obj.getClass() == LinkedHashMap.class && clazz == JSONObject.class) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.putAll((Map<String, Object>) obj);
                return (T) jsonObject;
            }
            return TypeUtils.cast(obj, clazz, ParserConfig.getGlobalInstance());
        } catch (Exception e) {
            logger.error("castBean failed.", e);
            throw new NullPointerException();
        }
    }

    /**
     * @Description: 把当前的JSON对象转换成指定的JavaBean对象List
     * @Author: xiaoyu.li
     * @Date: 2020/9/15 17:16
     * @param obj: JSON对象(RestTemplate#postForObject的返回对象类型)
     * @param clazz: 期望的JavaBean对象类型
     * @return: JavaBean对象List java.utils.List<T>
     **/
    protected <T> List<T> castList(Object obj, Class<T> clazz) {

        if (null == obj) {
            return new ArrayList<>();
        }
        // 尝试直接转List对象
        if (obj instanceof Iterable) {
            List<T> resultList = new ArrayList<>();

            for (Iterator<Object> it = ((Iterable<Object>) obj).iterator(); it.hasNext(); ) {
                Object item = it.next();
                resultList.add(this.castBean(item, clazz));
            }

            return resultList;
        }
        throw new NullPointerException();
    }
}
