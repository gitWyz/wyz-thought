package fibonacci;

/**
 * 斐波那契
 * @author wangyz
 * @version 1.0
 * @date 2021/4/4
 */
public class Fibonacci {

    /**
     * javadoc fib1
     * @apiNote 使用递归方式求第n项的斐波那契数
     * 时间复杂度O(2^n)
     * 当n的数非常大时会导致StackOverflowError
     *
     * @param n
     * @return int
     * @author wangyz
     * @date 2021-04-04 08:52:54
     */
    public static int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * javadoc fib2
     * @apiNote for循环实现
     * 时间复杂度O(n)
     * 返回值足够大时会取值溢出，解决方法：返回值改为BigInteger
     *
     * @param n
     * @return int
     * @author wangyz
     * @date 2021-04-04 09:27:50
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        // 0, 1, 2, 3, 4, 5
        // 0, 1, 1, 2, 3, 5
        int first = 0, second = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
            //System.out.println("第" + i + "位置 =" + sum);
        }
        return sum;
    }

    public static int fib3(int n) {
        if (n <= 1) { return n; }
        int first = 0, secont = 1;
        while (n-- > 1) {
            secont += first;
            first = secont - first;
            //System.out.println("第" + n + "位置 =" + secont);
        }
        return secont;
    }


    /**
     * javadoc fib4
     * @apiNote 斐波那契的线性代数解法 - 特征方程
     * 特征方程如下：
     *
     * f(n) = 1/√5 * [((1+√5)/2)^n - ((1-√5)/2)^n]
     * 时间复杂度O(1)
     *       
     * @param n
     * @return int        
     * @author wangyz
     * @date 2021-04-04 10:03:03
     */
    public static int fib4(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c)/2, n) - Math.pow((1 - c)/2, n))/c);
    }

    public static void main(String[] args) {
        System.out.println(fib4(5));
    }
}
