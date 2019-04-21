public class Main {

    public static void main(String[] args) {
        Shape shape;
        shape = null;
        try {
            if ((args[0].equals("-c"))) {
                try {
                    if (args.length == 2) {
                        shape = new Circle(Double.parseDouble(args[1]));
                    } else {
                        System.out.println("после -с должнен быть один аргумент");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("после -с должен быть числовой аргумент ");
                } catch (IllegalArgumentException e) {
                    System.out.println("аргумент должен быть положительным");
                }
            } else if ((args[0].equals("-r"))) {
                try {
                    if (args.length == 3 && Double.parseDouble(args[1]) > 0 && Double.parseDouble(args[2]) > 0) {
                        shape = new Rectangle(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                    } else {
                        System.out.println("после -r должно быть два положительных аргумента");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("после -r должны быть числовые аргументы");
                } catch (IllegalArgumentException e) {
                    System.out.println("аргументы должны быть все положительные");
                }
            } else if ((args[0].equals("-h")) && args.length == 1) {
                System.out.println("Program output square and perimeter of circle or rectangle.");
                System.out.println("-с r	r - circle radius");
                System.out.println("-r a b  a, b - rectangle sides");
            } else {
                System.out.println("Неправильный аргумент.");
                System.out.println("Use -h to get help.");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("необходимо ввести хоть какие-нибудь значения");
        }

        if (shape != null) {
            System.out.println("square " + shape.square());
            System.out.println("perimeter " + shape.perimeter());
        }
    }
}
