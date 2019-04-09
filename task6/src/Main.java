public class Main {

    public static void main(String[] args) {
        CheckPosition[] checkPosition = new CheckPosition[3];
        double checksum;

        CheckPosition check1 = new CheckPosition();
        CheckPosition check2 = new CheckPosition();
        CheckPosition check3 = new CheckPosition();

        checkPosition[0] = check1;
        checkPosition[1] = check2;
        checkPosition[2] = check3;

        check1.setName("milk");
        check2.setName("cheese");
        check3.setName("bread");

        check1.setCount(1);
        check2.setCount(2);
        check3.setCount(1);

        check1.setPrice(2.0);
        check2.setPrice(3.5);
        check3.setPrice(1.1);

        checksum = CheckService.list2(checkPosition);

        System.out.println("Сумма чека равна " + checksum + " рублей");
    }

}
