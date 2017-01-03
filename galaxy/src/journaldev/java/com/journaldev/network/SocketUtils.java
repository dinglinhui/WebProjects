package com.journaldev.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class SocketUtils {

	public static PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os);
	}

	public static PrintWriter getWriter(SocketChannel socketChannel)
			throws IOException {
		return getWriter(socketChannel.socket());
	}

	public static BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is, "UTF-8"));
	}

	public static BufferedReader getReader(SocketChannel socketChannel)
			throws IOException {
		return getReader(socketChannel.socket());
	}

	public static void close(Socket socket) {
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(SocketChannel socketChannel) {
		try {
			if (socketChannel != null) {
				socketChannel.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String echo(String msg) {
		return "echo:" + msg;
	}
}
