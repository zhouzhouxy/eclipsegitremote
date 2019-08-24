package com.qrcode;


import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class QRCodeUtil {
	//加密：文字信息->二维码
	/*
	 * content:文字信息
	 * */
	public void encoderQRCode(String content,String imgPath,String imgType,int size)throws Exception{
		//BufferedImage：内存中的一张图片
		BufferedImage bufImg=qRcodeCommon( content, imgPath, size);
		
		File file=new File(imgPath);//src/二维码.png  --->二维码。png 
		ImageIO.write(bufImg, imgType, file);
	}
	//生成一个二维码的BufferedImage
	/*
	 * content:而我吗中隐藏的信息
	 * imgType:图片格式
	 * size:二维码边长
	 * */
	private BufferedImage qRcodeCommon(String content,String imageType,int size)throws Exception{
		BufferedImage bufImg=null;
		//QrCode对象：字符串->boolean[][]
		Qrcode qrcodeHandler=new Qrcode();
		//设置二维码的排错率：7% L<M<Q<H 30% :排错率越高，可存储的信息越少；但是对二维码清晰要求更小
		qrcodeHandler.setQrcodeErrorCorrect('M');
		//可存放的信息类型：N:数字、A:数字+A-Z B：所有
		qrcodeHandler.setQrcodeEncodeMode('B');
		//尺寸:取值范围：1-40
		qrcodeHandler.setQrcodeVersion(size);
		byte[] contentBytes=content.getBytes();//“Hello world” ->byte[] helloworld
		//-->boolean[][]
		boolean[][] codeOut=qrcodeHandler.calQrcode(contentBytes);
		int imgSize=67+12*(size-1);
		//BufferedImage：内存中的图片
		bufImg=new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
		//创建一个画板
		Graphics2D gs=bufImg.createGraphics();
		gs.setBackground(Color.WHITE);//将画板的背景色设置为白色
		gs.clearRect(0, 0, size, size);//初始化
		gs.setColor(Color.WHITE);//设置画板上图像的颜色(二维码的颜色)
		int pixoff=2;//坐标偏移量 
		for (int i = 0; i < codeOut.length; i++) {
			for (int j = 0; j < codeOut.length; j++) {
				if(codeOut[j][i]){
					gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
				}
			}
		}
		//增加logo
		//将硬盘中的src/log.png 加载为一个Image对象
		Image logo=ImageIO.read(new File("src/logo.png"));
		int maxHeight=bufImg.getHeight();
		int maxWidth=bufImg.getWidth();
		
		
		//在已生成的二维码上画logo
		gs.drawImage(logo, imgSize/6*2,imgSize/6*2 , null);
		
		gs.dispose();//释放
		bufImg.flush();//清理
		return bufImg;
	}
	//解密：二维码->文字信息
	public String decoderQRCode(String imgPath) throws Exception{
		//BufferedImage内存中的图片:硬盘中的imgPath图片->内存BufferedImage
		BufferedImage bufImg=ImageIO.read(new File(imgPath));
		//解密
		//QRCodeDeCoder decoder=new QRCodeDecoder();
		QRCodeDecoder decoder = new QRCodeDecoder();
		
		TwoDimensionCodeImage tdcImg = new TwoDimensionCodeImage(bufImg);
		//byte[] bt = decoder.decode(tdcImg);
		
		String  content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");
		return content;
		
	}
}
