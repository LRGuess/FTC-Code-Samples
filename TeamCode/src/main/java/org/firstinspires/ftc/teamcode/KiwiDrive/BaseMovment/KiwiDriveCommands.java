package org.firstinspires.ftc.teamcode.KiwiDrive.BaseMovment;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class KiwiDriveCommands {
    private DcMotor FrontRightMotor;
    private DcMotor FrontLeftMotor;
    private DcMotor RearMotor;
    public KiwiDriveCommands(DcMotor FrontLeftMotor, DcMotor FrontRightMotor, DcMotor RearMotor) {
        this.FrontLeftMotor = FrontLeftMotor;
        this.FrontRightMotor = FrontRightMotor;
        this.RearMotor = RearMotor;
    }

    public void moveForward(int distance) {
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(-distance);
        FrontLeftMotor.setTargetPosition(distance);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void moveBackwards(int distance){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(distance);
        FrontLeftMotor.setTargetPosition(-distance);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void rotateLeft(int degrees){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        RearMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(degrees);
        FrontLeftMotor.setTargetPosition(degrees);
        RearMotor.setTargetPosition(degrees);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void rotateRight(int degrees){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        RearMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(-degrees);
        FrontLeftMotor.setTargetPosition(-degrees);
        RearMotor.setTargetPosition(-degrees);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
