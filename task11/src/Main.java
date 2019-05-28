import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String englishAlphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> list1 = new ArrayList<>();
        for(int i = 0; i < englishAlphabet.toCharArray().length; i++){
            list1.add(englishAlphabet.charAt(i));
        }

        System.out.println("Введите строку");
        String name = reader.readLine();
        ArrayList<Character> list2 = new ArrayList<>();
        for(int i = 0; i < name.toCharArray().length; i++){
            list2.add(name.toLowerCase().charAt(i));
        }

        for(int i = 0; i < list1.size(); i++){
            int count = 0;
            for(int j = 0; j < list2.size(); j++){
                if(list1.get(i).equals(list2.get(j))){
                    count++;

                }
            }
            System.out.println(list1.get(i) + " " + count);
        }
        reader.close();
    }
}
