package unprotesting.com.github.listenable;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;
import unprotesting.com.github.Main;

import org.bukkit.event.Listener;

public class MyListener implements Listener {

    public static String drop(){
        return Main.plugin.getConfig().getString("Drop");
    }

    public static Boolean silkTouchEnabled() {
        return Main.plugin.getConfig().getBoolean("Silk-Touch Required");
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        Material block = event.getBlock().getType();
        Player player = event.getPlayer();
            if(block == Material.FROSTED_ICE){
                player.sendMessage(drop());
                boolean SilkTouchEnabled = silkTouchEnabled();

                if (drop() == null){
                    return;
                }

                else if (drop() == ("AIR")){
                    return;
                }

                else if (drop() == ("FROSTED_ICE")){
                    player.sendMessage(drop() + " is invalid");
                    return;
                }

                else if (drop() == ("LEGACY_FROSTED_ICE")){
                    player.sendMessage(drop() + " is invalid");
                    return;
                }

                else if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && SilkTouchEnabled){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(drop())), 1));
                }

                else if (!SilkTouchEnabled){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(drop())), 1));
                }

                else if (SilkTouchEnabled && !player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)){
                        player.sendMessage(ChatColor.BLUE + "You need Silk Touch to mine Frosted Ice");
                }
            }
        }
    }


    


    
