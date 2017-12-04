package API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args){
        Connection connection = Connection.getConnection();
        connection.start();
        SpringApplication.run(Application.class, args);
        //connection.stop();
    }
}
