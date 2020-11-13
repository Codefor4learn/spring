import com.hz.spring_aop.MyInvocationHandler;
import com.hz.spring_aop.domain.SysUser;
import com.hz.spring_aop.service.Impl.SomeServiceImpl;
import com.hz.spring_aop.service.SomeService;
import com.hz.spring_aop.TestProxyService;
import com.hz.spring_aop.service.UserService;
import com.hz.spring_aop.util.ServiceTools;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class TestSpingAop {

    @Test //测试 AfterThrowing 异常通知
    public void test10(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        someService.testAfterThrowing();

    }

    @Test // 测试 Around 环绕通知
    public void test09(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        Object res = someService.testAround();
        System.out.println(res);

    }

    @Test // 测试后置通知改变返回结果
    public void test08(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        SysUser user = someService.testSys();
        System.out.println(user);

    }

    @Test // 测试 AfterReturning 后置通知
    public void test07(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        someService.doOthers();

    }

    @Test //测试 Before 前置通知
    public void test06(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        someService.doSome("黄震",20);

    }

    @Test // 测试生成类 没有接口的目标类采用cjlib方式创建
    public void test05(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");
        someService.doSome("黄震",20);
        System.out.println(someService.getClass().getName());

        System.out.println("\n=================================================================\n");

        // 目标类没有接口  采用cjlib动态代理方式
        TestProxyService testProxyService = (TestProxyService) applicationContext.getBean("testProxy");
        testProxyService.doSome();
        System.out.println(testProxyService.getClass().getName());
    }

    @Test  // 动态代理 底层原理
    public void test03(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        // 创建目标类
        SomeService target = new SomeServiceImpl();

        // 创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        // 使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),handler);

        proxy.doOthers();
    }

    @Test  // 原始方法 增加日志 提交事务
    public void test02(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SomeService someService = (SomeService) applicationContext.getBean("someService");

        ServiceTools.doLog();
        someService.doSome("黄震",20);
        System.out.println("==========");
        someService.doOthers();
        ServiceTools.doTrans();
    }

    @Test
    public void test01(){

        String config = "spring_aop/application-aop.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        SysUser user = new SysUser();
        user.setName("黄震");
        user.setAge(21);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.insertUser(user);
    }
}
