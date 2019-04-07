public class CheckService {

    static int i = -1;
    static double sum = 0.0;

    public static double list2(CheckPosition checkPosition[]) {
        i++;
        sum = sum + checkPosition[i].getPrice() * checkPosition[i].getCount();
        while (i < checkPosition.length -1 ) {
            CheckService.list2(checkPosition);
        }
        return sum;
    }
}
