import com.hz.spring_ioc.service.DAO.Student;
import com.hz.spring_ioc.service.Impl.SomeServiceImpl;
import com.hz.spring_ioc.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestSpringIoc {


    @Test
    public void test09(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test08() throws IOException {

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        File file = (File) applicationContext.getBean("file");
        //File file1 = new File("C:\\soft\\IntelliJ IDEA 2018.2.4\\redist\\.readme.txt");


        System.out.println(file.getAbsoluteFile());
    }

    @Test
    public void test07(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("student3");
        System.out.println(student);
    }

    @Test
    public void test06(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test05(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test01(){

        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    @Test
    public void test02(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        SomeService someService = (SomeService) applicationContext.getBean("someService");

        someService.doSome();
    }

    @Test
    public void test03(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans){
            System.out.println("名字："+bean);
        }
    }

    @Test
    public void test04(){

        String config = "spring/application.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        Date date = (Date) applicationContext.getBean("date");
        System.out.println(date);

    }
}
