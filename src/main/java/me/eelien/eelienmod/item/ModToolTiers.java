package me.eelien.eelienmod.item;

import me.eelien.eelienmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier RUBY = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL,
            800, 4f, 3f, 20, () -> Ingredient.of(ModItems.RUBY));
}
