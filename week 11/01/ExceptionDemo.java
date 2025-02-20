
public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            if (a == 0) {
                System.out.println("Error: 'a' cannot be zero in a quadratic equation.");
                return;
            }

            double discriminant = Math.pow(b, 2) - (4 * a * c);

            if (discriminant < 0) {
                System.out.println("Error: No real roots. The discriminant is negative.");
                return;
            }

            double x1 = ((-b) + Math.sqrt(discriminant)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please input data in number format only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Mathematical error occurred (possible division by zero).");
        } catch (Exception e) {
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
        }
    }
}
