package unprotesting.com.github;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.Listener;

public class MyListener implements Listener {

    public static String Drop(){
        return Main.plugin.getConfig().getString("Drop");
    }

    public static Boolean SilkTouchEnabled() {
        return Main.plugin.getConfig().getBoolean("Silk-Touch Required");
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        Material block = event.getBlock().getType();
        Player player = event.getPlayer();
            if(block == Material.FROSTED_ICE){
                player.sendMessage(Drop());
                boolean SilkTouchEnabled = SilkTouchEnabled();

                if (Drop() == null){
                    return;
                }

                else if (Drop() == ("AIR")){
                    return;
                }

                else if (Drop() == ("FROSTED_ICE")){
                    player.sendMessage(Drop() + " is invalid");
                    return;
                }

                else if (Drop() == ("LEGACY_FROSTED_ICE")){
                    player.sendMessage(Drop() + " is invalid");
                    return;
                }

                else if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && SilkTouchEnabled == true){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(Drop())), 1));
                }

                else if (SilkTouchEnabled == false){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(Drop())), 1));
                }

                else if (SilkTouchEnabled == true && player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) == false){
                        player.sendMessage(ChatColor.BLUE + "You need Silk Touch to mine Frosted Ice");
                }
            }
        }
    }


    


    
