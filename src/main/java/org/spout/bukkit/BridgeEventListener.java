/*
 * This file is part of BukkitBridge (http://www.spout.org/).
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bukkit;

import org.spout.api.event.Listener;
import org.spout.api.event.EventHandler;
import org.spout.api.event.Order;
import org.spout.api.event.player.PlayerJoinEvent;
import org.spout.api.event.player.PlayerKickEvent;
import org.spout.api.event.player.PlayerLeaveEvent;
import org.spout.api.event.player.PlayerLoginEvent;
import org.spout.bukkit.entity.BridgePlayer;

public class BridgeEventListener implements Listener {
	private final BukkitBridge plugin;
	public BridgeEventListener(BukkitBridge plugin) {
		this.plugin = plugin;
	}

	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		org.bukkit.event.player.PlayerLoginEvent bukkitEvent = new org.bukkit.event.player.PlayerLoginEvent(new BridgePlayer(event.getPlayer()));
		this.plugin.getServer().getPluginManager().callEvent(bukkitEvent);
		if (bukkitEvent.getResult() != org.bukkit.event.player.PlayerLoginEvent.Result.ALLOWED) event.disallow(bukkitEvent.getKickMessage());
	}
	
	@EventHandler(order = Order.EARLIEST)
	public void onPlayerJoin(PlayerJoinEvent event) {
		org.bukkit.event.player.PlayerJoinEvent bukkitEvent = new org.bukkit.event.player.PlayerJoinEvent(new BridgePlayer(event.getPlayer()), event.getMessage());
		this.plugin.getServer().getPluginManager().callEvent(bukkitEvent);
		if (!bukkitEvent.getJoinMessage().equals(event.getMessage())) event.setMessage(bukkitEvent.getJoinMessage());
	}
	
	@EventHandler(order = Order.EARLIEST)
	public void onPlayerLeave(PlayerLeaveEvent event) {
		if(event instanceof PlayerKickEvent) {
			PlayerKickEvent eventKick = (PlayerKickEvent) event;
			org.bukkit.event.player.PlayerKickEvent bukkitEvent = new org.bukkit.event.player.PlayerKickEvent(new BridgePlayer(event.getPlayer()), eventKick.getKickReason(), event.getMessage());
			this.plugin.getServer().getPluginManager().callEvent(bukkitEvent);
			if (!bukkitEvent.getReason().equals(eventKick.getKickReason())) eventKick.setKickReason(bukkitEvent.getReason());
			if (!bukkitEvent.getLeaveMessage().equals(event.getMessage())) event.setMessage(bukkitEvent.getLeaveMessage());
		} else {
			org.bukkit.event.player.PlayerQuitEvent bukkitEvent = new org.bukkit.event.player.PlayerQuitEvent(new BridgePlayer(event.getPlayer()), event.getMessage());
			this.plugin.getServer().getPluginManager().callEvent(bukkitEvent);
			if (!bukkitEvent.getQuitMessage().equals(event.getMessage())) event.setMessage(bukkitEvent.getQuitMessage());
		}
		
		
	}
}
