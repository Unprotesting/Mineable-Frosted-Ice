package unprotesting.com.github;

import java.io.File;
import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import lombok.Setter;
import unprotesting.com.github.listenable.MyListener;
import unprotesting.com.github.util.Config;

public class Main extends JavaPlugin implements Listener{
    private static final Logger log = Logger.getLogger("Minecraft");
    public static Main plugin;
    public String Drop = ("ICE");

    @Setter
    @Getter
    public static FileConfiguration mainConfig;

    @Getter
    private File configf;

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        createFiles();
        saveConfig();
        Config.setVariablesFromConfig();
        Metrics metrics = new Metrics(this, 7570);
        metrics.addCustomChart(new Metrics.SimplePie("1", () -> "My value"));
        boolean enabled = getConfig().getBoolean("Enabled");
        if (!enabled) {
            log.severe(String.format("Disabled plugin as defined in config!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    public void createFiles() {
        mainConfig = new YamlConfiguration();

        configf = new File(getDataFolder(), "config.yml");

        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
          }
    }
}