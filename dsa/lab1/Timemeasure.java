public class Timemeasure{
    public static long fib(int n) {
        
        if (n == 0){ 
            return n;
        }
        if(n == 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        for (int i = 2; i <= n; i++) {
            long result = a + b;
            a = b;
            b = result;
        }
        return b;
    }
    public static void main(String[] args){
        long t0 = System.currentTimeMillis();
        long res = fib(45);
        long timeElapsed = (System.currentTimeMillis() - t0);
        
        System.out.printf("fib(45) = %d\n\n Time = %d\n", res, timeElapsed);
        
    }   
}