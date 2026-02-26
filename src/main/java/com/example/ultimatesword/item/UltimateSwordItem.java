package com.example.ultimatesword.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class UltimateSwordItem extends SwordItem {

    public UltimateSwordItem() {
        super(
                Tiers.NETHERITE,
                9999,
                -2.4F,
                new Properties()
                        .durability(1)
                        .fireResistant()
        );
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide) {
            target.kill();
        }
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (player.tickCount % 20 == 0) {
                if (player.getHealth() < player.getMaxHealth()) {
                    player.heal(2.0F);
                }
            }
        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
