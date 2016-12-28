package com.dinglinhui.crystalstudio.common.utils.encrypt;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import com.sun.crypto.provider.SunJCE;

public class DHKey {
	public static void main(String argv[]) {
		try {
			DHKey my = new DHKey();
			my.run();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private void run() throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		System.out.println("ALICE: 产生 DH 对 ...");
		KeyPairGenerator aliceKpairGen = KeyPairGenerator.getInstance("DH");
		aliceKpairGen.initialize(512);
		KeyPair aliceKpair = aliceKpairGen.generateKeyPair(); // 生成时间长
		// 张三 (Alice) 生成公共密钥 alicePubKeyEnc 并发送给李四 (Bob) ,
		// 比如用文件方式 ,socket.....
		byte[] alicePubKeyEnc = aliceKpair.getPublic().getEncoded();
		// bob 接收到 alice 的编码后的公钥 , 将其解码
		KeyFactory bobKeyFac = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(alicePubKeyEnc);
		PublicKey alicePubKey = bobKeyFac.generatePublic(x509KeySpec);
		System.out.println("alice 公钥 bob 解码成功");
		// bob 必须用相同的参数初始化的他的 DH KEY 对 , 所以要从 Alice 发给他的公开密钥 ,
		// 中读出参数 , 再用这个参数初始化他的 DH key 对
		// 从 alicePubKye 中取 alice 初始化时用的参数
		DHParameterSpec dhParamSpec = ((DHPublicKey) alicePubKey).getParams();
		KeyPairGenerator bobKpairGen = KeyPairGenerator.getInstance("DH");
		bobKpairGen.initialize(dhParamSpec);
		KeyPair bobKpair = bobKpairGen.generateKeyPair();
		System.out.println("BOB: 生成 DH key 对成功");
		KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH");
		bobKeyAgree.init(bobKpair.getPrivate());
		System.out.println("BOB: 初始化本地 key 成功");
		// 李四 (bob) 生成本地的密钥 bobDesKey
		bobKeyAgree.doPhase(alicePubKey, true);
		SecretKey bobDesKey = bobKeyAgree.generateSecret("DES");
		System.out.println("BOB: 用 alice 的公钥定位本地 key, 生成本地 DES 密钥成功");
		// Bob 生成公共密钥 bobPubKeyEnc 并发送给 Alice,
		// 比如用文件方式 ,socket....., 使其生成本地密钥
		byte[] bobPubKeyEnc = bobKpair.getPublic().getEncoded();
		System.out.println("BOB 向 ALICE 发送公钥");
		// alice 接收到 bobPubKeyEnc 后生成 bobPubKey
		// 再进行定位 , 使 aliceKeyAgree 定位在 bobPubKey
		KeyFactory aliceKeyFac = KeyFactory.getInstance("DH");
		x509KeySpec = new X509EncodedKeySpec(bobPubKeyEnc);
		PublicKey bobPubKey = aliceKeyFac.generatePublic(x509KeySpec);
		System.out.println("ALICE 接收 BOB 公钥并解码成功");
		;
		KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH");
		aliceKeyAgree.init(aliceKpair.getPrivate());
		System.out.println("ALICE: 初始化本地 key 成功");
		aliceKeyAgree.doPhase(bobPubKey, true);
		// 张三 (alice) 生成本地的密钥 aliceDesKey
		SecretKey aliceDesKey = aliceKeyAgree.generateSecret("DES");
		System.out.println("ALICE: 用 bob 的公钥定位本地 key, 并生成本地 DES 密钥");
		if (aliceDesKey.equals(bobDesKey))
			System.out.println("张三和李四的密钥相同");
		// 现在张三和李四的本地的 deskey 是相同的所以 , 完全可以进行发送加密 , 接收后解密 , 达到
		// 安全通道的的目的
		/*
		 * bob 用 bobDesKey 密钥加密信息
		 */
		Cipher bobCipher = Cipher.getInstance("DES");
		bobCipher.init(Cipher.ENCRYPT_MODE, bobDesKey);
		String bobinfo = "这是李四的机密信息";
		System.out.println("李四加密前原文 :" + bobinfo);
		byte[] cleartext = bobinfo.getBytes();
		byte[] ciphertext = bobCipher.doFinal(cleartext);
		/*
		 * alice 用 aliceDesKey 密钥解密
		 */
		Cipher aliceCipher = Cipher.getInstance("DES");
		aliceCipher.init(Cipher.DECRYPT_MODE, aliceDesKey);
		byte[] recovered = aliceCipher.doFinal(ciphertext);
		System.out.println("alice 解密 bob 的信息 :" + (new String(recovered)));
		if (!java.util.Arrays.equals(cleartext, recovered))
			throw new Exception("解密后与原文信息不同");
		System.out.println("解密后相同");
	}
}