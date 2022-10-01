package com.outrightwings.extended_horse_armor.mixin;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    //Override HorseArmor Items to return true that they are enchantable
    @Inject(at = @At("HEAD"), method = "isEnchantable(Lnet/minecraft/world/item/ItemStack;)Z", cancellable = true)
    private void isEnchantable(ItemStack stack, CallbackInfoReturnable<Boolean> cir){
        if ((Object)this instanceof HorseArmorItem)cir.setReturnValue(true);
    }
    @Inject(at = @At("HEAD"), method = "getEnchantmentValue()I", cancellable = true)
    private void getEnchantmentValue(CallbackInfoReturnable<Integer> cir){
        if ((Object)this instanceof HorseArmorItem)cir.setReturnValue(1);
    }
}
