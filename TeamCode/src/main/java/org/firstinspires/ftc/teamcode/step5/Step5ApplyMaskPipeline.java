package org.firstinspires.ftc.teamcode.step5;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step5ApplyMaskPipeline extends OpenCvPipeline {
    Mat mask = new Mat();
    Mat ret = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(input, mask, 200, 255, Imgproc.THRESH_BINARY);
        Core.bitwise_and(input, mask, ret);

        return ret;
    }
}
