import com.superb.StartApplication;
import com.superb.model.UserEntity;
import com.superb.model.UserInfoEntity;
import com.superb.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    public void listUserTest() {
        List<UserEntity> userInfoEntities = userService.listUser();

        System.out.println(userInfoEntities.toString());
    }


    @Test
    public void listUserBySexTest() {
        List<UserEntity> userInfoEntities = userService.selectUserBySex(1);

        System.out.println(userInfoEntities.toString());
    }
}
