package net.thedarkgamer.endurance.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.thedarkgamer.endurance.EnduranceMod;
import net.thedarkgamer.endurance.config.ModConfigs;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BandageItem extends Item {
    public BandageItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (ModConfigs.ALLOW_BANDAGE_USE) {
            if (!world.isClient()) {
                if (!user.isCreative()) {
                    float userHealth = user.getHealth();
                    if (userHealth <= (20 - ModConfigs.BANDAGE_HEAL_AMOUNT)) {
                        user.heal(ModConfigs.BANDAGE_HEAL_AMOUNT);
                        user.getItemCooldownManager().set(this, ModConfigs.BANDAGE_COOLDOWN_AMOUNT);
                        user.getInventory().getMainHandStack().setCount(user.getInventory().getMainHandStack().getCount() - 1);
                        if (ModConfigs.BANDAGE_LOG_USE) {
                            EnduranceMod.LOGGER.info("Bandage used by " + user.getDisplayName() + " on " + userHealth + " health!");
                        }
                    } else if (ModConfigs.BANDAGE_ACCIDENTAL_USE_PREVENTION) {
                        if (ModConfigs.BANDAGE_ACCIDENTAL_USE_WARNING) {
                            user.sendMessage(new LiteralText("\u00A7cCannot use this item above " + ModConfigs.BANDAGE_ACCIDENTAL_USE_PREVENTION_MAX/2 + " hearts!"), false);
                        }
                    }
                } else if (ModConfigs.BANDAGE_CREATIVE_WARNINGS) {
                    user.sendMessage(new LiteralText("CREATIVE: \u00A7cCannot use this item in creative!"), false);
                }
            }
        } else {
            if (!world.isClient()) {
                if (!user.isCreative()) {
                    if (ModConfigs.SURVIVAL_WARNINGS_ON && ModConfigs.BANDAGE_SURVIVAL_WARNINGS) {
                        user.sendMessage(new LiteralText("\u00A7cBandage Item has been disabled"), false);
                    }
                } else if (user.isCreative()) {
                    if (ModConfigs.CREATIVE_WARNINGS_ON && ModConfigs.BANDAGE_CREATIVE_WARNINGS) {
                        user.sendMessage(new LiteralText("CREATIVE: \u00A7cBandage Item has been disabled"), false);

                    }
                }
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.endurance.bandage"));
        } else {
            tooltip.add(new LiteralText("Heals \u00A7c\u00A7o" + (ModConfigs.BANDAGE_HEAL_AMOUNT/2) + "♥ \u00A7ron use"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
