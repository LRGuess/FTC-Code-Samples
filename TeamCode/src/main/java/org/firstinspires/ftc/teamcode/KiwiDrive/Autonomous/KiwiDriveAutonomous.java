package org.firstinspires.ftc.teamcode.KiwiDrive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.KiwiDrive.BaseMovment.KiwiDriveCommands;

@Disabled
@Autonomous(name="KiwiDriveAutonomous")
public class KiwiDriveAutonomous extends LinearOpMode {

    private final String FRONT_LEFT_MOTOR_CONFIG_NAME = "frontLeftMotor";
    private final String FRONT_RIGHT_MOTOR_CONFIG_NAME = "frontRightMotor";
    private final String REAR_MOTOR_CONFIG_NAME = "rearMotor";

    //region final parameters (DO NOT CHANGE)
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor rearMotor;
    private final KiwiDriveCommands driveCommands = new KiwiDriveCommands(frontLeftMotor, frontRightMotor, rearMotor);

    //endregion

    @Override
    public void runOpMode(){
        frontLeftMotor = hardwareMap.get(DcMotor.class, FRONT_LEFT_MOTOR_CONFIG_NAME);
        frontRightMotor = hardwareMap.get(DcMotor.class, FRONT_RIGHT_MOTOR_CONFIG_NAME);
        rearMotor = hardwareMap.get(DcMotor.class, REAR_MOTOR_CONFIG_NAME);

        //example

        //move forwards
        driveCommands.moveForward(1200);
        while (frontLeftMotor.isBusy() && opModeIsActive()) {idle();}

        //after moving forwards, turn left
        driveCommands.rotateLeft(400);
        //have to use rightMotor, because when turning only the right motor runs
        while (frontRightMotor.isBusy() && opModeIsActive()) {idle();}

        //after turning left, move backwards
        driveCommands.moveBackward(9000);
        while (frontLeftMotor.isBusy() && opModeIsActive()) {idle();}
    }
}
