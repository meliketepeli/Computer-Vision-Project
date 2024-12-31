package com.opencvproject;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.SIFT;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class SIFT {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // OpenCV kütüphanesini yükle
    }

    public static void main(String[] args) {
        // Resmin yolu (central tiff.bmp)
        String imagePath = "C:\\central tiff.bmp"; // Yolu doğru şekilde belirtin

        // Resmi yükle ve gri tonlamaya çevir
        Mat image = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);

        // SIFT algorimasını başlat
        SIFT sift = SIFT.create();  // SIFT create() yöntemiyle oluşturulur

        // Anahtar noktalarını tespit et
        MatOfKeyPoint keyPoints = new MatOfKeyPoint();
        sift.detect(image, keyPoints);  // detect() ile anahtar noktaları tespit edilir

        // Sonuçları görselleştir
        Mat outputImage = image.clone();
        for (org.opencv.features2d.KeyPoint kp : keyPoints.toList()) {
            // Anahtar noktaları üzerine işaretleme yap
            Imgproc.circle(outputImage, kp.pt, 5, new Scalar(0, 255, 0), 2);  // Anahtar noktaları yeşil ile işaretle
        }

        // Sonuçları görüntüle
        HighGui.imshow("SIFT Features", outputImage);
        HighGui.waitKey();

        // Sonucu kaydet
        Imgcodecs.imwrite("SIFTResult.png", outputImage);
    }
}
