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
	//���ܣ�����->��ά��(ͼƬ)
	public void encodeImt(String imgPath,String format,String content,int width,int height){//format��gif
		//Map<String,Object> map=new Hashtable<>();
		Hashtable<EncodeHintType, Object> hints=new Hashtable<EncodeHintType, Object>();
		//hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H)
		/*
		 * content:��Ҫ���ܵ�����
		 * BarcodeFormat.QR_CODE:Ҫ���������ͣ���ά�룩
		 * */
	//	BitMatrix bitMatrix=new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width, height);
		
		//�ڴ��е�һ��ͼƬ����ʱ��Ҫ��ͼƬ�Ƕ�ά�� ->��Ҫһ��boolean[][] ->BitMatrix
		
		//BufferedImage img=xxx();
		
		//String ->File
		File file=new File(imgPath);
		
		//����ͼƬ
	//	ImageIO.write(img, format, file);//format:ͼƬ��ʽ
		
	}
}
