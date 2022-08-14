package recursion_i;

public class FibonacciNumber_1 {
    public static int fibonacci(int n) {
        if(n<2) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
