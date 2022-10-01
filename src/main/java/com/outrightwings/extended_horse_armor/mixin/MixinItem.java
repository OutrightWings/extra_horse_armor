package com.outrightwings.extended_horse_armor.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public class MixinItem {
    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/world/entity/item/ItemEntity;fireImmune()Z", cancellable = true)
    private void fireImmune(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
