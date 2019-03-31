import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class Example {
	
	@RequestMapping("/")
	String home() {
		return "hello ted!";
	}
	
	@RequestMapping(value = "/home")
	public String home2() {
		System.out.println("redirect to home page");
		return "index";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Example.class, args);
	}

}
