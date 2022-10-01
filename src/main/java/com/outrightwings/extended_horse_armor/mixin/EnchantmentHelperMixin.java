package com.outrightwings.extended_horse_armor.mixin;

import com.outrightwings.extended_horse_armor.enchantable.EnchantableHorseArmor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/entity/LivingEntity;)I", at = @At("HEAD"), cancellable = true)
    private static void getEnchantmentLevel(Enchantment enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir){
            EnchantableHorseArmor.checkHorseArmorEnchantmentLevelHook(enchantmentIn,entityIn,cir);
    }
}
