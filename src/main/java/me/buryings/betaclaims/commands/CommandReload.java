package me.buryings.betaclaims.commands;


import club.deltapvp.deltacore.api.commands.Command;
import club.deltapvp.deltacore.api.commands.annotation.CommandInfo;
import me.buryings.betaclaims.BetaClaims;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandInfo(name = "claimsreload", aliases = {"bclaimreload", "betaclaimreload", "claimbreload"}, permission = "betaclaims.claim.reload")


public class CommandReload extends Command {

    private BetaClaims plugin;

    public CommandReload(BetaClaims plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {

        Player p = (Player) sender;

        // Currently only reloads config.yml not claims.yml
        plugin.reloadConfig();
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("message-config.reloaded-plugin")));
    }
}
