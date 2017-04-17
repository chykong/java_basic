package com.critc.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 孔垂云 on 2017/4/17.
 * HashMap主要用法
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Double> scores = new HashMap<>();
        scores.put("语文", 89.0);
        scores.put("数学", 83.0);
        scores.put("英文", 84.0);
        System.out.println(scores.values());
        Set<Map.Entry<String, Double>> entrySet = scores.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println("取得key：" + entry.getKey());
            System.out.println("对应的value为：" + entry.getValue());
        }
        System.out.println("是否包含key："+ scores.containsKey("语文"));
        System.out.println("是否包含value："+ scores.containsValue(83.0));
    }
}
