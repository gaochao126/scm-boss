import com.superb.StartApplication;
import com.superb.anno.IAnno;
import com.superb.anno.StrategyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class StrategyTest {

    @Autowired
    private StrategyFactory strategyFactory;

    @Test
    public void getStrategyTest() {
        String s = "A";

        IAnno strategy = strategyFactory.getStrategy(s);

        strategy.exe();
    }
}
