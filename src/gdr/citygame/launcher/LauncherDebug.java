package gdr.citygame.launcher;

import gdr.citygame.plate.*;
import gdr.citygame.player.*;
import gdr.citygame.debug.*;
import gdr.citygame.gamerules.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LauncherDebug {

    public static void main(String[] args) {
        //initialize console instance for debug
        ConsoleHandler debug = ConsoleHandler.getInstance();

        debug.dProgramHeader();

        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
            System.setProperty("SeaGlass.JTextArea.drawLineSeparator", "false");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TESTS
        Land c1 = new Land("Passerelle des Arts", 1600000);
        c1.setBuildingValues(1000000, 120000, 600000, 1800000, 5000000, 7000000, 9000000);
        c1.verifyCardIntegrity();
        System.out.println(c1.toString());
        debug.dCard(c1);
    }

}
