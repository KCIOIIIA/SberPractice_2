package Task_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    @Autowired
    public Parser parser;
    @Autowired
    public Analyzer analyzer;
    @Autowired
    public ReportBuilder reportBuilder;
    public void exec() throws FileNotFoundException {
        ArrayList<String> Array = new ArrayList();
        //Scanner s = parser.Load();
        //ArrayList<String> Arr = parser.Next(s, Array);
        //ArrayList res = analyzer.Count(Arr);
        //reportBuilder.build(res);
    }
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getBean(Main.class).exec();
    }
}