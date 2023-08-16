package org.firstinspires.ftc.teamcode.MechanumDrive.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Disabled
@TeleOp(name="MechanumDriveTeleO")
public class MechanumDriveTeleOp extends LinearOpMode {
    private final String FRONT_LEFT_CONFIG_NAME = "frontLeftMotor";
    private final String FRONT_RIGHT_CONFIG_NAME = "frontRightMotor";
    private final String REAR_LEFT_CONFIG_NAME = "rearLeftMotor";
    private final String REAR_RIGHT_CONFIG_NAME = "rearRightMotor";

    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get(FRONT_LEFT_CONFIG_NAME);
        DcMotor rearLeftMotor = hardwareMap.dcMotor.get(REAR_LEFT_CONFIG_NAME);
        DcMotor frontRightMotor = hardwareMap.dcMotor.get(FRONT_RIGHT_CONFIG_NAME);
        DcMotor rearRightMotor = hardwareMap.dcMotor.get(REAR_RIGHT_CONFIG_NAME);

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            rearLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            rearRightMotor.setPower(backRightPower);
        }
    }
}
