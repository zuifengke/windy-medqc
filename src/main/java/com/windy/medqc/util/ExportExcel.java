package com.windy.medqc.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 鍒╃敤寮�婧愮粍浠禤OI3.0.2鍔ㄦ�佸鍑篍XCEL鏂囨。 杞浇鏃惰淇濈暀浠ヤ笅淇℃伅锛屾敞鏄庡嚭澶勶紒
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            搴旂敤娉涘瀷锛屼唬琛ㄤ换鎰忎竴涓鍚坖avabean椋庢牸鐨勭被
 *            娉ㄦ剰杩欓噷涓轰簡绠�鍗曡捣瑙侊紝boolean鍨嬬殑灞炴�xx鐨刧et鍣ㄦ柟寮忎负getXxx(),鑰屼笉鏄痠sXxx()
 *            byte[]琛╦pg鏍煎紡鐨勫浘鐗囨暟鎹�
 */
public class ExportExcel<T> {
	public void exportExcel(Collection<T> dataset, OutputStream out) {
		exportExcel("娴嬭瘯POI瀵煎嚭EXCEL鏂囨。", null, dataset, out, "yyyy-MM-dd", null);
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out) {
		exportExcel("娴嬭瘯POI瀵煎嚭EXCEL鏂囨。", headers, dataset, out, "yyyy-MM-dd", null);
	}

	public void exportExcel(String[] headers, Collection<T> dataset,
			OutputStream out, String pattern) {
		exportExcel("娴嬭瘯POI瀵煎嚭EXCEL鏂囨。", headers, dataset, out, pattern, null);
	}

	/**
	 * 杩欐槸涓�涓�氱敤鐨勬柟娉曪紝鍒╃敤浜咼AVA鐨勫弽灏勬満鍒讹紝鍙互灏嗘斁缃湪JAVA闆嗗悎涓苟涓旂鍙蜂竴瀹氭潯浠剁殑鏁版嵁浠XCEL 鐨勫舰寮忚緭鍑哄埌鎸囧畾IO璁惧涓�
	 * 
	 * @param title
	 *            琛ㄦ牸鏍囬鍚�
	 * @param headers
	 *            琛ㄦ牸灞炴�у垪鍚嶆暟缁�
	 * @param dataset
	 *            闇�瑕佹樉绀虹殑鏁版嵁闆嗗悎,闆嗗悎涓竴瀹氳鏀剧疆绗﹀悎javabean椋庢牸鐨勭被鐨勫璞°�傛鏂规硶鏀寔鐨�
	 *            javabean灞炴�х殑鏁版嵁绫诲瀷鏈夊熀鏈暟鎹被鍨嬪強String,Date,byte[](鍥剧墖鏁版嵁)
	 * @param out
	 *            涓庤緭鍑鸿澶囧叧鑱旂殑娴佸璞★紝鍙互灏咵XCEL鏂囨。瀵煎嚭鍒版湰鍦版枃浠舵垨鑰呯綉缁滀腑
	 * @param pattern
	 *            濡傛灉鏈夋椂闂存暟鎹紝璁惧畾杈撳嚭鏍煎紡銆傞粯璁や负"yyy-MM-dd"
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(String title, String[] headers,
			Collection<T> dataset, OutputStream out, String pattern,
			List fieldsExport) {
		// 澹版槑涓�涓伐浣滆杽
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 鐢熸垚涓�涓〃鏍�
		HSSFSheet sheet = workbook.createSheet(title);
		// 璁剧疆琛ㄦ牸榛樿鍒楀搴︿负15涓瓧鑺�
		sheet.setDefaultColumnWidth((short) 15);
		// 鐢熸垚涓�涓牱寮�
		HSSFCellStyle style = workbook.createCellStyle();
		// 璁剧疆杩欎簺鏍峰紡
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 鐢熸垚涓�涓瓧浣�
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 鎶婂瓧浣撳簲鐢ㄥ埌褰撳墠鐨勬牱寮�
		style.setFont(font);
		// 鐢熸垚骞惰缃彟涓�涓牱寮�
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 鐢熸垚鍙︿竴涓瓧浣�
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 鎶婂瓧浣撳簲鐢ㄥ埌褰撳墠鐨勬牱寮�
		style2.setFont(font2);

		// 澹版槑涓�涓敾鍥剧殑椤剁骇绠＄悊鍣�
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 瀹氫箟娉ㄩ噴鐨勫ぇ灏忓拰浣嶇疆,璇﹁鏂囨。
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 璁剧疆娉ㄩ噴鍐呭
		comment.setString(new HSSFRichTextString("鍙互鍦≒OI涓坊鍔犳敞閲婏紒"));
		// 璁剧疆娉ㄩ噴浣滆�咃紝褰撻紶鏍囩Щ鍔ㄥ埌鍗曞厓鏍间笂鏄彲浠ュ湪鐘舵�佹爮涓湅鍒拌鍐呭.
		comment.setAuthor("leno");

		// 浜х敓琛ㄦ牸鏍囬琛�
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// 閬嶅巻闆嗗悎鏁版嵁锛屼骇鐢熸暟鎹
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 鍒╃敤鍙嶅皠锛屾牴鎹甹avabean灞炴�х殑鍏堝悗椤哄簭锛屽姩鎬佽皟鐢╣etXxx()鏂规硶寰楀埌灞炴�у��
			Field[] fields = t.getClass().getDeclaredFields();
			int indexCell=0;
			for (short i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				if (fieldsExport != null && !fieldsExport.contains(fieldName))
					continue;
				HSSFCell cell = row.createCell(indexCell);
				cell.setCellStyle(style2);
				indexCell++;
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 鍒ゆ柇鍊肩殑绫诲瀷鍚庤繘琛屽己鍒剁被鍨嬭浆鎹�
					String textValue = null;
					// if (value instanceof Integer) {
					// int intValue = (Integer) value;
					// cell.setCellValue(intValue);
					// } else if (value instanceof Float) {
					// float fValue = (Float) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(fValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Double) {
					// double dValue = (Double) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(dValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Long) {
					// long longValue = (Long) value;
					// cell.setCellValue(longValue);
					// }

					if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						textValue = "鐢�";
						if (!bValue) {
							textValue = "濂�";
						}
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						// 鏈夊浘鐗囨椂锛岃缃楂樹负60px;
						row.setHeightInPoints(60);
						// 璁剧疆鍥剧墖鎵�鍦ㄥ垪瀹藉害涓�80px,娉ㄦ剰杩欓噷鍗曚綅鐨勪竴涓崲绠�
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
								1023, 255, (short) 6, index, (short) 6, index);
						anchor.setAnchorType(2);
						patriarch.createPicture(anchor, workbook.addPicture(
								bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 鍏跺畠鏁版嵁绫诲瀷閮藉綋浣滃瓧绗︿覆绠�鍗曞鐞�
						textValue = value.toString();
					}
					// 濡傛灉涓嶆槸鍥剧墖鏁版嵁锛屽氨鍒╃敤姝ｅ垯琛ㄨ揪寮忓垽鏂璽extValue鏄惁鍏ㄩ儴鐢辨暟瀛楃粍鎴�
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 鏄暟瀛楀綋浣渄ouble澶勭悊
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);
							HSSFFont font3 = workbook.createFont();
							font3.setColor(HSSFColor.BLUE.index);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 娓呯悊璧勬簮
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}