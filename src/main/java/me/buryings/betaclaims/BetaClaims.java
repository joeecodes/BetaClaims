package me.buryings.betaclaims;

import club.deltapvp.deltacore.api.DeltaPlugin;
import lombok.Getter;
import lombok.Setter;
import me.buryings.betaclaims.commands.CommandClaim;
import me.buryings.betaclaims.commands.CommandClaimList;
import me.buryings.betaclaims.commands.CommandReload;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public final class BetaClaims extends DeltaPlugin {

    private HashMap<String, UUID> chunks;

    @Getter @Setter
    private static BetaClaims instance;
    private File claimsconfigfile;
    private FileConfiguration claimsconfig;



    @Override
    public void onEnable() {

        instance = this;

        loadFiles(this, "config.yml", "claims.yml");

        this.chunks = new HashMap<>();

        // Registers Commands
        registerCommands(new CommandClaim(this), new CommandClaimList(this), new CommandReload(this));
        Bukkit.getLogger().info("[Beta Claims] Registered Commands");

        registerListeners();

        // Gets/Saves config.yml
        this.getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Gets claims.yml config
        getClaimsConfig();


        Bukkit.getLogger().info("[Beta Claims] Config has loaded");

        Bukkit.getLogger().info("[Beta Claims] Enabled v1.0.0");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[Beta Claims] Disabled v1.0.0");
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();


        Bukkit.getLogger().info("[Beta Claims] Registered Commands");

    }

    public void addChunk(String chunk, UUID owner) {
        chunks.put(chunk, owner);

    }
    public boolean isChunk(String chunk) {

        return chunks.containsKey(chunk);
    }

    public UUID getOwner(String chunk) {

        return chunks.get(chunk);
    }

    public void claimsConfig() {
        claimsconfigfile = new File(getDataFolder(), "claims.yml");
        if (!claimsconfigfile.exists()) {
            claimsconfigfile.getParentFile().mkdirs();
            saveResource("claims.yml", false);
        }

        claimsconfig = new YamlConfiguration();
        try {
            claimsconfig.load(claimsconfigfile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public FileConfiguration getClaimsConfig() {

        return this.claimsconfig;

    }

}

