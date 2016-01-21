package gdr.citygame.debug;

import gdr.citygame.frames.Prompt;
import gdr.citygame.plate.*;

public class ConsoleHandler {

    private static ConsoleHandler console;
    private static Prompt window;

    private ConsoleHandler() {
        
    }

    public static synchronized ConsoleHandler getInstance() {
        if (console == null) {
            console = new ConsoleHandler();
            window = new Prompt();
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
        System.out.println("=====| CityGame |=====");
        System.out.println("= Development by GDR =");
        System.out.println("=    v0 dev build    =");
        System.out.println("======================");
        this.window.writeln("=====| CityGame |=====");
        this.window.writeln("= Development by GDR =");
        this.window.writeln("=    v0 dev build    =");
        this.window.writeln("======================");
    }
    
    public Prompt getPromptWindow(){
        return this.window;
    }
}
