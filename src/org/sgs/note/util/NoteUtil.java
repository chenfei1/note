package org.sgs.note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	public static String creatId() throws Exception{
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	public static String md5(String msg) throws Exception{
		//����md5��msg����
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] input = msg.getBytes();
		byte[] output = md.digest(input);//���ֽ�ת��Ϊ�ַ�
		//��md5�����output���ת���ַ���
		String result = Base64.encodeBase64String(output);
		return result;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(md5("root"));
		System.out.println(md5("asdfgthhkj"));
		System.out.println(creatId());

	}
}
