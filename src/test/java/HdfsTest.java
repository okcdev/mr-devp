import com.rbs.cn.utils.HdfsUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2018/1/15.
 */
public class HdfsTest {

    @Test
    public static void hdfsTest() throws IOException {
        List<String> fileList = HdfsUtil.ls("/");
        for(String file : fileList){
            System.out.println(file);
        }
    }
}
