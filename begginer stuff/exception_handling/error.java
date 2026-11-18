
import java.util.*;

public class error {

    public static int quotient(int nume, int denume) throws ArithmeticException {
        return nume / denume;
    }

    public static void main(String[] args) {
        boolean contininue = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("enter a numerator: ");
                int numerator = sc.nextInt();

                System.out.print("\nenter denominater: ");
                int denominator = sc.nextInt();

                double result = quotient(numerator, denominator);

                System.out.println(result);
                contininue = false;
            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("\nException: %s\n",
                        inputMismatchException);
                sc.nextLine(); // discard input so user can try again
                System.out.println(
                        "You must enter integers. Please try again.\n");
            } catch (ArithmeticException arithmeticException) {
                System.err.printf("\nException: %s\n", arithmeticException);
                System.out.println(
                        "Zero is an invalid denominator. Please try again.\n");
            }

        } while (contininue);
    }
}
