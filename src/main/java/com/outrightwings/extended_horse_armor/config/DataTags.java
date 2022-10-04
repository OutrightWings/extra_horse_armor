package com.outrightwings.extended_horse_armor.config;

import com.outrightwings.extended_horse_armor.ExtendedArmorMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

public class DataTags {
    public static ITagManager<Enchantment> tags = ForgeRegistries.ENCHANTMENTS.tags();
    public static final TagKey<Enchantment> ALLOWED_ENCHANTS = tags.createTagKey(new ResourceLocation(ExtendedArmorMain.MOD_ID,"allowed_enchantments"));

    public static void setup(){
        //apparently needed in order to run correctly
    }

}
