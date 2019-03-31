import java.util.Map;

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
	
	@RequestMapping(value = "/signup")
	public String signup(Map<String, Object> paraMap) {
		System.out.println("signup");
		
		//默认Map的内容会放到请求域中，页面可直接取值
		paraMap.put("name", "zhangsan");
		paraMap.put("age", 28);
		
		//会自动跳转到 /templates/success.html页面
		return "success";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Example.class, args);
	}

}
