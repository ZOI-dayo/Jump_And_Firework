package net.zoizoi.spigot.jump_and_firework;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class JumpAndFirework extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJump(PlayerMoveEvent event) { // 名前はどうでも良い
        if(event.getFrom().getY() == event.getTo().getY()) return; // 高さ変わってなかったら無視
        Player player = event.getPlayer();
        World world = player.getWorld();
        Firework firework = (Firework) world.spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();
        meta.setPower(3);
        meta.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
        firework.setFireworkMeta(meta);
        // event.getPlayer().getLocation()
    }
}
