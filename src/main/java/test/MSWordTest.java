package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import tools.MSWordTool;

public class MSWordTest {

	public static void main(String[] args) throws IOException,InvalidFormatException{
		String filepath = "D:\\workspace\\myLab\\files\\origin.docx";
		String destpath = "D:\\workspace\\myLab\\files\\newDoc.docx";
		
		HashMap<String, String> map = initReplaceWords();
		
		
		InputStream is = new FileInputStream(filepath);
		XWPFDocument document = new XWPFDocument(is);
		//对段落中的标记进行替换
		MSWordTool.replaceInAllParagraphs(document.getParagraphs(),map);
		
		
		//保存
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(destpath);
			document.write(fos);
			fos.flush();
			fos.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		document.close();

	}
	

	private static HashMap<String, String> initReplaceWords(){
		HashMap<String, String> map = new HashMap<>();
		
		map.put("${text1}","替换1");
		map.put("${text2}", "替换2");
		return map;
	}

}
