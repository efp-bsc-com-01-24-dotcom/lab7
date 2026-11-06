
import java.util.Scanner;

public class arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\t-------welome--------\n");
        System.out.print("enter the number of rows: ");

        int row = sc.nextInt();
        System.out.println("\n enter the number of columns");
        int col = sc.nextInt();

        int arr[][] = new int[row][col];
        System.out.println("\n enter the vlaues now");

        for (int i = 0; i < row; i++) {
            System.out.print("row "+(i+1)+" :");
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
