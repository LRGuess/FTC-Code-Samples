package org.firstinspires.ftc.teamcode.KiwiDrive.BaseMovment;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Utils.BaseMovement;

public class KiwiDriveCommands implements BaseMovement {
    private DcMotor FrontRightMotor;
    private DcMotor FrontLeftMotor;
    private DcMotor RearMotor;
    public KiwiDriveCommands(DcMotor FrontLeftMotor, DcMotor FrontRightMotor, DcMotor RearMotor) {
        this.FrontLeftMotor = FrontLeftMotor;
        this.FrontRightMotor = FrontRightMotor;
        this.RearMotor = RearMotor;
    }
    @Override
    public void moveForward(int ticks) {
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(-ticks);
        FrontLeftMotor.setTargetPosition(ticks);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void moveBackward(int ticks){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(ticks);
        FrontLeftMotor.setTargetPosition(-ticks);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void rotateLeft(int ticks){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        RearMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(ticks);
        FrontLeftMotor.setTargetPosition(ticks);
        RearMotor.setTargetPosition(ticks);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void rotateRight(int ticks){
        FrontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        RearMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor.setTargetPosition(-ticks);
        FrontLeftMotor.setTargetPosition(-ticks);
        RearMotor.setTargetPosition(-ticks);

        FrontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RearMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void turnLeft(int ticks){

    }
}
