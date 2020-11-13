import com.hz.spring_mybatis.dao.StudentDao;
import com.hz.spring_mybatis.domain.Student;
import com.hz.spring_mybatis.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpringMybatis {


    @Test//使用service
    public void test03(){

        String config = "spring_mybatis/spring-mybatis.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        //Student student = new Student("黄震22","153111qq.com",121);
        //studentService.addStudent(student);
        List<Student> studentList = studentService.queryStudent();
        for (Student s : studentList){
            System.out.println(s);
        }

    }

    @Test//使用dao
    public void test02(){

        String config = "spring_mybatis/spring-mybatis.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");

        Student student = new Student("黄震","153qq.com",21);
        int nums = studentDao.insertStudent(student);

        System.out.println(nums);
    }

    @Test
    public void test01(){

        String config = "spring_mybatis/spring-mybatis.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);


        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names){
            System.out.println("容器对象名称：" + name+"|"+applicationContext.getBean(name));
        }

    }
}
