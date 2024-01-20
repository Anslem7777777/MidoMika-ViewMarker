package me.mika.midomikaviewmarker.Listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerMarker implements Listener {

    private final List<Material> unMarkMaterial = new ArrayList<>(Arrays.asList(
            Material.CRAFTING_TABLE, Material.FURNACE, Material.FURNACE_MINECART,
            Material.BLAST_FURNACE, Material.HOPPER, Material.HOPPER_MINECART,
            Material.CHEST, Material.CHEST_MINECART, Material.ENDER_CHEST,
            Material.BARREL));

    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (p.isSneaking() && p.getInventory().getItemInMainHand().getType().toString().equals("AIR")){
            Block b = p.getTargetBlockExact( 30);
            if (b != null) {
                if (unMarkMaterial.contains(b.getType()) && b.getLocation().distance(p.getLocation()) > 6 || !unMarkMaterial.contains(b.getType())) {
                    markBlock(b.getLocation());

                }
            }
        }

    }

    private void markBlock(Location location) {
        // Particle effect to create a glowing appearance
        location.getWorld().spawnParticle(
                Particle.REDSTONE,
                location.add(0.5, 0.5, 0.5),
                50, // Particle count
                0.35, 0.35, 0.35, // Particle offset
                0.1, // Particle speed
                new Particle.DustOptions(Color.RED, 1.0f)
        );
        location.getWorld().spawnParticle(
                Particle.REDSTONE,
                location,
                50, // Particle count
                0.35, 0.35, 0.35, // Particle offset
                0.1, // Particle speed
                new Particle.DustOptions(Color.RED, 1.0f)
        );
        location.getWorld().playSound(location, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 0);
    }
}
