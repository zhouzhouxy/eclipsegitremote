package com.qrcode;

public class Test {
	public static void main(String[] args) throws Exception {
		//���ɶ�ά��
		/*
		 *����ͼƬ��·��  src/ ��ά��.png 
		 *������Ϣ����ַ��Ϣ����hello World
		 * */
		String imgPath="src/��ά��.png";
		String content="hellojava";
		//���ɶ�ά��
		/*
		 * ���ܣ�������Ϣ->��ά��
		 * ���ܣ���ά��->������Ϣ
		 * */
		//���ܣ�������Ϣ->��ά��
		QRCodeUtil qrUtil=new QRCodeUtil();
		qrUtil.encoderQRCode(content, imgPath, "png", 7);
		//���ܣ���ά��->������Ϣ
		String contentImg = qrUtil.decoderQRCode(imgPath);
		System.out.println(contentImg);
	}
}
