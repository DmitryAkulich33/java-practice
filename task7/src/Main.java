public class Main {

    public static void main(String[] args) {
        Shape shape;
        shape = null;
        try {
            if ((args[0].equals("-c")) && args.length == 2) {
                shape = new Circle(Double.parseDouble(args[1]));
            } else if ((args[0].equals("-r")) && args.length == 3) {
                shape = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
            } else if ((args[0].equals("-h")) && args.length == 1) {
                System.out.println("Program output square and perimeter of circle or rectangle.");
                System.out.println("-с r	r - circle radius");
                System.out.println("-r a b  a, b - rectangle sides");
            } else {
                System.out.println("Illegal Argument.");
                System.out.println("Use -h to get help.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument. Try again!!!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter something");
        }
        if(shape != null){
            System.out.println("square " + shape.square());
            System.out.println("perimeter " + shape.perimeter());
        }
    }
}
