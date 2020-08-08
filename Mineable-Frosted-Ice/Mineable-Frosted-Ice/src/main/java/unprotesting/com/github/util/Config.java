package unprotesting.com.github.util;

import lombok.Getter;
import lombok.Setter;
import unprotesting.com.github.Main;

public final class Config {
    @Getter
    @Setter
    public static Boolean enabled, silkTouchEnabled;

    @Getter
    @Setter
    public static String drop;

    public static void setVariablesFromConfig(){
        //  Booleans
        setEnabled(Main.getMainConfig().getBoolean("Enabled", true));
        setSilkTouchEnabled(Main.getMainConfig().getBoolean("Silk-Touch-Required", true));
        //  Strings
        setDrop(Main.getMainConfig().getString("Drop", "ICE"));
    }

}