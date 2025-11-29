package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EElienMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TIN.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.SULFUR.get());
        basicItem(ModItems.NICKEL.get());
        basicItem(ModItems.URANIUM.get());
        basicItem(ModItems.IRIDIUM.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.SCREWDRIVER.get());
        basicItem(ModItems.AMBER.get());
        basicItem(ModItems.TITANIUM.get());

        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_HOE);
        handheldItem(ModItems.RUBY_HAMMER);
        handheldItem(ModItems.OBSIDIAN_HAMMER);
        handheldItem(ModItems.DIAMOND_STICK);


    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(EElienMod.MODID,"item/" + item.getId().getPath()));
    }
}