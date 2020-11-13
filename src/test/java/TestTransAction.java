import com.hz.spring_transaction.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransAction {

    @Test
    public void test01(){

        String config = "spring_transaction/spring-mybatis.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        BuyGoodsService buyGoodsService = (BuyGoodsService) ctx.getBean("buyGoodsService");

        buyGoodsService.buy(1002,10);

    }
}
