package com.critc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 孔垂云 on 2017/5/14.
 */
public class JunitTest {

    @Test
    public void test()
    {
        int a=1,b=2;
        int c=a+b;
        Assert.assertEquals(c,3);
        Assert.assertEquals(c,4);
    }
}
