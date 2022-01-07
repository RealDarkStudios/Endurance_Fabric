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

public class MedkitItem extends Item {
    public MedkitItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (ModConfigs.ALLOW_MEDKIT_USE) {
            if (!world.isClient()) {
                if (!user.isCreative()) {
                    float userHealth = user.getHealth();
                    if (userHealth <= (20 - ModConfigs.MEDKIT_HEAL_AMOUNT)) {
                        user.heal(ModConfigs.MEDKIT_HEAL_AMOUNT);
                        user.getItemCooldownManager().set(this, ModConfigs.MEDKIT_COOLDOWN_AMOUNT);
                        user.getInventory().getMainHandStack().setCount(user.getInventory().getMainHandStack().getCount() - 1);
                        if (ModConfigs.MEDKIT_LOG_USE) {
                            EnduranceMod.LOGGER.info("Bandage used by " + user.getName().asString() + " on " + userHealth + " health!");
                        }
                    } else if (ModConfigs.MEDKIT_ACCIDENTAL_USE_PREVENTION) {
                        if (ModConfigs.MEDKIT_ACCIDENTAL_USE_WARNING) {
                            user.sendMessage(new LiteralText("\u00A7cCannot use this item above " + ModConfigs.MEDKIT_ACCIDENTAL_USE_PREVENTION_MAX/2 + " hearts!"), false);
                        }
                    }
                } else if (ModConfigs.MEDKIT_CREATIVE_WARNINGS) {
                    user.sendMessage(new LiteralText("CREATIVE: \u00A7cCannot use this item in creative!"), false);
                }
            }
        } else {
            if (!world.isClient()) {
                if (!user.isCreative()) {
                    if (ModConfigs.SURVIVAL_WARNINGS_ON && ModConfigs.MEDKIT_SURVIVAL_WARNINGS) {
                        user.sendMessage(new LiteralText("\u00A7cBandage Item has been disabled"), false);
                    }
                } else if (user.isCreative()) {
                    if (ModConfigs.CREATIVE_WARNINGS_ON && ModConfigs.MEDKIT_CREATIVE_WARNINGS) {
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
            tooltip.add(new TranslatableText("tooltip.endurance.medkit"));
        } else {
            tooltip.add(new LiteralText("Heals \u00A7c\u00A7o" + (ModConfigs.MEDKIT_HEAL_AMOUNT/2) + "♥ \u00A7ron use"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
