package wordedit;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import wordedit.entity.ZhiYaBuChongRules;

public class ZhiYaBuChongEdit {
	public static final String OUT_FILE_NAME = "质押协议补充协议-生成文档";
	public static final String XINZENG_TEMPLATE = "质押协议补充协议_模板_新增V2";
	public static final String ZHIHUAN_TEMPLATE = "质押协议补充协议_模板_替换V1";	
	
	public static final String TEMPLATE_PATH = 
			"files";
	public static final String OUT_PATH = 
			"files";
	
	public void initRules(){
		//收到前台传来的Json对象；
		//根据Json，创建规则类；
		
	}
	
//	public void generateXML(int mode,String filepath) {
//		if(mode==0) {
//			generateXinZeng(filepath);
//		}else {
//			//generateZhiHuan(filepath);
//		}
//	}
	
	public static boolean generateXinZeng(ZhiYaBuChongRules rules) {
				
		
		return true;
	}
	
	/**
	 * 质押协议补充协议-替换模式的文本处理
	 * @param rules
	 */
	public static boolean generateZhiHuan(ZhiYaBuChongRules rules) {
		//关键词替换
		//step 1 创建freemarker配置实例
		Configuration configuration = new Configuration();
		Writer out = null;
		try {
			//step2 获取模板路径
			configuration.setDirectoryForTemplateLoading
				(new File(TEMPLATE_PATH));
			//step3 创建数据模型
			Map<String, String> map = new HashMap<>();
			String[] zhiyaYYMMDD = rules.getDate2().split("-");
			String date2 = zhiyaYYMMDD[0]+"年"+zhiyaYYMMDD[1]
					+"月"+zhiyaYYMMDD[2]+"日";
			String[] buchongYYMMDD = rules.getDate1().split("-");
			String date1 = buchongYYMMDD[0]+"年"+buchongYYMMDD[1]
					+"月"+buchongYYMMDD[2]+"日";
					
			map.put("date1", date1);
			map.put("date2", date2);
			map.put("headNo", rules.getHead_no());
			map.put("headClause", rules.getHead_clause());
			map.put("number31", rules.getNo_31());
					
			//String value = rules.getCurrency() +"\n"
			//		+rules.getValue();
			String[] beginYYMMDD = rules.getBeginDate31().split("-");
			String beginDate = beginYYMMDD[0]+"年"+beginYYMMDD[1]
					+"月"+beginYYMMDD[2]+"日";
					
			String[] endYYMMDD = rules.getEndDate31().split("-");
			String endDate = endYYMMDD[0]+"年"+endYYMMDD[1]
					+"月"+endYYMMDD[2]+"日";
			String cunkuanDate = beginDate + "至"+endDate;
					
			//存款详情
			map.put("name311", rules.getCunkuanren());
			map.put("no311", rules.getCunKuanNo311());
			map.put("currency311", rules.getCurrency());
			map.put("value311", rules.getValue()+"元");
					
			//存单详情
			map.put("name312", rules.getCunkuanren());
			map.put("no312", rules.getCunDanNo312());
			map.put("date312",cunkuanDate);
			map.put("currency312", rules.getCurrency());
			map.put("value312", rules.getValue()+"元");
					
			//定期存款详情
			map.put("name313", rules.getCunkuanren());
			map.put("no313", rules.getDingQiNo313());
			map.put("date313",cunkuanDate);
			map.put("currency313", rules.getCurrency());
			map.put("value313", rules.getValue()+"元");
					
			map.put("clause41", rules.getClause41());
			map.put("clause42", rules.getClause42());
					
			map.put("date3", date1);
			map.put("date4", date1);
			map.put("chuzhiren", rules.getChuzhiren());

			//step 4 加载模板文件
			Template template = configuration.getTemplate(ZHIHUAN_TEMPLATE +".xml");
			//step 5 生成数据
			File docFile = new File(OUT_PATH +"\\"+OUT_FILE_NAME+".xml");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			//step 6 输出文件
			template.process(map, out);
			System.out.println("文件创建成功！");
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if(null!=out) {
					out.flush();
					out.close();
				}	
			}catch (Exception e2) {
					e2.printStackTrace();
			}
		}
	}
	
	public static boolean ZhiHuanpara(ZhiYaBuChongRules rules) {
		//dom4j操作
		//step 1: 读取xml文档
		SAXReader saxReader = new SAXReader();
		File docFile = new File(OUT_PATH +"\\"+OUT_FILE_NAME+".xml");
		Document document = null;
		try {
			document = saxReader.read(docFile);
			//step 2 获取根节点
			Element root = document.getRootElement();
		
			//获取根节点下面所有的子节点
			List<Element> listElement = root.elements();
			//遍历所有的子节点
			for(Element e1:listElement) {
				Attribute e1Attribute = (Attribute) e1.attributes().get(0);
				if(e1Attribute!=null && e1Attribute.getValue().equals("/word/document.xml")) {//找到正文
					List<Element> paraList = e1.element("xmlData").element("document").element("body").elements();
					for(Element e3:paraList) {
						Attribute idAttribute = e3.attribute("id");
						if(idAttribute==null)continue;
						//删除存款详情
						if(rules.getHasCunKuan3()==null || !rules.getHasCunKuan3()) {
							if(idAttribute.getValue().equals("title311")
									||idAttribute.getValue().equals("3.1.1Enter")
									||idAttribute.getValue().equals("3.1.1Table")) {
								System.out.println("删除节点："+idAttribute.getValue());
								e3.getParent().remove(e3);
							}
						}
						//删除存单详情
						if(rules.getHasCunDan3()==null || !rules.getHasCunDan3()) {
							if(idAttribute.getValue().equals("3.1.2Title")
									||idAttribute.getValue().equals("3.1.2Enter")
									||idAttribute.getValue().equals("3.1.2Table")) {
								System.out.println("删除节点："+idAttribute.getValue());
								e3.getParent().remove(e3);
							}
						}
						//删除定期存款详情
						if(rules.getHasDingQi3()==null || !rules.getHasDingQi3()) {
							if(idAttribute.getValue().equals("3.1.3Title")
									||idAttribute.getValue().equals("3.1.3Enter")
									||idAttribute.getValue().equals("3.1.3Table")) {
								System.out.println("删除节点："+idAttribute.getValue());
								e3.getParent().remove(e3);
							}
						}
						//删除2.4条款
						if((rules.getHas34()!=null && rules.getHas34()) 
								&& idAttribute.getValue().equals("34")) {
							System.out.println("删除节点："+idAttribute.getValue());
							e3.getParent().remove(e3);
						}
					}
				}
			}
			//保存XML文件
			XMLWriter writer = new XMLWriter(new FileWriter
					(new File(OUT_PATH +"\\"+OUT_FILE_NAME+".xml")));
			writer.write(document);
			writer.close();
			System.out.println("置换-段落处理完成！");			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
