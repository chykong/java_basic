package com.critc;

import com.critc.vo.User1;
import com.critc.vo.User2;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by 孔垂云 on 2017/4/8.
 */
public class BeanUtilsTest {
    public static void main(String[] args) throws Exception {
        User1 user1 = new User1("test", 1, "123456");//先初始化一个类
        User2 user2 = new User2();
        BeanUtils.copyProperties(user2, user1);//代码复制
        System.out.println(user2.toString());
    }
}
