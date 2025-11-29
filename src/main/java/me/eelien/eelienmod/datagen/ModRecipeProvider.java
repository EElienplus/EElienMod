package me.eelien.eelienmod.datagen;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.block.ModBlocks;
import me.eelien.eelienmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.minecraft.world.item.Items; // <-- REQUIRED for vanilla items

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> TIN_SMELTABLES = List.of(
                ModBlocks.TIN_ORE);
        List<ItemLike> AMBER_SMELTABLES = List.of(ModBlocks.AMBER_ORE);
        List<ItemLike> URANIUM_SMELTABLES = List.of(ModBlocks.URANIUM_ORE);
        List<ItemLike> IRIDIUM_SMELTABLES = List.of(ModBlocks.IRIDIUM_ORE);
        List<ItemLike> SULFUR_SMELTABLES = List.of(ModBlocks.SULFUR_ORE);
        List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE);
        List<ItemLike> NICKEL_SMELTABLES = List.of(ModBlocks.NICKEL_ORE);
        List<ItemLike> TITANIUM_SMELTABLES = List.of(ModBlocks.TITANIUM_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT") // Corrected: Must be 3 chars wide like the other patterns
                .pattern("TTT")
                .define('T', ModItems.TIN.get())
                .unlockedBy("has_TIN", has(ModItems.TIN)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_TIN_block", has(ModBlocks.TIN_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SCREWDRIVER.get()) // Using TOOLS category
                .pattern("CT ")
                .pattern("TS ")
                .pattern("  S")
                // --- DEFINITIONS ADDED HERE ---
                .define('C', Items.COPPER_INGOT) // Copper Ingot (Vanilla)
                .define('T', ModItems.TIN.get())    // Tin Ingot (Modded)
                .define('S', Items.STICK)        // Stick (Vanilla)
                // ------------------------------
                .unlockedBy("has_TIN", has(ModItems.TIN)).save(recipeOutput); // Required to finish recipe

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SULFUR.get(), 9)
                .requires(ModBlocks.SULFUR_BLOCK)
                .unlockedBy("has_SULFUR_block", has(ModBlocks.SULFUR_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NICKEL.get(), 9)
                .requires(ModBlocks.NICKEL_BLOCK)
                .unlockedBy("has_NICKEL_block", has(ModBlocks.NICKEL_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRIDIUM.get(), 9)
                .requires(ModBlocks.IRIDIUM_BLOCK)
                .unlockedBy("has_IRIDIUM_block", has(ModBlocks.IRIDIUM_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.IRIDIUM_BLOCK.get())
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.IRIDIUM.get())
                .unlockedBy("has_IRIDIUM", has(ModItems.IRIDIUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SULFUR_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SULFUR.get())
                .unlockedBy("has_SULFUR", has(ModItems.SULFUR)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NICKEL_BLOCK.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.NICKEL.get())
                .unlockedBy("has_NICKEL", has(ModItems.NICKEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy("has_RUBY", has(ModItems.RUBY)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK)
                .unlockedBy("has_RUBY_block", has(ModBlocks.RUBY_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK.get())
                .pattern("UUU")
                .pattern("UUU")
                .pattern("UUU")
                .define('U', ModItems.URANIUM.get())
                .unlockedBy("has_URANIUM", has(ModItems.URANIUM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.URANIUM.get(), 9)
                .requires(ModBlocks.URANIUM_BLOCK)
                .unlockedBy("has_URANIUM_block", has(ModBlocks.URANIUM_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_STICK.get(), 4)
                .pattern("   ")
                .pattern(" D ")
                .pattern(" D ")
                .define('D', Items.DIAMOND)
                .unlockedBy("has_DIAMOND", has(Items.DIAMOND)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUBY_HAMMER.get())
                .pattern("RRR")
                .pattern("RDR")
                .pattern(" D ")
                .define('D', ModItems.DIAMOND_STICK.get())
                .define('R', ModItems.RUBY.get())
                .unlockedBy("has_RUBY", has(ModItems.RUBY)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBSIDIAN_HAMMER.get())
                .pattern("OOO")
                .pattern("ODO")
                .pattern(" D ")
                .define('D', ModItems.DIAMOND_STICK.get())
                .define('O', Items.OBSIDIAN)
                .unlockedBy("has_RUBY_HAMMER", has(ModItems.RUBY_HAMMER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AMBER_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AMBER.get())
                .unlockedBy("has_AMBER", has(ModItems.AMBER)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AMBER.get(), 9)
                .requires(ModBlocks.AMBER_BLOCK)
                .unlockedBy("has_AMBER_block", has(ModBlocks.AMBER_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM.get())
                .unlockedBy("has_TITANIUM", has(ModItems.TITANIUM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK)
                .unlockedBy("has_TITANIUM_block", has(ModBlocks.TITANIUM_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.25f, 200, "TIN");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.25f, 100, "TIN");

        oreSmelting(recipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER.get(), 0.25f, 200, "AMBER");
        oreBlasting(recipeOutput, AMBER_SMELTABLES, RecipeCategory.MISC, ModItems.AMBER.get(), 0.25f, 100, "AMBER");

        oreSmelting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM.get(), 0.25f, 200, "URANIUM");
        oreBlasting(recipeOutput, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM.get(), 0.25f, 100, "URANIUM");

        oreSmelting(recipeOutput, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL.get(), 0.25f, 200, "NICKEL");
        oreBlasting(recipeOutput, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL.get(), 0.25f, 100, "NICKEL");

        oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "RUBY");
        oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "RUBY");

        oreSmelting(recipeOutput, SULFUR_SMELTABLES, RecipeCategory.MISC, ModItems.SULFUR.get(), 0.25f, 200, "SULFUR");
        oreBlasting(recipeOutput, SULFUR_SMELTABLES, RecipeCategory.MISC, ModItems.SULFUR.get(), 0.25f, 100, "SULFUR");

        oreSmelting(recipeOutput, IRIDIUM_SMELTABLES, RecipeCategory.MISC, ModItems.IRIDIUM.get(), 0.25f, 200, "IRIDIUM");
        oreBlasting(recipeOutput, IRIDIUM_SMELTABLES, RecipeCategory.MISC, ModItems.IRIDIUM.get(), 0.25f, 100, "IRIDIUM");

        oreSmelting(recipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM.get(), 0.25f, 200, "TITANIUM");
        oreBlasting(recipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM.get(), 0.25f, 100, "TITANIUM");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, EElienMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}