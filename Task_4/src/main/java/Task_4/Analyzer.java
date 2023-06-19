package Task_4;

import org.springframework.context.annotation.Bean;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analyzer {

    public void count(ArrayList<String> arr){

        ArrayList res = new ArrayList<>();

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
        new ReportBuilder().Print(res);
    }
}
