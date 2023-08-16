package org.firstinspires.ftc.teamcode.MechanumDrive.Autonomous;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Camera.AprilTag.AprilTagDetectionPipeline;
import org.firstinspires.ftc.teamcode.MechanumDrive.BaseMovement.MechanumDriveCommands;
import org.firstinspires.ftc.teamcode.TankDrive.BaseMovment.TankDriveCommands;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;
@Disabled
@Autonomous(name="MechanumDriveAutonomousAprilTag")
public class MechanumDriveAutonomousAprilTag extends LinearOpMode {
    //region CameraSpecs(CHANGE LENS INTRINSICS)
    private OpenCvCamera camera;
    private static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    private final double fx = 578.272;
    private final double fy = 578.272;
    private final double cx = 402.145;
    private final double cy = 221.506;

    //endregion

    //region TagSpecs(SET TAG SPECS)
    // UNITS ARE METERS
    private double tagsize = 0.166;
    private AprilTagDetection tagOfInterest = null;
    private final byte TAG_1 = 1;
    private final byte TAG_2 = 2;
    private final byte TAG_3 = 3;

    //endregion(SET TAG SPECS)

    private final String FRONT_LEFT_CONFIG_NAME = "frontLeftMotor";
    private final String FRONT_RIGHT_CONFIG_NAME = "frontRightMotor";
    private final String REAR_LEFT_CONFIG_NAME = "rearLeftMotor";
    private final String REAR_RIGHT_CONFIG_NAME = "rearRightMotor";
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor rearLeftMotor;
    private DcMotor rearRightMotor;
    private final MechanumDriveCommands driveCommands = new MechanumDriveCommands(frontLeftMotor, frontRightMotor, rearLeftMotor, rearRightMotor);

    @Override
    public void runOpMode()
    {
        frontLeftMotor = hardwareMap.dcMotor.get(FRONT_LEFT_CONFIG_NAME);
        rearLeftMotor = hardwareMap.dcMotor.get(REAR_LEFT_CONFIG_NAME);
        frontRightMotor = hardwareMap.dcMotor.get(FRONT_RIGHT_CONFIG_NAME);
        rearRightMotor = hardwareMap.dcMotor.get(REAR_RIGHT_CONFIG_NAME);


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        AprilTagDetectionPipeline aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        telemetry.setMsTransmissionInterval(50);

        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == TAG_1 || tag.id == TAG_2 || tag.id == TAG_3)
                    {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }

        /*
         * The START command just came in: now work off the latest snapshot acquired
         * during the init loop.
         */

        /* Update the telemetry */
        if(tagOfInterest != null)
        {
            telemetry.addLine("Tag snapshot:\n");
            tagToTelemetry(tagOfInterest);
            telemetry.update();
        }
        else
        {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }

        /* Actually do something useful */
        if(tagOfInterest == null)
        {
            //If no tag of interest is seen, do:
        }
        else
        {
            telemetry.addData("Tag of ",tagOfInterest);

            if(tagOfInterest.id == TAG_1)
            {
                //If first tag seen, do:
            }
            else if(tagOfInterest.id == TAG_2)
            {
                //If second tag seen, do:
            }
            else if(tagOfInterest.id == TAG_3)
            {
                //If third tag seen, do:
            }
        }
    }

    @SuppressLint("DefaultLocale")
    void tagToTelemetry(AprilTagDetection detection)
    {
        Orientation rot = Orientation.getOrientation(detection.pose.R, AxesReference.INTRINSIC, AxesOrder.YXZ, AngleUnit.DEGREES);

        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", rot.firstAngle));
        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", rot.secondAngle));
        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", rot.thirdAngle));
    }
}
