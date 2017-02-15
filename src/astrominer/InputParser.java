/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Thomas Sund Mjåland
 */
public class InputParser {
    public static ParsedInput parse(String s){
        ParsedInput retPut = new ParsedInput();
        String parts[] = s.split(" ");
        int i=0;
        while (i<parts.length && parts[i].charAt(0)!='-'){
            retPut.command.add(parts[i]);
            i++;
        }
        while (i<parts.length){
            String flag = parts[i].substring(1);
            i++;
            String flagString="";
            while (i<parts.length && parts[i].charAt(0)!='-'){
                flagString += parts[i];
                i++;
            }
            retPut.flags.put(flag, flagString);
        }
        return retPut;
    }
    private static boolean isFlag(String s){
        return s.charAt(0)=='-';
    }
    public static class ParsedInput{
        protected ArrayList<String> command = new ArrayList<>();
        protected HashMap<String, String > flags = new HashMap<>();
    }
}
