package com.journaldev.network.simplesocketclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SimpleSocketClientExample {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: SimpleSocketClientExample <server> <path>");
			System.exit(0);
		}
		String server = args[0];
		String path = args[1];

		System.out.println("Loading contents of URL: " + server);

		try {
			// 创建与端口为80的网络服务器对应的客户端socket
			Socket socket = new Socket(server, 80);

			// 从服务器端获取一个PrintStream
			PrintStream out = new PrintStream(socket.getOutputStream());
			// 获取服务器端的InputStream，用一个BufferedReader将其包装
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			// 发送一个GET PATH HTTP/1.0请求到服务器端
			out.println("GET " + path + " HTTP/1.0");
			out.println();

			// 按行的读取服务器端的返回的响应数据
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}

			// 关闭流
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
