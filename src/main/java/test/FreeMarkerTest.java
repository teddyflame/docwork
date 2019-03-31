package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {
	private static final String TEMPLATE_PATH = 
			"files";
	private static final String OUT_PATH = 
			"files";

	public static void main(String[] args) {
		
		//step 1 创建freemarker配置实例
		Configuration configuration = new Configuration();
		Writer out = null;
		
		try {
			//step2 获取模板路径
			configuration.setDirectoryForTemplateLoading
				(new File(TEMPLATE_PATH));
			//step3 创建数据模型
			Map<String, String> map = new HashMap<>();
			map.put("no1", "135");
			map.put("p1_name","zhangsan");
			map.put("p1_sex", "male");
			map.put("p1_tel", "13600000000");
			map.put("no2", "246");
			map.put("p2_name","lisi");
			map.put("p2_addr", "sddz");
			map.put("p2_cundan", "xurr_123");
			//step 4 加载模板文件
			Template template = configuration.getTemplate("测试模板1.xml");
			//step 5 生成数据
			File docFile = new File(OUT_PATH +"\\"+"freemarkerTest.xml");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			//step 6 输出文件
			template.process(map, out);
			System.out.println("文件创建成功！");
			
			
			//dom4j操作
			//step 1: 读取xml文档
			SAXReader saxReader = new SAXReader();
			Document document= saxReader.read(docFile);
			
			//step 2 获取根节点
			Element root = document.getRootElement();
			
			//获取根节点下面所有的子节点
			List<Element> listElement = root.elements();
			//遍历所有的子节点
			for(Element e1:listElement) {
				//e1.attribute("pkg:name");
				Attribute e1Attribute = (Attribute) e1.attributes().get(0);
				if(e1Attribute!=null && e1Attribute.getValue().equals("/word/document.xml")) {
//					Element e2 = e1.element("pkg:xmlData").element("w:document").element("w:body");
					List<Element> paraList = e1.element("xmlData").element("document").element("body").elements();
					for(Element e3:paraList) {
						Attribute idAttribute = e3.attribute("id");
						if(idAttribute!=null && idAttribute.getValue().equals("part1")) {
							System.out.println("find!");
							e3.detach();
						}
						
						if(idAttribute!=null && idAttribute.getValue().equals("part2")) {
							System.out.println("find 2!");
							e3.detach();
						}
					}
				}
				
			}
			
			//保存XML文件
			XMLWriter writer = new XMLWriter(new FileWriter(new File(OUT_PATH +"\\"+"dom4jOut.xml")));
			writer.write(document);
			writer.close();
			System.out.println("dom4j完成！");
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
		
		

}

