package interview;

import org.junit.Test;
import sun.security.util.Length;

import java.util.*;

/**
 * @author andrew
 * @create 2021-11-30 10:17
 */
public class SolutionTest {

    @Test
    public void test() {

        System.out.println(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2021, 11, 1);

        System.out.println(calendar.getTimeInMillis());

        Date date = new Date(1638288000000L);
        System.out.println(date.toString());


    }

}
