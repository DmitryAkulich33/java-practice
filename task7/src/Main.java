public class Main {

    public static void main(String[] args) {
        try {
            if ((args[0].equals("-c")) && args.length == 2) {
                Circle circle = new Circle(Double.parseDouble(args[1]));
                System.out.println("square " + circle.square());
                System.out.println("perimeter " + circle.perimeter());
            } else if ((args[0].equals("-r")) && args.length == 3) {
                Rectangle rectangle = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                System.out.println("square " + rectangle.square());
                System.out.println("perimeter " + rectangle.perimeter());
            } else if ((args[0].equals("-h")) && args.length == 1) {
                System.out.println("Program output square and perimeter of circle or rectangle.");
                System.out.println("-с r	r - circle radius");
                System.out.println("-r a b  a, b - rectangle sides");
            } else if ((args[0].equals("-x")) && args.length == 1) {
                System.out.println("Use -h to get help.");
            } else {
                System.out.println("Illegal radius. Should be positive number.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument!!!");
        }
    }
}
