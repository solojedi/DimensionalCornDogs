package net.dimensionalcorndog.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.dimensionalcorndog.block.WholeSoggyCornDogBlock;
import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;

@DimensionalCornDogModElements.ModElement.Tag
public class HalfASoggyCornDogUpdateTickProcedure extends DimensionalCornDogModElements.ModElement {
	public HalfASoggyCornDogUpdateTickProcedure(DimensionalCornDogModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HalfASoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HalfASoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HalfASoggyCornDogUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HalfASoggyCornDogUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() <= 0.5)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WholeSoggyCornDogBlock.block.getDefaultState(), 3);
		}
	}
}
