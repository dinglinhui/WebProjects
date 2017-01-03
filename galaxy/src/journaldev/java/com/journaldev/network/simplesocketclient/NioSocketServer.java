package com.journaldev.network.simplesocketclient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NioSocketServer {
	public NioSocketServer() {
		try {
			// 创建一个 AsynchronousServerSocketChannel 侦听 5000 端口
			final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel
					.open().bind(new InetSocketAddress(5000));

			// 侦听新的请求
			listener.accept(null,
					new CompletionHandler<AsynchronousSocketChannel, Void>() {

						@Override
						public void completed(AsynchronousSocketChannel ch,
								Void att) {
							// 接受下一个连接
							listener.accept(null, this);

							// 向客户端发送问候信息
							ch.write(ByteBuffer
									.wrap("Hello, I am Echo Server 2020, let's have an engaging conversation!n"
											.getBytes()));

							// 分配(4K)字节缓冲用于从客户端读取信息
							ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
							try {
								// Read the first line
								int bytesRead = ch.read(byteBuffer).get(20,
										TimeUnit.SECONDS);

								boolean running = true;
								while (bytesRead != -1 && running) {
									System.out.println("bytes read: "
											+ bytesRead);

									// 确保有读取到数据
									if (byteBuffer.position() > 2) {
										// 准备缓存进行读取
										byteBuffer.flip();

										// 把缓存转换成字符串
										byte[] lineBytes = new byte[bytesRead];
										byteBuffer.get(lineBytes, 0, bytesRead);
										String line = new String(lineBytes);

										// Debug
										System.out.println("Message: " + line);

										// 向调用者回写
										ch.write(ByteBuffer.wrap(line
												.getBytes()));

										// 准备缓冲进行写操作
										byteBuffer.clear();

										// 读取下一行
										bytesRead = ch.read(byteBuffer).get(20,
												TimeUnit.SECONDS);
									} else {
										// 在我们的协议中，空行表示会话结束
										running = false;
									}
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (ExecutionException e) {
								e.printStackTrace();
							} catch (TimeoutException e) {
								// 用户达到20秒超时，关闭连接
								ch.write(ByteBuffer.wrap("Good Byen".getBytes()));
								System.out
										.println("Connection timed out, closing connection");
							}

							System.out.println("End of conversation");
							try {
								// 如果需要，关闭连接
								if (ch.isOpen()) {
									ch.close();
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}

						@Override
						public void failed(Throwable exc, Void att) {
							// /...
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NioSocketServer server = new NioSocketServer();
		try {
			Thread.sleep(60000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
