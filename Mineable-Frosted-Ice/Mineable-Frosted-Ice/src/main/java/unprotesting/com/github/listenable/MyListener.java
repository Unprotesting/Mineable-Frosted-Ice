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
import unprotesting.com.github.util.Config;

import org.bukkit.event.Listener;

public class MyListener implements Listener {


    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event) {
        Material block = event.getBlock().getType();
        Player player = event.getPlayer();
            if(block == Material.FROSTED_ICE){
                Boolean SilkTouchEnabled = Config.getSilkTouchEnabled();

                if (Config.getDrop() == null){
                    return;
                }

                else if (Config.getDrop() == ("AIR")){
                    return;
                }

                else if (Config.getDrop()== ("FROSTED_ICE")){
                    player.sendMessage(Config.getDrop() + " is invalid");
                    return;
                }

                else if (Config.getDrop() == ("LEGACY_FROSTED_ICE")){
                    player.sendMessage(Config.getDrop() + " is invalid");
                    return;
                }

                else if (player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH) && SilkTouchEnabled){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(Config.getDrop())), 1));
                }

                else if (!SilkTouchEnabled){
                    event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack((Material.matchMaterial(Config.getDrop())), 1));
                }

                else if (SilkTouchEnabled && !player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)){
                        player.sendMessage(ChatColor.BLUE + "You need Silk Touch to mine Frosted Ice");
                }
            }
        }
    }


    


    
