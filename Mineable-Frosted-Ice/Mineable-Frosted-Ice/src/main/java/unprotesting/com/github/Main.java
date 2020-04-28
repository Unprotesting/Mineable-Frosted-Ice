package unprotesting.com.github;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

    private static final Logger log = Logger.getLogger("Minecraft");
    File cfile;
    FileConfiguration config = this.getConfig();
    public static Main plugin;
    @Override
    public void onDisable() {
        cancelAllTasks(this);
        log.info(String.format("Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    private void cancelAllTasks(Main main) {
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        config.options().header("#Welcome to Mineable Frosted Ice, by Unprotesting  #\n#Visit https://github.com/Unprotesting   #\n#Enabled: Enable/Disable Plugin  #\n#Ice: Frosted Ice drops ice instead  #");
        config.addDefault("Enabled", true);
        config.addDefault("Ice", true);
        config.options().copyDefaults(true);
        saveConfig();
        plugin = this;
        boolean enabled = getConfig().getBoolean("Enabled");
        if (enabled == false) {
            log.severe(String.format("Disabled plugin as defined in config!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

    }
 

}