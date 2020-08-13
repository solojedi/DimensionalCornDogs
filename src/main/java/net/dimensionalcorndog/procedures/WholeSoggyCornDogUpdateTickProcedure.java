package net.dimensionalcorndog.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.dimensionalcorndog.block.WholeSoggyCornDogBlock;
import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;

@DimensionalCornDogModElements.ModElement.Tag
public class WholeSoggyCornDogUpdateTickProcedure extends DimensionalCornDogModElements.ModElement {
	public WholeSoggyCornDogUpdateTickProcedure(DimensionalCornDogModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WholeSoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WholeSoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WholeSoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WholeSoggyCornDogUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() <= 0.25)) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GRASS_PATH.getDefaultState()
					.getBlock()) && (world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z + 1)))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), WholeSoggyCornDogBlock.block.getDefaultState(), 3);
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.GRASS_PATH.getDefaultState()
					.getBlock()) && (world.isAirBlock(new BlockPos((int) x, (int) y, (int) (z - 1)))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), WholeSoggyCornDogBlock.block.getDefaultState(), 3);
			} else if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_PATH.getDefaultState()
					.getBlock()) && (world.isAirBlock(new BlockPos((int) (x + 1), (int) y, (int) z))))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), WholeSoggyCornDogBlock.block.getDefaultState(), 3);
			} else if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_PATH.getDefaultState()
					.getBlock()) && (world.isAirBlock(new BlockPos((int) (x - 1), (int) y, (int) z))))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), WholeSoggyCornDogBlock.block.getDefaultState(), 3);
			}
		}
	}
}
