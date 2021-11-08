package me.buryings.betaclaims.commands;


import club.deltapvp.deltacore.api.commands.Command;
import club.deltapvp.deltacore.api.commands.annotation.CommandInfo;
import me.buryings.betaclaims.BetaClaims;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "claim", aliases = {"bclaim", "betaclaim", "claimb"}, permission = "betaclaims.claim", playerOnly = true)

public class CommandClaim extends Command {

    private BetaClaims plugin;

    public CommandClaim(BetaClaims plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {

        Player p = (Player) sender;

        Chunk chunk = p.getLocation().getChunk();

        String chunkID = chunk.getX() + "." + chunk.getZ();

        if (plugin.isChunk(chunkID)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("claims-config.chunk-claimed")
                    .replace("%prefix%", plugin.getConfig().getString("message-config.prefix"))));
        } else {
            plugin.addChunk(chunkID, p.getUniqueId());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("claims-config.claimed-chunk")));

            plugin.getClaimsConfig().set("claims.player", p.getUniqueId());
            plugin.getClaimsConfig().set("claims.player.x", chunk.getX());
            plugin.getClaimsConfig().set("claims.player.z", chunk.getZ());
            Bukkit.getLogger().info("[Beta Claims] Logged" + p.getName() + "'s claim to claims.yml" );
        }
    }
}
