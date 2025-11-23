package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.EElienMod;
// --- Core Imports ---
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
// --- FIX: Change class to interface to resolve 'addProvider' and 'getPackOutput' errors ---
import net.neoforged.neoforge.data.event.DataGenerator;

import java.util.List;
import java.util.Collections; // Needed for the LootTableProvider fix
import java.util.concurrent.CompletableFuture;

// --- FIX: Corrected Custom Provider Imports (assuming no sub-packages like 'loot' or 'client') ---
import me.eelien.eelienmod.datagen.ModDataMapProvider;
import me.eelien.eelienmod.datagen.ModRecipeProvider;
import me.eelien.eelienmod.datagen.ModBlockTagProvider;
import me.eelien.eelienmod.datagen.ModItemTagProvider;
import me.eelien.eelienmod.datagen.ModBlockLootTableProvider;
import me.eelien.eelienmod.datagen.ModBlockStateProvider;
import me.eelien.eelienmod.datagen.ModItemModelProvider;


@SuppressWarnings({"deprecation", "removal"})
@EventBusSubscriber(modid = EElienMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        // Use the NeoForge DataGenerator interface
        DataGenerator generator = event.getGenerator();

        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // --- Server-Side Providers ---

        // 1. LOOT TABLES: --- FIX: Revert to the 4-argument constructor (with emptySet) ---
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider)
        );

        // 2. RECIPES
        generator.addProvider(event.includeServer(),
                new ModRecipeProvider(packOutput, lookupProvider));

        // 3. BLOCK TAGS: --- FIX: Removed EElienMod.MODID (matching your local constructor) ---
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // 4. ITEM TAGS
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider, existingFileHelper));

        // 5. DATA MAPS
        generator.addProvider(event.includeServer(), new ModDataMapProvider(packOutput, lookupProvider));


        // --- Client-Side Providers ---

        // 6. ITEM MODELS
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        // 7. BLOCK STATES: This constructor requires MODID because of its superclass (BlockStateProvider)
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, EElienMod.MODID, existingFileHelper));
    }
}