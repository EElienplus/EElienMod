package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
// Remove unnecessary imports like BlockPos, RandomSource, BlockStateProvider, etc.
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
    }

    // Helper method is fine, assuming it uses the correct methods from the superclass
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}