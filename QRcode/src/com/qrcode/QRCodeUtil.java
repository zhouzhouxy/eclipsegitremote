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
	//���ܣ�������Ϣ->��ά��
	/*
	 * content:������Ϣ
	 * */
	public void encoderQRCode(String content,String imgPath,String imgType,int size)throws Exception{
		//BufferedImage���ڴ��е�һ��ͼƬ
		BufferedImage bufImg=qRcodeCommon( content, imgPath, size);
		
		File file=new File(imgPath);//src/��ά��.png  --->��ά�롣png 
		ImageIO.write(bufImg, imgType, file);
	}
	//����һ����ά���BufferedImage
	/*
	 * content:�����������ص���Ϣ
	 * imgType:ͼƬ��ʽ
	 * size:��ά��߳�
	 * */
	private BufferedImage qRcodeCommon(String content,String imageType,int size)throws Exception{
		BufferedImage bufImg=null;
		//QrCode�����ַ���->boolean[][]
		Qrcode qrcodeHandler=new Qrcode();
		//���ö�ά����Ŵ��ʣ�7% L<M<Q<H 30% :�Ŵ���Խ�ߣ��ɴ洢����ϢԽ�٣����ǶԶ�ά������Ҫ���С
		qrcodeHandler.setQrcodeErrorCorrect('M');
		//�ɴ�ŵ���Ϣ���ͣ�N:���֡�A:����+A-Z B������
		qrcodeHandler.setQrcodeEncodeMode('B');
		//�ߴ�:ȡֵ��Χ��1-40
		qrcodeHandler.setQrcodeVersion(size);
		byte[] contentBytes=content.getBytes();//��Hello world�� ->byte[] helloworld
		//-->boolean[][]
		boolean[][] codeOut=qrcodeHandler.calQrcode(contentBytes);
		int imgSize=67+12*(size-1);
		//BufferedImage���ڴ��е�ͼƬ
		bufImg=new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
		//����һ������
		Graphics2D gs=bufImg.createGraphics();
		gs.setBackground(Color.WHITE);//������ı���ɫ����Ϊ��ɫ
		gs.clearRect(0, 0, size, size);//��ʼ��
		gs.setColor(Color.WHITE);//���û�����ͼ�����ɫ(��ά�����ɫ)
		int pixoff=2;//����ƫ���� 
		for (int i = 0; i < codeOut.length; i++) {
			for (int j = 0; j < codeOut.length; j++) {
				if(codeOut[j][i]){
					gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
				}
			}
		}
		//����logo
		//��Ӳ���е�src/log.png ����Ϊһ��Image����
		Image logo=ImageIO.read(new File("src/logo.png"));
		int maxHeight=bufImg.getHeight();
		int maxWidth=bufImg.getWidth();
		
		
		//�������ɵĶ�ά���ϻ�logo
		gs.drawImage(logo, imgSize/6*2,imgSize/6*2 , null);
		
		gs.dispose();//�ͷ�
		bufImg.flush();//����
		return bufImg;
	}
	//���ܣ���ά��->������Ϣ
	public String decoderQRCode(String imgPath) throws Exception{
		//BufferedImage�ڴ��е�ͼƬ:Ӳ���е�imgPathͼƬ->�ڴ�BufferedImage
		BufferedImage bufImg=ImageIO.read(new File(imgPath));
		//����
		//QRCodeDeCoder decoder=new QRCodeDecoder();
		QRCodeDecoder decoder = new QRCodeDecoder();
		
		TwoDimensionCodeImage tdcImg = new TwoDimensionCodeImage(bufImg);
		//byte[] bt = decoder.decode(tdcImg);
		
		String  content = new String(decoder.decode(new TwoDimensionCodeImage(bufImg)), "utf-8");
		return content;
		
	}
}
