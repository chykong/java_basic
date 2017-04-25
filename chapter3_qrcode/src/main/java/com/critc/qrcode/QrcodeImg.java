package com.critc.qrcode;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

public class QrcodeImg implements QRCodeImage {
	BufferedImage bufImg;

	public QrcodeImg(BufferedImage bufImg) {
		this.bufImg = bufImg;
	}

	@Override
	public int getHeight() {
		return bufImg.getHeight();
	}

	@Override
	public int getPixel(int x, int y) {
		return bufImg.getRGB(x, y);
	}

	@Override
	public int getWidth() {
		return bufImg.getWidth();
	}

}
