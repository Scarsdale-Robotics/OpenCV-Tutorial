package org.firstinspires.ftc.teamcode.step8;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step8Canny extends OpenCvPipeline {

    Mat cannyResult = new Mat();
    public int lower = 100;
    public int higher = 200;

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGBA2GRAY);

        // input: input image
        // cannyResult: output image
        // lower: lower threshold
        // higher: higher threshold
        Imgproc.Canny(input, cannyResult, lower, higher);

        return cannyResult;
    }
}
