package tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class MSWordTool {
	
//	public static void replaceTag(XWPFDocument doc, Map<String, String> map) {
//		Range range = doc.getR
//	}
	
	
	/**
	 * 替换所有段落中的标记
	 * 实际上就是遍历所有段落进行替换
	 * @param xwpfParagraphList
	 * @param params
	 */
	public static void replaceInAllParagraphs(List<XWPFParagraph> xwpfParagraphList,
				HashMap<String,String> params) {
		for(XWPFParagraph paragraph:xwpfParagraphList) {
			if(paragraph.getText() == null || paragraph.getText().equals(""))continue;
			for(String key:params.keySet()) {
				if(paragraph.getText().contains(key)) {
					replaceInParagraph(paragraph,key,params.get(key));
				}
			}
		}
	}
	
	/**
	 * 替换段落中的字符串
	 *
	 * @param xwpfParagraph
	 * @param oldString
	 * @param newString
	 */
	public static void replaceInParagraph(XWPFParagraph xwpfParagraph, String oldString, String newString) {
	    Map<String, Integer> pos_map = findSubRunPosInParagraph(xwpfParagraph, oldString);
	    if (pos_map != null) {
	        System.out.println("start_pos:" + pos_map.get("start_pos"));
	        System.out.println("end_pos:" + pos_map.get("end_pos"));

	        List<XWPFRun> runs = xwpfParagraph.getRuns();
	        XWPFRun modelRun = runs.get(pos_map.get("end_pos"));
	        XWPFRun xwpfRun = xwpfParagraph.insertNewRun(pos_map.get("end_pos") + 1);
	        xwpfRun.setText(newString);
	        System.out.println("字体大小：" + modelRun.getFontSize());
	        if (modelRun.getFontSize() != -1) xwpfRun.setFontSize(modelRun.getFontSize());//默认值是五号字体，但五号字体getFontSize()时，返回-1
	        xwpfRun.setFontFamily(modelRun.getFontFamily());
	        for (int i = pos_map.get("end_pos"); i >= pos_map.get("start_pos"); i--) {
	            System.out.println("remove run pos in :" + i);
	            xwpfParagraph.removeRun(i);
	        }
	    }
	}
	
	/**
	 * 找到段落中子串的起始XWPFRun下标和终止XWPFRun的下标
	 *
	 * @param xwpfParagraph
	 * @param substring
	 * @return
	 */
	public static Map<String, Integer> findSubRunPosInParagraph(XWPFParagraph xwpfParagraph, String substring) {

	    List<XWPFRun> runs = xwpfParagraph.getRuns();
	    int start_pos = 0;
	    int end_pos = 0;
	    String subtemp = "";
	    for (int i = 0; i < runs.size(); i++) {
	        subtemp = "";
	        start_pos = i;
	        for (int j = i; j < runs.size(); j++) {
	            if (runs.get(j).getText(runs.get(j).getTextPosition()) == null) continue;
	            subtemp += runs.get(j).getText(runs.get(j).getTextPosition());
	            if (subtemp.equals(substring)) {
	                end_pos = j;
	                Map<String, Integer> map = new HashMap<>();
	                map.put("start_pos", start_pos);
	                map.put("end_pos", end_pos);
	                return map;
	            }
	        }
	    }
	    return null;
	}

}
