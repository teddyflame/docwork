
import java.io.File;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wordedit.entity.ZhiYaBuChongRules;

@Controller
@EnableAutoConfiguration
@ComponentScan("controller")
public class Example {
	
	@RequestMapping("/")
	String home() {
		//System.out.println("test \n is is");
		return "ZYBC_input";
	}
	
//	@RequestMapping(value = "/signup")
//	public String signup(Map<String, Object> paraMap) {
//		System.out.println("signup");
//		
//		//默认Map的内容会放到请求域中，页面可直接取值
//		paraMap.put("name", "zhangsan");
//		paraMap.put("age", 28);
//		
//		//会自动跳转到 /templates/success.html页面
//		return "success";
//	}
//	
//	@RequestMapping(value = "/ZYBC_make")
//	public String ZYBCGenerate(ZhiYaBuChongRules rules) {
//		System.out.println("ZYBC_make");
//		System.out.println(rules.getMode());
//
//		
//		//会自动跳转到 /templates/success.html页面
//		return "success";
//	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Example.class, args);
	}

}
