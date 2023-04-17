package org.firstinspires.ftc.teamcode.step3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.step3.pipelines.Step3Pipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous
public class Step3OpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        // Black magic (check official docs if you want to know what this actually does)
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                // 320x240 is the resolution. You can change the rotation if your phone is mounted weirdly.
                camera.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
            }
        });

        // Make the camera process frames using the pipeline you just wrote
        camera.setPipeline(new Step3Pipeline());

        while(opModeIsActive()) {
            // Do some stuff during your program
        }

        // Stop everything
        camera.closeCameraDevice();
    }
}
