package com.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ZXingUtil {
	//加密：文字->二维码(图片)
	public void encodeImt(String imgPath,String format,String content,int width,int height){//format：gif
		//Map<String,Object> map=new Hashtable<>();
		Hashtable<EncodeHintType, Object> hints=new Hashtable<EncodeHintType, Object>();
		//hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H)
		/*
		 * content:需要加密的文字
		 * BarcodeFormat.QR_CODE:要解析的类型（二维码）
		 * */
	//	BitMatrix bitMatrix=new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width, height);
		
		//内存中的一张图片；此时需要的图片是二维码 ->需要一个boolean[][] ->BitMatrix
		
		//BufferedImage img=xxx();
		
		//String ->File
		File file=new File(imgPath);
		
		//生成图片
	//	ImageIO.write(img, format, file);//format:图片格式
		
	}
}
