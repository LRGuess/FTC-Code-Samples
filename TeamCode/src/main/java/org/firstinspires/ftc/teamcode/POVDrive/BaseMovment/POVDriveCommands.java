package org.firstinspires.ftc.teamcode.POVDrive.BaseMovment;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Utils.BaseMovement;

public class POVDriveCommands implements BaseMovement {

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    public POVDriveCommands (DcMotor leftMotor, DcMotor rightMotor){
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }
    @Override
    public void moveForward(int ticks) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setTargetPosition(ticks);
        rightMotor.setTargetPosition(ticks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void moveBackward(int ticks) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setTargetPosition(-ticks);
        rightMotor.setTargetPosition(-ticks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void turnLeft(int ticks) {
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        rightMotor.setTargetPosition(ticks);

        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void turnRight(int ticks) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setTargetPosition(ticks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void rotateLeft(int ticks) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setTargetPosition(-ticks);
        rightMotor.setTargetPosition(ticks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void rotateRight(int ticks) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotor.setTargetPosition(ticks);
        rightMotor.setTargetPosition(-ticks);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
