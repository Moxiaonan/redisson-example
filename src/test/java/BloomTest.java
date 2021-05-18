import com.xy.redisson.example.App;
import com.xy.redisson.example.biz.BloomBiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/5/18
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class BloomTest {
    private String key = "test";
    private long expectedInsertions = 1000L;
    private double falseProbability = 0.01;

    @Autowired
    BloomBiz bloomBiz;

    @Test
    public void test(){
        boolean init = bloomBiz.init(key, expectedInsertions, falseProbability, true);
        System.out.println("init ----> " + init);
        boolean contain1 = bloomBiz.contain(key, "江苏省徐州市鼓楼区");
        System.out.println("contain ---->" + contain1);
        boolean contain2 = bloomBiz.contain(key, "新乡");
        System.out.println("contain ---->" + contain2);
        boolean add = bloomBiz.add(key, "新乡");
        System.out.println("add ----->" + add);
        boolean contain3 = bloomBiz.contain(key, "新乡");
        System.out.println("contain ---->" + contain3);
    }
}
