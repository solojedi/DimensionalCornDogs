package net.dimensionalcorndog.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;

@DimensionalCornDogModElements.ModElement.Tag
public class SoggyCornDogBlockAddedProcedure extends DimensionalCornDogModElements.ModElement {
	public SoggyCornDogBlockAddedProcedure(DimensionalCornDogModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SoggyCornDogBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SoggyCornDogBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SoggyCornDogBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SoggyCornDogBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_PATH.getDefaultState().getBlock()))) {
			Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), world.getWorld(), new BlockPos((int) x, (int) y, (int) z));
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
	}
}
