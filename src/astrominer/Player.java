/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import astrominer.Tasks.Task;
import java.util.ArrayList;

/**
 *
 * @author Thomas Sund Mjåland
 */
public class Player extends Entity {
    Vector position, speed;
    double rotation;
    static InputHandler input = new InputHandler();
    
    enum TargetingTypes{TARGETRELATIVE,SPACERELATIVE}
    TargetingTypes currentTargetType ;
    int targetID=-1;
    Task currentTask=null;
    
    public Player(){
        super();
        currentTargetType = TargetingTypes.SPACERELATIVE;
        position = new Vector(0,0);
        speed = new Vector(0,0);
        addCommands();  //register all player commands
        input.start();
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
        try{
            if (currentTask!=null && !currentTask.done()){
                currentTask.doWork();
            }
        }catch (Exception ex){
            System.out.println("something failed");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
    
    ArrayList<Command> commandRegister=new ArrayList<>();
    public void processInput(String s){
        InputParser.ParsedInput p = InputParser.parse(s);
        if (p==null){return;}
        for (Command c:commandRegister){
            if (c.handle(p)){
                return;
            }
        }
        System.out.println("Unknown command '" + s + "'");
    }
    
    public void addCommands(){
        //magically accelerate/rotate player
        commandRegister.add(new Command(){
            @Override
            public boolean handle(InputParser.ParsedInput p){
                if (p.command.size()==1 && p.command.get(0).equals("move")){
                    if (p.flags.containsKey("r")){
                        rotation += Double.parseDouble(p.flags.get("r"));
                        rotation = ((rotation + Math.PI)%(Math.PI*2))-Math.PI;
                    }
                    if (p.flags.containsKey("s")){
                        speed = speed.norm().mul(Double.parseDouble(p.flags.get("s")));
                    }
                    return true;
                }
                return false;
        }});
        //list all entities
        commandRegister.add(new Command(){
            @Override
            public boolean handle(InputParser.ParsedInput p){
                EntityRegistry e=EntityRegistry.getInstance();
                if (p.command.size()==1){
                    if (p.command.get(0).equals("list")){
                        System.out.println("----- entitylist -----");
                        for (int currID:e.getIDList()){
                            System.out.println(Integer.toHexString(currID) + " - " + e.getEntityByID(currID).getName());
                        }
                        System.out.println("-----  list end  -----");
                        return true;
                    }
                }
                return false;
        }});
        commandRegister.add(new Command(){
            @Override
            public boolean handle(InputParser.ParsedInput p){
                return false;
        }});
        //Terminates program
        commandRegister.add(new Command(){
            @Override
            public boolean handle(InputParser.ParsedInput p){
                if (p.command.size()==1 && p.command.get(0).equals("exit")){
                    System.out.println("Goodbye!");
                    System.exit(0);
                    return true;
                }
                return false;
        }});
    }
}
