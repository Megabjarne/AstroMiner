/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

/**
 *
 * @author Windows User
 */
public class AstroMiner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputParser.ParsedInput p = InputParser.parse("move left -s 10 -r 0");
        for (String s:p.command){
            System.out.println(s);
        }
        for (String key:p.flags.keySet()){
            System.out.println(key + " - " + p.flags.get(key));
        }
    }
    
}
