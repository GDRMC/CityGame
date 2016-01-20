package gdr.citygame.debug;

import gdr.citygame.plate.*;

public class ConsoleHandler {

    private static ConsoleHandler console;

    private ConsoleHandler() {
        
    }

    public static synchronized ConsoleHandler getInstance() {
        if (console == null) {
            console = new ConsoleHandler();
        }
        return console;
    }

    public void d(String s){
        System.out.print(s);
    }
    
    public void dln(String s){
        System.out.println(s);
    }
    
    public void dCard(Land l){
        System.out.println(
            "====| Card Overview |====\n"+
            l+
            "=========================\n"
        );      
    }
}
