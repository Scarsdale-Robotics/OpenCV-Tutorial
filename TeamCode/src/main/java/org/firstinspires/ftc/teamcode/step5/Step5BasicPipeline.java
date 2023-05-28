package org.firstinspires.ftc.teamcode.step5;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step5BasicPipeline extends OpenCvPipeline {
    Mat mask = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGB2GRAY);

        // input: input
        // mask: the output mask
        // 200: the threshold value
        // 255: the maximum value a pixel can be (necessary argument)
        // Imgproc.THRESH_BINARY: specifies that pixels that pass the threshold
        // should be white and pixels that don't should be black
        Imgproc.threshold(input, mask, 200, 255, Imgproc.THRESH_BINARY);

        return mask;
    }
}
