package me.buryings.betaclaims.commands;


import club.deltapvp.deltacore.api.commands.Command;
import club.deltapvp.deltacore.api.commands.annotation.CommandInfo;
import me.buryings.betaclaims.BetaClaims;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "claimlist", aliases = {"bclaimlist", "betaclaim", "claimblist"}, permission = "betaclaims.claim.list")
public class CommandClaimList extends Command {

    private BetaClaims plugin;

    public CommandClaimList(BetaClaims plugin) {

        this.plugin = plugin;
    }
    @Override
    public void onCommand(CommandSender sender, String[] args) {

        sender.sendMessage("Work in progress");

        Player p = (Player) sender;
        String claims = plugin.getClaimsConfig().getString("claims");

        if (plugin.getOwner(claims).equals(p)) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getStringList("claims-config.claim-list").toString()
                    .replace("%claims%", claims)));

        }
    }
}
