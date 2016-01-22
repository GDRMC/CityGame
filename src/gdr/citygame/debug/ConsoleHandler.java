package gdr.citygame.debug;

import gdr.citygame.frames.*;
import gdr.citygame.plate.*;

public class ConsoleHandler {

    private static ConsoleHandler console;
    private static ConsolePrompt window;

    private ConsoleHandler() {
        
    }

    public static synchronized ConsoleHandler getInstance() {
        if (console == null) {
            console = new ConsoleHandler();
            window = new ConsolePrompt();
            window.setVisible(true);
        }
        return console;
    }

    public void d(String s){
        System.out.print(s);
        this.window.write(s);
    }
    
    public void dln(String s){
        System.out.println(s);
        this.window.writeln(s);
    }
    
    public void dCard(Land l){
        System.out.println(
            "====| Card Overview |====\n"+
            l+
            "=========================\n"
        );      
    }

    private void initPromptWindow() {
        
    }
    
    public void dProgramHeader(){
        this.window.writeln("=====| CityGame |=====");
        this.window.writeln("= Development by GDR =");
        this.window.writeln("=    v0 dev build    =");
        this.window.writeln("======================");
        this.window.msg("This program uses Sea Glass (v0.2) look and feel !\n");
    }
    
    public ConsolePrompt getPromptWindow(){
        return this.window;
    }
}
