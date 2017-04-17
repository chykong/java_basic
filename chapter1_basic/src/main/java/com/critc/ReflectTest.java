package com.critc;

import com.critc.vo.User1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by 孔垂云 on 2017/4/17.
 * 通过一个对象获得完整的包名和类名
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        //通过一个对象获得完整的包名和类名
        ReflectTest testReflect = new ReflectTest();
        System.out.println(testReflect.getClass().getName());
        // 结果 com.critc.ReflectTest


        //实例化Class类对象
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;
        // 一般采用这种形式
        class1 = Class.forName("com.critc.ReflectTest");
        class2 = new ReflectTest().getClass();
        class3 = ReflectTest.class;
        System.out.println("类名称   " + class1.getName());
        System.out.println("类名称   " + class2.getName());
        System.out.println("类名称   " + class3.getName());


        //获取某个类的全部属性
        Class<?> clazz = Class.forName("com.critc.vo.User1");
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        //获取某个类的全部方法
        Class<?> clazz2 = Class.forName("com.critc.vo.User1");
        Method method[] = clazz2.getMethods();
        System.out.println("==========所有方法如下：=========");
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        System.out.println("==========调用类的方法===========");
        //调用类的方法
        Class<?> clazz3 = Class.forName("com.critc.vo.User1");
        Method method3 = clazz3.getMethod("setId", int.class);
        //method3.invoke(clazz.newInstance());//先调用new方法
        method3.invoke(clazz3.newInstance(), 20);//调用set方法

        User1 user1 = new User1("测试", 10, "123");
        Class clazz4 = user1.getClass();
        Method method4 = clazz4.getDeclaredMethod("getName");
        String name = (String) method4.invoke(user1);//调用get方法
        System.out.println(name);
    }
}
