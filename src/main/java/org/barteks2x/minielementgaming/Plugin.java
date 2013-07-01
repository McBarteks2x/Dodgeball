package org.barteks2x.minielementgaming;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

	private WorldEditPlugin worldedit;

	@Override
	public void onEnable() {
		worldedit = (WorldEditPlugin)Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		CommandExecutor exec = new MinigameLogic(this, worldedit);
		Listener l = (Listener)exec;
		getServer().getPluginManager().registerEvents(l, this);
		getCommand("meg").setExecutor(exec);
		getCommand("join").setExecutor(exec);
		getCommand("leave").setExecutor(exec);
		getCommand("mghelp").setExecutor(exec);
	}

	@Override
	public void onDisable() {
		//TODO onDisable
	}

	public static void main(String[] args) {
		System.out.println("This is bukkit plugin! Copy it to plugins folder and run Bukkit.");
	}
}
