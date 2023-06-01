package org.firstinspires.ftc.teamcode.step8;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step8Canny extends OpenCvPipeline {

    Mat cannyResult = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGBA2GRAY);

        // input: input image
        // cannyResult: output image
        // 100: lower threshold
        // 200: higher threshold
        Imgproc.Canny(input, cannyResult, 100, 200);

        return cannyResult;
    }
}
