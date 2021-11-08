package me.buryings.betaclaims.commands;


import club.deltapvp.deltacore.api.commands.Command;
import club.deltapvp.deltacore.api.commands.annotation.CommandInfo;
import me.buryings.betaclaims.BetaClaims;
import org.bukkit.command.CommandSender;

@CommandInfo(name = "claimlist", aliases = {"bclaimlist", "betaclaim", "claimblist"}, permission = "betaclaims.claim.list", playerOnly = true)
public class CommandClaimList extends Command {

    private BetaClaims plugin;

    public CommandClaimList(BetaClaims plugin) {
        this.plugin = plugin;
    }
    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("Work in progress");
    }
}
