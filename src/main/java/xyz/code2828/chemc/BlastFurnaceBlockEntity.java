package xyz.code2828.chemc;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;

public class BlastFurnaceBlockEntity extends BlockEntity
{
	private boolean limePresent;
	private boolean charcoalPresent;
	private double oreAmount;
	private boolean working;

	public BlastFurnaceBlockEntity(BlockPos pos, BlockState state)
	{
		super(CheMC.BLAST_FURNACE_BE, pos, state);
		// TODO Auto-generated constructor stub
	}

	// Serialize the BlockEntity
	@Override
	public void writeNbt(NbtCompound tag)
	{
		// Save the current value of the number to the tag
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
	{
		if(world.getTime()%200==0)
		{
			System.out.println("Ten seconds (200 ticks) has passed.");
		}
	}

}
