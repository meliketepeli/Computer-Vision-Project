package com.opencvproject;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.CvType;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.highgui.HighGui;  
import org.opencv.core.Size;

public class Harris_corner {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
    }

    public static void main(String[] args) {
      
        String imagePath1 = "C:\\central tiff.bmp";  
       
        String imagePath2 = "C:\\left upper.bmp";  

        String imagePath3 = "C:\\waffle.jpg";
        
        String imagePath4 = "C:\\dama.jpg";  

        String imagePath5 = "C:\\mo.jpg";
        
        
        Mat image1 = Imgcodecs.imread(imagePath1, Imgcodecs.IMREAD_GRAYSCALE);
       
        Mat image2 = Imgcodecs.imread(imagePath2, Imgcodecs.IMREAD_GRAYSCALE);
        
        Mat image3 = Imgcodecs.imread(imagePath3, Imgcodecs.IMREAD_GRAYSCALE);

        Mat image4 = Imgcodecs.imread(imagePath4, Imgcodecs.IMREAD_GRAYSCALE);
        
        Mat image5 = Imgcodecs.imread(imagePath5, Imgcodecs.IMREAD_GRAYSCALE);

       
        HighGui.imshow("Loaded Image 1", image1);
        HighGui.waitKey();

        HighGui.imshow("Loaded Image 2", image2);
        HighGui.waitKey();
        
        HighGui.imshow("Loaded Image 3", image3);
        HighGui.waitKey();
        
        HighGui.imshow("Loaded Image 4", image4);
        HighGui.waitKey();
        
        HighGui.imshow("Loaded Image 5", image5);
        HighGui.waitKey();

       
        Mat corners1 = new Mat();
        Imgproc.cornerHarris(image1, corners1, 3, 3, 0.04);

        Mat corners2 = new Mat();
        Imgproc.cornerHarris(image2, corners2, 3, 3, 0.04);

        Mat corners3 = new Mat();
        Imgproc.cornerHarris(image3, corners3, 3, 3, 0.04);
        
        Mat corners4 = new Mat();
        Imgproc.cornerHarris(image4, corners4, 3, 3, 0.04);

        Mat corners5 = new Mat();
        Imgproc.cornerHarris(image5, corners5, 3, 3, 0.04);
        
      
        Core.normalize(corners1, corners1, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);
        Core.normalize(corners2, corners2, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);
        Core.normalize(corners3, corners3, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);
        Core.normalize(corners4, corners4, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);
        Core.normalize(corners5, corners5, 0, 255, Core.NORM_MINMAX, CvType.CV_8U);

        
        for (int j = 0; j < corners1.rows(); j++) {
            for (int i = 0; i < corners1.cols(); i++) {
                if (corners1.get(j, i)[0] > 40) {  
                    Imgproc.circle(image1, new Point(i, j), 5, new Scalar(255, 0, 0), 1);  
                }
            }
        }

        
        for (int j = 0; j < corners2.rows(); j++) {
            for (int i = 0; i < corners2.cols(); i++) {
                if (corners2.get(j, i)[0] > 60) {  
                    Imgproc.circle(image2, new Point(i, j), 5, new Scalar(255, 0, 0), 1);  
                }
            }
        }
        
        for (int j = 0; j < corners3.rows(); j++) {
            for (int i = 0; i < corners3.cols(); i++) {
                if (corners3.get(j, i)[0] > 100) { 
                    Imgproc.circle(image3, new Point(i, j), 5, new Scalar(255, 0, 0), 1);  
                }
            }
        }
        
        for (int j = 0; j < corners4.rows(); j++) {
            for (int i = 0; i < corners4.cols(); i++) {
                if (corners4.get(j, i)[0] > 70) {  
                    Imgproc.circle(image4, new Point(i, j), 5, new Scalar(255, 0, 0), 1);  
                }
            }
        }
        
        for (int j = 0; j < corners5.rows(); j++) {
            for (int i = 0; i < corners5.cols(); i++) {
                if (corners5.get(j, i)[0] > 40) {  
                    Imgproc.circle(image5, new Point(i, j), 5, new Scalar(255, 0, 0), 1);  
                }
            }
        }

       
        HighGui.imshow("Harris Corners Result 1", image1);
        HighGui.waitKey();

        HighGui.imshow("Harris Corners Result 2", image2);
        HighGui.waitKey();
        
        HighGui.imshow("Harris Corners Result 3", image3);
        HighGui.waitKey();
        
        HighGui.imshow("Harris Corners Result 4", image4);
        HighGui.waitKey();
        
        HighGui.imshow("Harris Corners Result 5", image5);
        HighGui.waitKey();


        
        Imgcodecs.imwrite("HarrisCornersOutput1.png", image1);
        Imgcodecs.imwrite("HarrisCornersOutput2.png", image2);
        Imgcodecs.imwrite("HarrisCornersOutput3.png", image3);
        Imgcodecs.imwrite("HarrisCornersOutput4.png", image4);
        Imgcodecs.imwrite("HarrisCornersOutput5.png", image5);
    }
}
