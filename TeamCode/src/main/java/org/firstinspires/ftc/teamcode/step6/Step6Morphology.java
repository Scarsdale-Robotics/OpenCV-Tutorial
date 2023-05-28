package org.firstinspires.ftc.teamcode.step6;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step6Morphology extends OpenCvPipeline {
    Mat mask = new Mat();
    Mat result = new Mat();
    // 3x3 rectangle
    Mat kernel = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(3, 3));

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGB2GRAY);
        Imgproc.threshold(input, mask, 200, 255, Imgproc.THRESH_BINARY);

        // mask: input
        // result: output
        // Imgproc.MORPH_DILATE: morphological operation
        // kernel: shape of filter
        Imgproc.morphologyEx(mask, result, Imgproc.MORPH_DILATE, kernel);

        return result;
    }
}
