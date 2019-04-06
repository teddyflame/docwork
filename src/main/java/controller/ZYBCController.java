package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DocumentFilter;

import org.apache.tomcat.util.digester.RuleSet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.template.Configuration;
import freemarker.template.Template;
import wordedit.ZhiYaBuChongEdit;
import wordedit.entity.ZhiYaBuChongRules;

@Controller
public class ZYBCController {
	
	@RequestMapping(value = "/ZYBC_make")
	public String ZYBCinfoIn(ZhiYaBuChongRules rules) {
		System.out.println("ZYBC_make");
		System.out.println(rules.getMode());
		Boolean isSuccess = false;
		//判断是新增还是替换
		if(rules.getMode()==1) {//替换
			System.out.println("开始进行替换协议的处理");
			isSuccess = ZhiYaBuChongEdit.generateZhiHuan(rules);
			isSuccess &= ZhiYaBuChongEdit.zhihuanPara(rules);
		}else if(rules.getMode()==0) {//新增
			isSuccess = ZhiYaBuChongEdit.generateXinZeng(rules);
			isSuccess &= ZhiYaBuChongEdit.xinzengPara(rules);
		}
		
		//会跳转到 /templates/success.html(或者fail)页面
		if(isSuccess) return "success";
		return "fail";
	}
	
}
