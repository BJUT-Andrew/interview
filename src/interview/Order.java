package interview;

/**
 * @author andrew
 * @create 2021-12-11 20:29
 */
public class Order {

    private static volatile Order instance;

    private Order() {
    }

    public static Order getInstacnce() {

        //双检之一；
        if (instance == null) {

            //锁；
            synchronized (Order.class) {

                //双检之二；
                if (instance == null) {
                    instance = new Order();
                }
            }
        }

        return instance;
    }
}
