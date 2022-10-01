package com.outrightwings.extended_horse_armor.enchantable;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.client.model.pipeline.IVertexProducer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel;

public class EnchantableHorseArmor {
    //create category for the horse armor in the enchantment system
    static EnchantmentCategory HORSE = EnchantmentCategory.create("horse_armor", itemIn -> (itemIn instanceof HorseArmorItem));

    public static void checkHorseArmorEnchantmentLevelHook(Enchantment enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir){
        if(entityIn instanceof AbstractHorse){
            ItemStack armor = ((AbstractHorse)entityIn).getItemBySlot(EquipmentSlot.CHEST);
            if (armor.getItem() instanceof HorseArmorItem) {
                int level = getItemEnchantmentLevel(enchantmentIn, armor);
                cir.setReturnValue(level);
            }
        }
    }
}
