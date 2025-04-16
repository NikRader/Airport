package QueryHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchesScanner {
    public static  List<String> SearchesScanner(){
        List<String> input = new ArrayList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите запросы:");
        while(true){
            String current = scan.nextLine();
            if(current.equals(""))break;
            input.add(current);
        }
        return input;
    }


}
