package com.dinglinhui.crystalstudio.common.utils.docs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class DB2PDF {
	/**
	 * 利用iText，将数据库表中的数据写入PDF文件中。
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Hello Oracle");
		// 第一步：创建一个document对象。
		Document document = new Document();
		try {
			// 第二步：
			// 创建一个PdfWriter实例，
			// 将文件输出流指向一个文件。
			PdfWriter pdf = PdfWriter.getInstance(document,
					new FileOutputStream("D:\\DB.pdf"));
			// 第三步：打开文档。
			document.open();
			// 第四步：创建数据库连接 。
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection conn = DriverManager.getConnection(
			//		"jdbc:oracle:thin:@localhost:1521:orcl", "sys1", "abc");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/g4studio?useUnicode=true&characterEncoding=utf-8", "root", "871088");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from eauser");

			while (rs.next()) { // 循环取得所有数据
				String s = "";
				for (int i = 1; i <= 8; i++) {

					s += rs.getObject(i) == null ? "" : rs.getObject(i)
							.toString() + "\t";
				}
				document.add(new Paragraph(s));
			}
			document.add(new Paragraph("Hello World" + "     fdgdsf "
					+ "Hello xDuan"));

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		// 第五步：关闭文档。
		document.close();
		System.out.println("快去看看吧");
	}
}