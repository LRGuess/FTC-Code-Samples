package org.firstinspires.ftc.teamcode.KiwiDrive.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp-Kiwi")
public class KiwiDriveTeleOp extends LinearOpMode{

    double leftStickXValue;
    double leftStickYValue;
    double rightStickXValue;
    double motorOnePower;
    double motorTwoPower;
    double motorThreePower;
    double maxPower;

    @Override
    public void runOpMode(){

        DcMotor motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        DcMotor motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        DcMotor motorR = hardwareMap.get(DcMotor.class, "motorR");
        DcMotor viperSlideMotor = hardwareMap.get(DcMotor.class, "viperSlideMotor");
        Servo armServo = hardwareMap.get(Servo.class, "armServo");
        Servo handServo = hardwareMap.get(Servo.class, "handServo");

        telemetry.update();
        waitForStart();
        if (opModeInInit()){
            viperSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            viperSlideMotor.setDirection(DcMotorSimple.Direction.FORWARD);
            armServo.setDirection(Servo.Direction.FORWARD);
            handServo.setDirection(Servo.Direction.FORWARD);
        }

        while (opModeIsActive()){
            leftStickXValue = this.gamepad1.left_stick_x;
            leftStickYValue = this.gamepad1.left_stick_y;
            rightStickXValue = this.gamepad1.right_stick_x;

            motorOnePower = -leftStickXValue;
            motorTwoPower = leftStickXValue / 2;
            motorThreePower = leftStickXValue / 2;

            leftStickYValue = leftStickYValue * (Math.sqrt(3) / 2);
            motorTwoPower += -(leftStickYValue);
            motorThreePower += leftStickYValue;

            motorOnePower += -rightStickXValue;
            motorTwoPower += -rightStickXValue;
            motorThreePower += -rightStickXValue;

            if (Math.abs(motorOnePower) > 1 || Math.abs(motorTwoPower) > 1 || Math.abs(motorThreePower) > 1){
                maxPower = FindAbsoluteMax(motorOnePower, motorTwoPower, motorThreePower);
                motorOnePower /= maxPower;
                motorTwoPower /= maxPower;
                motorThreePower /= maxPower;
            }
            motorFL.setPower(motorOnePower / 1.8);
            motorFR.setPower(motorTwoPower / 1.8);
            motorR.setPower(motorThreePower / 1.8);

        }
    }

    double FindAbsoluteMax(double power1, double power2, double power3){
        double max;
        max = Math.max(Math.abs(power1), Math.abs(power2));
        max = Math.max(max, Math.abs(power3));
        return max;
    }
}
