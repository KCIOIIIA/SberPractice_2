package Task_4;

import java.util.ArrayList;
import java.util.Scanner;

public class Count implements Analyzer{
    ArrayList res = new ArrayList<>();
    public Count(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++){
            int k = 1;
            for (int j = 0; j < arr.size(); j++){
                if (i != j){
                    if (arr.get(i).equals(arr.get(j))){
                        arr.remove(j);
                        k = k + 1;
                    }
                }
            }
            res.add(arr.get(i));
            res.add(k);
        }
    }
        //new ReportBuilder().Print(res);
}
