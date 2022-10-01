package com.outrightwings.extended_horse_armor.items;

import com.outrightwings.extended_horse_armor.ExtendedArmorMain;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class RegisterArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExtendedArmorMain.MOD_ID);

    //Horse Armor
    public static final RegistryObject<HorseArmorItem> EMERALD_HORSE_ARMOR = registerHorseArmor("emerald",10);
    public static final RegistryObject<HorseArmorItem> QUARTZ_HORSE_ARMOR = registerHorseArmor("quartz",10);
    public static final RegistryObject<HorseArmorItem> DARK_IRON_HORSE_ARMOR = registerHorseArmor("dark_iron",10);
    private static RegistryObject<HorseArmorItem> registerHorseArmor(String material, int protection){
        RegistryObject<HorseArmorItem> obj = ITEMS.register(material + "_horse_armor", () -> new ExtendedHorseArmorItem(protection, material, (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));
        return obj;
    }
}
