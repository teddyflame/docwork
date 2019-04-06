
import java.io.File;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.This;
import net.bytebuddy.description.type.TypeDescription.Generic;
import wordedit.ZhiYaBuChongEdit;
import wordedit.entity.ZhiYaBuChongRules;

@Controller
@EnableAutoConfiguration
@ComponentScan("controller")
public class Example {
	
	@RequestMapping("/")
	String home() {
		return "ZYBC_input";
	}

	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
		String path = Example.class.getProtectionDomain().getCodeSource() 
                .getLocation().getPath(); 
		System.out.println("class 路径" +path);
//		File file = new File(path);
//		System.out.println(file.getParentFile().getAbsolutePath());
		//ZhiYaBuChongEdit edit = new ZhiYaBuChongEdit();
	}

}
