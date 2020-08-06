package net.dimensionalcorndog.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.dimensionalcorndog.DimensionalCornDogModVariables;
import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;

@DimensionalCornDogModElements.ModElement.Tag
public class RawCornDogFoodEatenProcedure extends DimensionalCornDogModElements.ModElement {
	public RawCornDogFoodEatenProcedure(DimensionalCornDogModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RawCornDogFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 160, (int) 1));
		if ((((entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new DimensionalCornDogModVariables.PlayerVariables())).PlayerHasHome) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(DimensionalCornDogModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerHasHome = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("Eating that left  you slighly confused. You forgot where home is. Eat another Home Dog to set."),
						(false));
			}
		}
	}
}
