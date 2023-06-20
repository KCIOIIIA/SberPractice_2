package Task_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class App {
    @Bean
    public Parser parser(){

        //return new Parser();
        return null;
    }
    @Bean
    public Analyzer analyzer(){

        //return new Analyzer(parser());
        return null;
    }
    @Bean
    public ReportBuilder reportBuilder(){
        //return new ReportBuilder(analyzer());
        return null;
    }

}
