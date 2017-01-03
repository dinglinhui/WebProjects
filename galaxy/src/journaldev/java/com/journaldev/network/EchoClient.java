package com.journaldev.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class EchoClient {

	private SocketChannel socketChannel;
	private int port = 8000;

	public EchoClient() throws Exception {
		socketChannel = SocketChannel.open();
		InetAddress inetAddress = InetAddress.getLocalHost();
		InetSocketAddress inetSocketAddress = new InetSocketAddress(
				inetAddress, port);
		socketChannel.connect(inetSocketAddress);
		System.out.println("准备连接服务器");
	}

	public static void main(String[] args) throws Exception {
		new EchoClient().talk();
	}

	public void talk() {
		try {
			BufferedReader reader = SocketUtils.getReader(socketChannel
					.socket());
			PrintWriter pw = SocketUtils.getWriter(socketChannel.socket());
			BufferedReader localreaderReader = new BufferedReader(
					new InputStreamReader(System.in));
			String msg = null;
			while ((msg = localreaderReader.readLine()) != null) {
				System.out.println(msg);
				pw.println(msg);
				pw.flush();
				System.out.println(reader.readLine());
				if ("bye".equals(msg)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			SocketUtils.close(socketChannel);
		}

	}
}
