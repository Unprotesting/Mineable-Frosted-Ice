package unprotesting.com.github;

import java.io.File;
import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
    private static final Logger log = Logger.getLogger("Minecraft");
    File cfile;
    FileConfiguration config = this.getConfig();
    public static Main plugin;
    public String Drop = ("ICE");
    @Override
    public void onDisable() {
        cancelAllTasks(this);
        log.info(String.format("Disabled Version 0.0.6"));
    }

    private void cancelAllTasks(Main main) {}

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        config.options().header("#Welcome to Mineable Frosted Ice, by Unprotesting  #\n#Visit https://github.com/Unprotesting   #\n#Enabled: Enable/Disable Plugin  #\n#Silk-Touch Required: Turn on Silk Touch requirement for block drop  #\n#Drop: Put what item you want frosted ice to drop here   #\n#Note: Frosted Ice (FROSTED_ICE) is not a spawnable item in 1.15     #\n#bStats: https://bstats.org/plugin/bukkit/Mineable-Frosted-Ice/7570#");
        config.addDefault("Enabled", true);
        config.addDefault("Drop", Drop);
        config.addDefault("Silk-Touch Required", true);
        config.options().copyDefaults(true);
        saveConfig();
        int pluginId = 7570;
        plugin = this;
        Metrics metrics = new Metrics(this, pluginId);
        boolean enabled = getConfig().getBoolean("Enabled");
        if (enabled == false) {
            log.severe(String.format("Disabled plugin as defined in config!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }
}