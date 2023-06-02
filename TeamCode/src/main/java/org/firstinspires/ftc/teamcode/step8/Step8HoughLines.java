package org.firstinspires.ftc.teamcode.step8;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class Step8HoughLines extends OpenCvPipeline {

    Mat gray = new Mat();
    Mat cannyResult = new Mat();
    Mat linesResult = new Mat();

    // Fine grained resolution
    public double rho = 1;
    // Find lines at every degree
    public double theta = Math.PI / 180;
    // Need 5 "votes" to be considered a line
    public int threshold = 10;
    public double minLineLength = 40;
    public double maxLineGap = 6;

    public Scalar lineColor = new Scalar(0, 0, 255);
    public int lineThickness = 2;

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, gray, Imgproc.COLOR_RGBA2GRAY);
        Imgproc.Canny(gray, cannyResult, 100, 200);

        // cannyResult: input image
        // linesResult: output image
        // rho: "resolution," not really sure how it works tbh
        // theta: angle interval, in radians, at which to look for lines
        // threshold: "votes" needed to be considered a line, higher = stronger line
        // minLineLength: minimum line length in pixels
        // maxLineGap: maximum gap in pixels between lines for HoughLines to merge them
        Imgproc.HoughLinesP(cannyResult, linesResult, rho, theta, threshold, minLineLength, maxLineGap);

        for (int i = 0; i < linesResult.rows(); i++) {
            double[] val = linesResult.get(i, 0);
            Imgproc.line(input, new Point(val[0], val[1]), new Point(val[2], val[3]), lineColor, lineThickness);
        }

        return input;
    }
}
