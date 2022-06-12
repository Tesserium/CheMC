package xyz.code2828.chemc.tarnishable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TarnishableItem extends Item implements Tarnishable {
	public ItemConvertible nextItem;
	public int tarnishTick;

	public TarnishableItem(Settings settings, ItemConvertible next_item, int tarnishTick) {
		super(settings);
		this.nextItem = next_item;
		this.tarnishTick = tarnishTick;
	}

	@Override
	public ItemConvertible getNextItem() {
		return nextItem;
	}

	@Override
	public int getTarnishTick() {
		return tarnishTick;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (stack.getNbt().getKeys().contains("tarnishTick")) {
			// already has a timestamp; check if world time is bigger than the timestamp:
			long timestamp = stack.getNbt().getLong("tarnishTick");
			if (world.getTime() >= timestamp) {
				if (!(entity instanceof PlayerEntity)) {
					// is not a PlayerEntity
					return;
				}
				// need to be 'tarnish'-ed!
				TarnishableItem oldItem = (TarnishableItem) stack.getItem();
				ItemConvertible newItem = oldItem.getNextItem();
				ItemStack newStack = new ItemStack(newItem);
				PlayerEntity pEnt = (PlayerEntity) entity;
				pEnt.getInventory().setStack(slot, newStack);
			}
		}
	}

	@Override
	public void setNextItem(ItemConvertible ic) {
		nextItem=ic;
		
	}

}
