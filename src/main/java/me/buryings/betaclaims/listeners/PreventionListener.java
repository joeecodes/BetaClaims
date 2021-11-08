package me.buryings.betaclaims.listeners;

import me.buryings.betaclaims.BetaClaims;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PreventionListener implements Listener {

    private BetaClaims plugin;

    public PreventionListener(BetaClaims plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() != null) {

            Chunk chunk = e.getClickedBlock().getChunk();
            String chunkID = chunk.getX() + "." + chunk.getZ();

            if (plugin.isChunk(chunkID)) {

                Player p = e.getPlayer();

                if (!plugin.getOwner(chunkID).equals(p.getUniqueId())) {
                    if (!p.isOp() || p.hasPermission("betaclaims.bypass")) {
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("claim-config.cant-build-here")
                                .replace("%prefix%", plugin.getConfig().getString("message-config.prefix"))));
                    }
                }
            }
        }
    }
}
