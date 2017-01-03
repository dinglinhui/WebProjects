package com.journaldev.network.simplesocketclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer extends Thread {
	private ServerSocket serverSocket;
	private int port;
	private boolean running = false;

	public SimpleSocketServer(int port) {
		this.port = port;
	}

	public void startServer() {
		try {
			serverSocket = new ServerSocket(port);
			this.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopServer() {
		running = false;
		this.interrupt();
	}

	@Override
	public void run() {
		running = true;
		while (running) {
			try {
				System.out.println("Listening for a connection");

				// 调用 accept() 处理下一个连接
				Socket socket = serverSocket.accept();

				// 向 RequestHandler 线程传递socket对象进行处理
				RequestHandler requestHandler = new RequestHandler(socket);
				requestHandler.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: SimpleSocketServer <port>");
			System.exit(0);
		}
		int port = Integer.parseInt(args[0]);
		System.out.println("Start server on port: " + port);

		SimpleSocketServer server = new SimpleSocketServer(port);
		server.startServer();

		// 1分钟后自动关闭
		try {
			Thread.sleep(60000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		server.stopServer();
	}
}

class RequestHandler extends Thread {
	private Socket socket;

	RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Received a connection");

			// 获取输入和输出流
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			// 向客户端写出头信息
			out.println("Echo Server 1.0");
			out.flush();

			// 向客户端回写信息，直到客户端关闭连接或者收到空行
			String line = in.readLine();
			while (line != null && line.length() > 0) {
				out.println("Echo: " + line);
				out.flush();
				line = in.readLine();
			}

			// 关闭自己的连接
			in.close();
			out.close();
			socket.close();

			System.out.println("Connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
