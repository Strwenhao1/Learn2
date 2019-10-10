package com.bjsxt.why;

/**
 * 并不是每种语言都具有反射的功能；反射让Java功能更加的强大
 *
 * 只要遇到了properties文件、遇到.xml文件，如果其中包括类的完整路径，都离不开反射
 *
 * 比如：log4j
 *   log4j.appender.stdout=org.apache.log4j.ConsoleAppender
 *   log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
 *
 * 比如：Servlet
 *  <servlet>
         <servlet-name>HelloServlet</servlet-name>
         <servlet-class>servlet.HelloServlet</servlet-class>
     </servlet>
 *
 * 比如 SSM
 *  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     <property name="dataSource" ref="dataSource"/>
    </bean>

 ————————————————
 版权声明：本文为CSDN博主「weixin_41612354」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/weixin_41612354/article/details/81736678
 *
 */
public class Test {
    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //编码/编译的时候，已经知道要创建哪个类的对象，此时和反射没有关系
        //创建对象
        //Animal an = new Dog();
        Animal an = new Cat();
        //操作属性
        an.nickName ="旺财";
        an.color = "黑色";

        //执行方法
        an.shout();
        an.shout("门口");
        an.run();
        System.out.println(an);


        //编码/编译的时候，不知道要创建哪个类的对象，只有根据运行时动态获取的内容来创建对象
        //使用Properties类读取属性文件，最终得到了类的完整路径字符串
        String className = "com.bjsxt.why.Cat";


        //创建对象
        //Animal an2 = new "com.bjsxt.why.Cat"();
        Class clazz = Class.forName(className);
        Object an2 = clazz.newInstance();
        //操作属性

        //执行方法

    }
}
