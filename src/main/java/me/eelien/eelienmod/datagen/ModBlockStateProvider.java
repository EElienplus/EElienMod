package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.block.ModBlocks;
import me.eelien.eelienmod.block.custom.LampBlock;
import net.minecraft.data.PackOutput;
// Remove unnecessary imports like BlockPos, RandomSource, BlockStateProvider, etc.
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    // Constructor should take the mod ID as a String argument
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, EElienMod.MODID, exFileHelper);    }

    @Override
    protected void registerStatesAndModels() {
        // This is the required method for generating block states and models

        // These methods now exist because you extend the correct NeoForge class
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.URANIUM_BLOCK);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.NICKEL_BLOCK);
        blockWithItem(ModBlocks.NICKEL_ORE);
        blockWithItem(ModBlocks.SULFUR_BLOCK);
        blockWithItem(ModBlocks.SULFUR_ORE);
        blockWithItem(ModBlocks.IRIDIUM_BLOCK);
        blockWithItem(ModBlocks.IRIDIUM_ORE);
        blockWithItem(ModBlocks.AMBER_BLOCK);
        blockWithItem(ModBlocks.AMBER_ORE);
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_ORE);

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.LAMP.get()).forAllStates(state -> {
            if(state.getValue(LampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("lamp_on",
                        ResourceLocation.fromNamespaceAndPath(EElienMod.MODID, "block/" + "lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("lamp_off",
                        ResourceLocation.fromNamespaceAndPath(EElienMod.MODID, "block/" + "lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.LAMP.get(), models().cubeAll("lamp_on",
                ResourceLocation.fromNamespaceAndPath(EElienMod.MODID, "block/" + "lamp_on")));
    }

    // Helper method is fine, assuming it uses the correct methods from the superclass
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}