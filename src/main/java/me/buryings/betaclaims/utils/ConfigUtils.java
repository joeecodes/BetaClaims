package me.buryings.betaclaims.utils;

import lombok.Getter;
import lombok.SneakyThrows;
import me.buryings.betaclaims.BetaClaims;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtils {

    private final File file;
    @Getter
    private final FileConfiguration config;


    public ConfigUtils(String fileName) {
        file = new File(BetaClaims.getInstance().getDataFolder(), fileName + ".yml");
        config = YamlConfiguration.loadConfiguration(file);
    }

    @SneakyThrows
    public void save() {
        config.save(file);
    }
}
