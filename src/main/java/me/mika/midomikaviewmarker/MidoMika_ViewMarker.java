package me.mika.midomikaviewmarker;

import me.mika.midomikaviewmarker.Listeners.PlayerMarker;
import org.bukkit.plugin.java.JavaPlugin;

public final class MidoMika_ViewMarker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerMarker(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
