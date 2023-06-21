package Task_4;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Counter implements Analyzer{
    ArrayList res = new ArrayList<>();

    @Override
    public void exec() throws FileNotFoundException {
        ArrayList<String> Array = new ArrayList();

        Scanner s = new ParserTXT().Load();
        ArrayList<String> Arr = new ParserTXT().Next(s, Array);
        ArrayList res = Count(Arr);
        new ReportBuilderTXT().build(res);

    }
    @Override
    public ArrayList Count(ArrayList<String> arr) {
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
        return res;
    }
}
