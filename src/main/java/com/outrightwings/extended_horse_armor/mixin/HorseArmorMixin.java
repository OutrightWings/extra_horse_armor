package com.outrightwings.extended_horse_armor.mixin;

import com.outrightwings.extended_horse_armor.config.DataTags;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;
import net.minecraftforge.registries.tags.ITagManager;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Map;

@Mixin(HorseArmorItem.class)
public class HorseArmorMixin {

    public boolean isEnchantable(ItemStack stack){
        return true;
    }

    public int getEnchantmentValue(){
        return 1;
    }

    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        ITagManager<Enchantment> tags = ForgeRegistries.ENCHANTMENTS.tags();
        return tags.getTag(DataTags.ALLOWED_ENCHANTS).contains(enchantment);
    }

    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        Map<Enchantment,Integer> enchants = EnchantmentHelper.getEnchantments(book);
        var tags = ForgeRegistries.ENCHANTMENTS.tags().getTag(DataTags.ALLOWED_ENCHANTS);
        //Lol I didn't know how else to pull of the one damn enchantment to compare it to my damn list
        //Limitation is you can only apply one valid enchant at a time. None of this vanilla nonsense where things that don't fit just get yeeted into the void
        return enchants.size() == 1 && tags.contains(enchants.entrySet().iterator().next().getKey()) ;
    }
}
