package net.dimensionalcorndog.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.dimensionalcorndog.item.HomeDogItem;
import net.dimensionalcorndog.DimensionalCornDogModVariables;
import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@DimensionalCornDogModElements.ModElement.Tag
public class HomeDogFoodEatenProcedure extends DimensionalCornDogModElements.ModElement {
	public HomeDogFoodEatenProcedure(DimensionalCornDogModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HomeDogFoodEaten!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HomeDogFoodEaten!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HomeDogFoodEaten!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HomeDogFoodEaten!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HomeDogFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHasHome) == (false))) {
			if (((entity.dimension.getId()) == (0))) {
				{
					double _setval = (double) x;
					entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHomeX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) y;
					entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHomeY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) z;
					entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHomeZ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerHasHome = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							(("Home Dog Set to ") + "" + (Math.round(x)) + "" + (", ") + "" + (Math.round(y)) + "" + (", ") + "" + (Math.round(z)))),
							(false));
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					SoggyDogDropChanceProcedure.executeProcedure($_dependencies);
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Home Dog can only be set in the overworld"), (false));
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(HomeDogItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else {
			if (((entity.dimension.getId()) == (0))) {
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(
							((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeX),
							((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeY),
							((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeZ));
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(
								((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeX),
								((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeY),
								((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHomeZ),
								_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					SoggyDogDropChanceProcedure.executeProcedure($_dependencies);
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						DimensionType destinationType = DimensionType.OVERWORLD;
						ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
						ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerTeleported = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
