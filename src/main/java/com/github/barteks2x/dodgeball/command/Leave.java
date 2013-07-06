package com.github.barteks2x.dodgeball.command;

import com.github.barteks2x.dodgeball.MinigameManager;
import java.util.Iterator;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.GREEN;

public class Leave {

	private final MinigameManager mm;

	public Leave(MinigameManager mm) {
		this.mm = mm;
	}

	@DBCommand
	public boolean leave(CommandSender sender, Iterator<String> args) {
		if (!sender.hasPermission("db.leave")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
			return true;
		}
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command must be used by player");
			return true;
		}
		mm.removePlayer(mm.getMinigamePlayer(((Player)sender).getName()));
		sender.sendMessage(GREEN + "Left ciurrent minigame.");
		return true;
	}
}
