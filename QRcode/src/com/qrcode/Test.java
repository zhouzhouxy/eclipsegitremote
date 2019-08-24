package com.qrcode;

public class Test {
	public static void main(String[] args) throws Exception {
		//生成二维码
		/*
		 *生成图片的路径  src/ 二维码.png 
		 *文字信息、网址信息：“hello World
		 * */
		String imgPath="src/二维码.png";
		String content="hellojava";
		//生成二维码
		/*
		 * 加密：文字信息->二维码
		 * 解密：二维码->文字信息
		 * */
		//加密：文字信息->二维码
		QRCodeUtil qrUtil=new QRCodeUtil();
		qrUtil.encoderQRCode(content, imgPath, "png", 7);
		//解密：二维码->文字信息
		String contentImg = qrUtil.decoderQRCode(imgPath);
		System.out.println(contentImg);
	}
}
