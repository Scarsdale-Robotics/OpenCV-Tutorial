package org.firstinspires.ftc.teamcode.step4;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step4ResizePipeline extends OpenCvPipeline {
    Mat resizedToWidthHeight = new Mat();
    Mat resizedWithMultiplier = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        int width = 100;
        int height = 100;
        Imgproc.resize(input, resizedToWidthHeight, new Size(width, height));

        double xMult = 2;
        double yMult = 0.5;
        Imgproc.resize(input, resizedWithMultiplier, new Size(0, 0), xMult, yMult);

        return resizedToWidthHeight;
    }
}
