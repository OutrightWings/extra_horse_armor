package com.outrightwings.extended_horse_armor.mixin;

import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {
        "net/minecraft/world/item/enchantment/EnchantmentCategory$1",
        "net/minecraft/world/item/enchantment/EnchantmentCategory$2",
        "net/minecraft/world/item/enchantment/EnchantmentCategory$3",
        "net/minecraft/world/item/enchantment/EnchantmentCategory$4"
})
public class EnchantmentCategoryMixin {
    //Add horse armor to these types so that it can have the enchantments from these sections
    @Inject(method = "canEnchant(Lnet/minecraft/world/item/Item;)Z", at = @At("RETURN"), cancellable = true)
    private void canEnchant(Item itemIn, CallbackInfoReturnable<Boolean> cir){
        if (cir.getReturnValue())return;
        if (itemIn instanceof HorseArmorItem)cir.setReturnValue(true);
    }
}