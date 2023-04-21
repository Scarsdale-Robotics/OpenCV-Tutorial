package org.firstinspires.ftc.teamcode.step4;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step4CropPipeline extends OpenCvPipeline {
    @Override
    public Mat processFrame(Mat input) {
        int x = 10;
        int y = 5;
        int width = 100;
        int height = 150;

        // x: top left corner x coordinate
        // y: top left corner y coordinate
        // width: roi width
        // height: roi height
        Rect crop = new Rect(x, y, width, height);
        Mat cropped = input.submat(crop);

        // Do stuff with cropped, maybe

        return cropped;
    }
}
