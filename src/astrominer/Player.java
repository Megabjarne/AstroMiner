/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import java.util.Scanner;

/**
 *
 * @author Thomas Sund Mjåland
 */
public class Player extends Entity {
    Vector position, speed;
    Scanner input = new Scanner(System.in);
    enum TargetingTypes{TARGETRELATIVE,SPACERELATIVE}
    TargetingTypes currentTargetType = TargetingTypes.SPACERELATIVE;
    int targetID=-1;
    
    public Player(){
        position = new Vector(0,0);
        speed = new Vector(0,0);
    }
    @Override
    public Vector getSpeed(){
        return new Vector(0,0);
    }
    @Override
    public Vector getPosition(){
        return new Vector(0,0);
    }
    @Override
    public void gameTick(){
        if (input.hasNextLine()){
            processInput(input.nextLine());
        }
        
    }
    public void processInput(String s){
        InputParser.ParsedInput p = InputParser.parse(s);
        
    }
}
