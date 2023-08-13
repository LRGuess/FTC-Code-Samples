package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MotorTest")
public class MotorTesting extends LinearOpMode{

    private final String motorNameInConfig = "testMotor";

    @Override
    public void runOpMode(){
        DcMotor motorToTest = hardwareMap.get(DcMotor.class, motorNameInConfig);

        while (true){
            motorToTest.setPower(gamepad1.left_stick_y);
        }
    }
}
