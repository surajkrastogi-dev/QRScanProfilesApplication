package com.example.QRProfilesApplication.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QrCodeService {

	 public byte[] generateQrCode(String text, int width, int height) throws Exception {
	        QRCodeWriter writer = new QRCodeWriter();
	        BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);

	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        MatrixToImageWriter.writeToStream(matrix, "PNG", os);
	        return os.toByteArray();
	    }

	 //profileUrl - text
	    public String generateQrBase64(String text, int width, int height) throws Exception {
	        byte[] bytes = generateQrCode(text, width, height);
	        return Base64.getEncoder().encodeToString(bytes);
	    }
}

