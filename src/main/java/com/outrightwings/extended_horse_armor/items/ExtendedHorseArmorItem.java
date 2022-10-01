package com.outrightwings.extended_horse_armor.items;

import com.outrightwings.extended_horse_armor.ExtendedArmorMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class ExtendedHorseArmorItem extends HorseArmorItem {
    public ExtendedHorseArmorItem(int protection, String material, Properties properties){
        super(protection,material,properties);
    }

    public ResourceLocation getTexture(){
        return new ResourceLocation(ExtendedArmorMain.MOD_ID, super.getTexture().getPath());
    }
}
