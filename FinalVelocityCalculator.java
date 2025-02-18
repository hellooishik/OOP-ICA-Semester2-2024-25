public class FinalVelocityCalculator {
    public static void main(String[] args) {
        // Validate command line arguments
        if (args.length != 3) {
            System.out.println("Error: Please provide exactly three positive integers: initial velocity (u), acceleration (a), and displacement (s).");
            return;
        }

        try {
            int u = Integer.parseInt(args[0]);
            int a = Integer.parseInt(args[1]);
            int s = Integer.parseInt(args[2]);

            // Check for non-zero positive values
            if (u <= 0 || a <= 0 || s <= 0) {
                System.out.println("Error: All values must be positive non-zero integers.");
                return;
            }

            // Calculate final velocity using the formula v^2 = u^2 + 2as
            double v = Math.sqrt(u * u + 2 * a * s);

            // Print the result
            System.out.printf("Final Velocity: %.2f m/s%n", v);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers.");
        }
    }
}
