package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @SuppressWarnings({"deprecation", "removal"})
    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.STARLIGHT_ASHES.getId(), new FurnaceFuel(6400), false);
    }
}
