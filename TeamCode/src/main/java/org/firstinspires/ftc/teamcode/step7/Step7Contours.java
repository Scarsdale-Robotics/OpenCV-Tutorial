package org.firstinspires.ftc.teamcode.step7;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class Step7Contours extends OpenCvPipeline {
    public Scalar upper = new Scalar(17, 255, 255);
    public Scalar lower = new Scalar(4, 116, 80);

    Mat kernel = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_ELLIPSE, new Size(4, 4));

    Mat result = new Mat();

    List<MatOfPoint> contours = new ArrayList<>();
    Mat hierarchy = new Mat();

    public Scalar contColor = new Scalar(255, 0, 0);

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, result, Imgproc.COLOR_RGB2HSV);
        Core.inRange(result, lower, upper, result);
        Imgproc.morphologyEx(result, result, Imgproc.MORPH_OPEN, kernel);

        // result: the input image
        // contours: the list to store the contours in
        // hierarchy: the mat to store information about which contours are contained by others
        // Imgproc.RETR_EXTERNAL: tells OpenCV to only return the outermost contours
        // Imgproc.CHAIN_APPROX_SIMPLE: tells OpenCV to return approximate contours to save memory
        Imgproc.findContours(result, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        // convert to RGB so we can draw with colors
        Imgproc.cvtColor(result, result, Imgproc.COLOR_GRAY2RGB);

        // result: the image to draw on
        // contours: the contours to draw
        // -1: the index of the contour to draw. -1 means draw all of them.
        // contColor: the color to draw the contours in
        Imgproc.drawContours(result, contours, -1, contColor);

        // clear list so it can be reused next frame
        contours.clear();

        return result;
    }
}
