import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class TodosApplication implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(TodosApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class,args);

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Todo Anwendung ist hochgefahren");


    }
}