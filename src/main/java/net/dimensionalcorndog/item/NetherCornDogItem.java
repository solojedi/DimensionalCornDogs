
package net.dimensionalcorndog.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.dimensionalcorndog.procedures.NetherCornDogFoodEatenProcedure;
import net.dimensionalcorndog.DimensionalCornDogModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@DimensionalCornDogModElements.ModElement.Tag
public class NetherCornDogItem extends DimensionalCornDogModElements.ModElement {
	@ObjectHolder("dimensional_corn_dog:nether_corn_dog")
	public static final Item block = null;
	public NetherCornDogItem(DimensionalCornDogModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)
					.food((new Food.Builder()).hunger(2).saturation(0.5f).setAlwaysEdible().build()));
			setRegistryName("nether_corn_dog");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Eat to travel to the Nether."));
			list.add(new StringTextComponent("Eat again to travel back to the overworld."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				NetherCornDogFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
