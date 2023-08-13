package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="ServoTest")
public class ServoTesting extends LinearOpMode {
    private final String servoNameInConfig = "testServo";
    private final byte minServoRotation = 0;
    private final byte maxServoRotation = 1;

    @Override
    public void runOpMode(){
        Servo servoToTest = hardwareMap.get(Servo.class, servoNameInConfig);

        while (true){
            if (gamepad1.y) servoToTest.setPosition(maxServoRotation);
            if (gamepad1.a) servoToTest.setPosition(minServoRotation);
        }
    }
}
