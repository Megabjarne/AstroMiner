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
public class Vector {
    public double x,y;
    public Vector(double _x,double _y){x=_x;y=_y;}
    public Vector add(Vector v){
        return new Vector(x+v.x,y+v.y);}
    public Vector sub(Vector v){
        return new Vector(x-v.x, y-v.y);}
    public Vector mul(double n){ return new Vector(x*n,y*n);}
    public Vector div(double n){return new Vector(x/n,y/n);}
    public Vector norm(){return new Vector(x/length(),y/length());}
    public double length(){return Math.sqrt(x*x+y*y);}
    public double ang(){return Math.atan2(y, x);}
    public String toString(){return "[" + Double.toString(x) + ":" + Double.toString(y) + "]";}
}
