package AndroidUI.Base;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;

public class CommonUtilsUI {

    private static String decodeQRCode(BufferedImage qrCodeImage) {
        Result result = null;
        try {
            LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            result = new MultiFormatReader().decode(bitmap);
        } catch (NotFoundException e) {
        }
        return result.getText();
    }
}
