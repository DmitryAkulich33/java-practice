public class CheckService {


    public static double list2(CheckPosition checkPosition[]) {
        return list(checkPosition, checkPosition.length - 1);
    }

    public static double list(CheckPosition[] checkPosition, int n){
        double sum = checkPosition[n].getCount() * checkPosition[n].getPrice();
        if(n == 0){
            return sum;
        }
        return sum + list(checkPosition, n -1);
    }
}
