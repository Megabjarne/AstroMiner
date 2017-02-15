/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import java.util.ArrayList;

/**
 *
 * @author Thomas Sund Mjåland
 */
public class EntityRegistry {
    ArrayList<Entity> entityList=new ArrayList<>();
    private static int currentHighestID=0;
    private static final EntityRegistry instance = new EntityRegistry();
    public static final EntityRegistry getInstance(){return instance;}
    public static int getID(){
        currentHighestID++;
        return currentHighestID;
    }
    public Entity getEntityByID(int ID){
        for (Entity e:entityList){
            if (e.getID()==ID){
                return e;
            }
        }
        return null;
    }
    public ArrayList<Entity> getWithin(Vector position, double radius){
        ArrayList<Entity> retList = new ArrayList<>();
        for (Entity e : entityList){
            if (e.getPosition().sub(position).length()<=radius){
                retList.add(e);
            }
        }
        return retList;
    }
    public int[] getIDList(){
        int retList[] = new int[entityList.size()];
        for (int i=0;i<entityList.size();i++){
            retList[i]=entityList.get(i).getID();
        }
        return retList;
    }
}
