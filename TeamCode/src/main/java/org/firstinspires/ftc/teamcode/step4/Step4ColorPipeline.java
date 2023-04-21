package org.firstinspires.ftc.teamcode.step4;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step4ColorPipeline extends OpenCvPipeline {
    Mat output = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, output, Imgproc.COLOR_RGB2HSV);

        return output;
    }
}
