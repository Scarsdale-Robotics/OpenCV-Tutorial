package org.firstinspires.ftc.teamcode.step5;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step5ColorRGBPipeline extends OpenCvPipeline {
    // Public variables so we can tune them in the simulator
    public Scalar upper = new Scalar(255, 255, 255);
    public Scalar lower = new Scalar(0, 0, 0);

    Mat result = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        // Convert to RGB so we don't have to specify alpha in upper and lower
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGBA2RGB);
        Core.inRange(input, lower, upper, result);

        return result;
    }
}
