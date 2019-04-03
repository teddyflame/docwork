package wordedit;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import wordedit.entity.ZhiYaBuChongRules;

public class ZhiYaBuChongEdit {
	public static final String OUT_FILE_NAME = "质押协议补充协议_生成";
	private static final String XINZENG_TEMPLATE = "质押协议补充协议_模板_新增V1.xml";
	private static final String ZHIHUAN_TEMPLATE = "质押协议补充协议_模板_置换V1.xml";		
	
	public void initRules(){
		//收到前台传来的Json对象；
		//根据Json，创建规则类；
		
	}
	
	public void generateXML(int mode,String filepath) {
		if(mode==0) {
			generateXinZeng(filepath);
		}else {
			generateZhiHuan(filepath);
		}
	}
	
	public void generateXinZeng(String filepath) {
		
		ZhiYaBuChongRules rules = testRules();
		
		//先做替换
		//step 1 创建freemarker配置实例
		Configuration configuration = new Configuration();
		Writer out = null;
				
		try {
			//step2 获取模板路径
			configuration.setDirectoryForTemplateLoading
				(new File(filepath));
			//step3 创建数据模型
			Map<String,String> map = new HashMap<>();
			//map.put(key, value);
			
			//step 4 加载模板文件
			Template template = configuration.getTemplate(XINZENG_TEMPLATE);
			//step 5 生成数据
			File docFile = new File(filepath +"\\"+OUT_FILE_NAME);
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			//step 6 输出文件
			template.process(map, out);
			System.out.println("文件创建成功！");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=out)  out.flush();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void generateZhiHuan(String filepath) {
		
	}
	
	public static ZhiYaBuChongRules testRules() {
		ZhiYaBuChongRules rules = new ZhiYaBuChongRules();
		
		rules.setMode(0);
//		rules.setBuChongDate("2019年3月31日");
//		rules.setZhiYaDate("2019年1月1日");
//		rules.setZhiYaNo("zhiya-001");
//		rules.setClause0("3.3");
		
		rules.setHasCunDan(false);
		rules.setHasCunKuan(true);
		rules.setHasDingQi(false);
		
		rules.setCunKuanClause("3.4");
		rules.setCunDanName("存单的名称");
		rules.setCunKuanNo("存款的编号");
		rules.setCunKuanValue("13456.22");
		
		rules.setHasCunDan3(false);
		rules.setHasCunKuan3(true);
		rules.setHasDingQi3(false);
		
//		rules.setCunKuanName311("张三");
		rules.setCunKuanNo311("张三的编号");
//		rules.setCunKuanValue311("13456.22-no2");
		
		rules.setHas34(false);
		
		rules.setClause41("4.1");
		rules.setClause42("4.2");
		
		rules.setChuzhiren("李四");
		
		
		return rules;
	}
}
