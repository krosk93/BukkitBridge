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
package org.spout.bukkit.block;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

public class BridgeCreatureSpawner extends BridgeBlockState implements CreatureSpawner {
	@Override
	public CreatureType getCreatureType() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public EntityType getSpawnedType() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setSpawnedType(EntityType entityType) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setCreatureType(CreatureType creatureType) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public String getCreatureTypeId() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setCreatureTypeByName(String s) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public String getCreatureTypeName() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setCreatureTypeId(String s) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getDelay() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setDelay(int i) {
		//TODO: Adjust for usage with Spout!
	}
}
