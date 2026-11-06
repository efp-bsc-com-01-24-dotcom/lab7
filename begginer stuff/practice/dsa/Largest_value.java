public class Largest_value{
    static int largets(int[] a){
        int current = 0;
        for(int i = 0;i<a.length;i++){
            if (a[current] < a[i]) {
                current = a[i];
            }   
        }
        return current;
    }
    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 6, 7, 8, 4, 3, 2, 1, 20 };
        int result = largets(arr);
        
        System.out.println(result);
    }    
}