package com.elysiummc.iFly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;



public class iFly extends JavaPlugin {
	
	public int task1;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		final Player player = (Player) sender;
		int explvl = player.getLevel();
		if(cmd.getName().equalsIgnoreCase("ifly"))
			if (explvl >= 1){
			player.sendMessage(ChatColor.BLUE + player.getName() + " flys!");
			player.setAllowFlight(true);
			task1 = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
				@Override
				public void run() {
					int explvl = player.getLevel();
					int time = player.getLevel();
					if (explvl >= 1){
                          explvl = explvl -1;
                          time = time *30;
                          player.setLevel(explvl);
                          player.sendMessage(ChatColor.BLUE + "You have " + time + " seconds left");
	} else {
				 player.sendMessage(ChatColor.BLUE + "You don't have enough XP!");
				 player.setAllowFlight(false);
				 player.setFlying(false);
				 Bukkit.getServer().getScheduler().cancelTask(task1);
				}
				}
			}, 0L, 400L); 
			}
			else {
				 player.sendMessage(ChatColor.BLUE + " You don't have enough XP!");
				 player.setAllowFlight(false);
				 player.setFlying(false);
				}
		return true;
}
}