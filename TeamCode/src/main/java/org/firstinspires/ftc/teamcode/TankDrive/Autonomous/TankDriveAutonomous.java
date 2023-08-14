package org.firstinspires.ftc.teamcode.TankDrive.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.TankDrive.BaseMovment.TankDriveCommands;

@Autonomous(name="TankDriveAutonomous")
public class TankDriveAutonomous extends LinearOpMode {

    private final String LEFT_MOTOR_CONFIG_NAME = "leftMotor";
    private final String RIGHT_MOTOR_CONFIG_NAME = "rightMotor";

    //region final parameters (DO NOT CHANGE)
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private final TankDriveCommands driveCommands = new TankDriveCommands(leftMotor, rightMotor);

    //endregion

    @Override
    public void runOpMode(){
        leftMotor = hardwareMap.get(DcMotor.class, LEFT_MOTOR_CONFIG_NAME);
        rightMotor = hardwareMap.get(DcMotor.class, RIGHT_MOTOR_CONFIG_NAME);

        //example

        //move forwards
        driveCommands.moveForward(1200);
        while (leftMotor.isBusy() && opModeIsActive()) {idle();}

        //after moving forwards, turn left
        driveCommands.turnLeft(400);
        //have to use rightMotor, because when turning only the right motor runs
        while (rightMotor.isBusy() && opModeIsActive()) {idle();}

        //after turning left, move backwards
        driveCommands.moveBackward(9000);
        while (leftMotor.isBusy() && opModeIsActive()) {idle();}
    }
}
