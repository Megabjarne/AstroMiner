/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import java.io.IOException;

/**
 *
 * @author Windows User
 */
public class AstroMiner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Player player = new Player();
        while (true){
            player.gameTick();
            System.out.println(player.getPosition().toString());
            try{Thread.sleep(500);}catch(Exception ex){System.out.println("fail");}
            if (player.input.hasInput()){
                System.out.println(Player.input.getInput());
            }
        }
    }
    
}
