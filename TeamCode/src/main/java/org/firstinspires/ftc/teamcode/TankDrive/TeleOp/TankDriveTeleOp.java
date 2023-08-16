package org.firstinspires.ftc.teamcode.TankDrive.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@Disabled
@TeleOp(name="TankDrive")
public class TankDriveTeleOp extends LinearOpMode{
    private final String LEFT_MOTOR_CONFIG_NAME = "leftMotor";
    private final String RIGHT_MOTOR_CONFIG_NAME = "rightMotor";
    @Override
    public void runOpMode(){
        DcMotor leftMotor = hardwareMap.get(DcMotor.class, LEFT_MOTOR_CONFIG_NAME);
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, RIGHT_MOTOR_CONFIG_NAME);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            leftMotor.setPower(gamepad1.left_stick_y);
            rightMotor.setPower(gamepad1.right_stick_y);
        }
    }
}
