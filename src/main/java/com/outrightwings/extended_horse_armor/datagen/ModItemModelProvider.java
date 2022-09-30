package com.outrightwings.extended_horse_armor.datagen;

import com.outrightwings.extended_horse_armor.ExtendedArmorMain;
import com.outrightwings.extended_horse_armor.items.RegisterArmorItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ExtendedArmorMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : RegisterArmorItems.ITEMS.getEntries()) {
            simpleItem(item.get());
        }
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ExtendedArmorMain.MOD_ID,"item/" + item.getRegistryName().getPath()));
    }
}
