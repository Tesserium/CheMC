package xyz.code2828.chemc;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.text.Text;

public class BlastFurnaceBlockEntity extends BlockEntity
{
	private boolean limePresent;

	public boolean isLimePresent()
	{ return limePresent; }

	public void setLimePresent(boolean limePresent)
	{ this.limePresent = limePresent; }

	public boolean isCharcoalPresent()
	{ return charcoalPresent; }

	public void setCharcoalPresent(boolean charcoalPresent)
	{ this.charcoalPresent = charcoalPresent; }

	public double getOreAmount()
	{ return oreAmount; }

	public void setOreAmount(double oreAmount)
	{ this.oreAmount = oreAmount; }

	public boolean isWorking()
	{ return working; }

	public void setWorking(boolean working)
	{ this.working = working; }

	private boolean charcoalPresent;
	private double oreAmount;
	private boolean working;

	public BlastFurnaceBlockEntity(BlockPos pos, BlockState state)
	{
		super(CheMC.BLAST_FURNACE_BE, pos, state);
	}

	// Serialize the BlockEntity
	@Override
	public void writeNbt(NbtCompound tag)
	{
		tag.putBoolean("charcoal_present", charcoalPresent);
		tag.putBoolean("lime_present", limePresent);
		tag.putBoolean("working", working);
		tag.putDouble("ore_amount", oreAmount);

		super.writeNbt(tag);
	}

	// Deserialize the BlockEntity
	@Override
	public void readNbt(NbtCompound tag)
	{
		super.readNbt(tag);

		charcoalPresent = tag.getBoolean("charcoal_present");
		limePresent = tag.getBoolean("lime_present");
		working = tag.getBoolean("working");
		oreAmount = tag.getDouble("ore_amount");
	}

	@Nullable
	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket()
	{
		return BlockEntityUpdateS2CPacket.create(this);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt()
	{
		return createNbt();
	}

	public static void tick(World world, BlockPos pos, BlockState state, BlastFurnaceBlockEntity be)
	{}

}

// https://discord.com/channels/507304429255393322/507982478276034570/989300657750179851
