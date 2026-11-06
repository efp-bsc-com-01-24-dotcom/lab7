public class binaryCode {
    public static void main(String tx[]) {
        long t0 = System.currentTimeMillis();
        String word = "";
        
        for (int j = 0; j < 5; j++) {
            //v clong ;
            for (int i = 1; i <= 1000000; i++) {
                word = (Math.random() < 0.5) ? word + "0" : word + "1";
            }
    }
        long timeElapsed = System.currentTimeMillis()-t0;
        System.out.printf("%s\n %d\t",word,timeElapsed);
    }
}
