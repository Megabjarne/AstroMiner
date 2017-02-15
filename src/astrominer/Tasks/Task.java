/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer.Tasks;

/**
 *
 * @author Thomas Sund Mjåland
 */
public abstract class Task {
    protected boolean isDone=false;
    public abstract void doWork();
    public boolean done(){return isDone;}
}
