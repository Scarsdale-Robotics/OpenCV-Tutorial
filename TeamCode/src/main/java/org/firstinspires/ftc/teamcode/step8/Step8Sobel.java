package org.firstinspires.ftc.teamcode.step8;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step8Sobel extends OpenCvPipeline {

    Mat sobelHorizontal = new Mat();
    Mat horizontalEdges = new Mat();

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, input, Imgproc.COLOR_RGBA2GRAY);

        // input: input image
        // sobelHorizontal: output image
        // CvType.CV_16S: the precision/datatype to calculate the result in
        // 1, 0: compute Sobel in the horizontal direction
        // see write-up for further explanation
        Imgproc.Sobel(input, sobelHorizontal, CvType.CV_16S, 1, 0);

        // Takes absolute value and converts back to 8-bit
        Core.convertScaleAbs(sobelHorizontal, horizontalEdges);

        return horizontalEdges;
    }
}
