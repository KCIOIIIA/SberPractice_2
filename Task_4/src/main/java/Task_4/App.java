package Task_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class App {
    @Bean
    public Main main(){
        return new Main();
    }
    @Bean
    public Parser parser(){
        return new ParserTXT();
    }
    @Bean
    public Analyzer analyzer(){
        return new Counter();
    }
    @Bean
    public ReportBuilder reportBuilder(){
        return new ReportBuilderTXT();
    }

}
