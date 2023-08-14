package org.firstinspires.ftc.teamcode.Utils.Exeptions;

public class NonApplicableExeption extends Exception{
    public NonApplicableExeption(){
        super("You cannot use TurnLeft or TurnRight with kiwi drive");
    }
}
