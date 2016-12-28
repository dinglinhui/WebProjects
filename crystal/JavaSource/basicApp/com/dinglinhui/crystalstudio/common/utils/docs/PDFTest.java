package com.dinglinhui.crystalstudio.common.utils.docs;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;

import com.itextpdf.text.Font;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.text.pdf.PdfWriter;

public class PDFTest {

	public static void main(String[] args) {

		// 1.创建一个Document实例
		Document document = new Document();
		try {
			// 获取当前类生成class所在的路径
			String strPath = PDFTest.class.getClassLoader().getResource("")
					.toString();
			// 获取file:/后面的路径
			strPath = strPath.substring(6);
			String strFileName = strPath + "test.pdf";
			// 2.用PdfWriter类 将Document实例和文件输出流 绑定在一起
			PdfWriter
					.getInstance(document, new FileOutputStream(strFileName));
			// 3.打开文档
			document.open();
			// 4.向文档中添加内容
			// 字体
			BaseFont bf = BaseFont.createFont("STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font font = new Font(bf, 9, Font.NORMAL);
			Paragraph title = new Paragraph("丁林辉", font);
			title.setAlignment(title.ALIGN_CENTER);
			document.add(title);
			
			document.add(new Paragraph("Hello World"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 5.关闭文档
		document.close();

	}

}