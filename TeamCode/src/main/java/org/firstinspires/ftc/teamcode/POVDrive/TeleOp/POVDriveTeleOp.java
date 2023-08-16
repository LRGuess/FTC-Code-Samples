package org.firstinspires.ftc.teamcode.POVDrive.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@TeleOp(name="POVDriveTeleOp")
public class POVDriveTeleOp extends LinearOpMode {
    private final String LEFT_MOTOR_CONFIG_NAME = "leftMotor";
    private final String RIGHT_MOTOR_CONFIG_NAME = "rightMotor";

    @Override
    public void runOpMode(){
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, LEFT_MOTOR_CONFIG_NAME);
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, RIGHT_MOTOR_CONFIG_NAME);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double drivePower = gamepad1.left_stick_y;
            double turnPower = gamepad1.right_stick_x;

            if (Math.abs(turnPower) > 0.1) {
                rightMotor.setPower(drivePower - turnPower);
                leftMotor.setPower(drivePower + turnPower);
            } else {
                rightMotor.setPower(drivePower);
                leftMotor.setPower(drivePower);
            }
        }
    }
}
