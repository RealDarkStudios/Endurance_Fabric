package net.thedarkgamer.endurance.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AdminFeederItem extends Item {
    public AdminFeederItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getHungerManager().setFoodLevel(20);
        user.getHungerManager().setSaturationLevel(20);
        user.getHungerManager().setExhaustion(0F);
        return super.use(world, user, hand);
    }
}
