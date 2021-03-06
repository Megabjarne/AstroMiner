/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

/**
 *
 * @author Thomas Sund Mjåland
 */
public abstract class Entity {
    private int ID;
    protected Entity(){ID=EntityRegistry.getID();EntityRegistry.getInstance().register(this);}
    protected int getID(){return ID;};
    public abstract Vector getPosition();
    public abstract Vector getSpeed();
    public abstract void gameTick();
    public String getName(){return "Unnamed entity";}
}
