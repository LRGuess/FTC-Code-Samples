package org.firstinspires.ftc.teamcode.MechanumDrive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MechanumDrive.BaseMovement.MechanumDriveCommands;
import org.firstinspires.ftc.teamcode.TankDrive.BaseMovment.TankDriveCommands;

@Autonomous(name="MechanumDriveAutonomous")
public class MechanumDriveAutonomous extends LinearOpMode {

    private final String FRONT_LEFT_CONFIG_NAME = "frontLeftMotor";
    private final String FRONT_RIGHT_CONFIG_NAME = "frontRightMotor";
    private final String REAR_LEFT_CONFIG_NAME = "rearLeftMotor";
    private final String REAR_RIGHT_CONFIG_NAME = "rearRightMotor";

    //region final parameters DO NOT CHANGE
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor rearLeftMotor;
    private DcMotor rearRightMotor;
    private final MechanumDriveCommands driveCommands = new MechanumDriveCommands(frontLeftMotor, frontRightMotor, rearLeftMotor, rearRightMotor);
    //endregion

    @Override
    public void runOpMode(){
        frontLeftMotor = hardwareMap.dcMotor.get(FRONT_LEFT_CONFIG_NAME);
        rearLeftMotor = hardwareMap.dcMotor.get(REAR_LEFT_CONFIG_NAME);
        frontRightMotor = hardwareMap.dcMotor.get(FRONT_RIGHT_CONFIG_NAME);
        rearRightMotor = hardwareMap.dcMotor.get(REAR_RIGHT_CONFIG_NAME);

        //example

        //move forwards
        driveCommands.moveForward(1200);
        while (frontLeftMotor.isBusy() && opModeIsActive()) {idle();}

        //after moving forwards, turn left
        driveCommands.rotateLeft(400);
        //have to use rightMotor, because when turning only the right motor runs
        while (frontLeftMotor.isBusy() && opModeIsActive()) {idle();}

        //after turning left, move backwards
        driveCommands.moveBackward(9000);
        while (frontLeftMotor.isBusy() && opModeIsActive()) {idle();}
    }
}
