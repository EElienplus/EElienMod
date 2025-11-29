package me.eelien.eelienmod.item;

import me.eelien.eelienmod.EElienMod;
// --- Custom Class Imports ---
import me.eelien.eelienmod.item.custom.HammerItem;
import me.eelien.eelienmod.item.custom.ScrewdriverItem;
import me.eelien.eelienmod.item.custom.FuelItem; // <-- FIX: Added the missing import for FuelItem
// ----------------------------
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EElienMod.MODID);

    public static final DeferredItem<Item> TIN = ITEMS.register("tin",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SCREWDRIVER = ITEMS.register("screwdriver",
            () -> new ScrewdriverItem(new Item.Properties().durability(128)));

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new FuelItem(new Item.Properties(), 6400));

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 7, -2.4f))));

    public static final DeferredItem<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 1.0f, -2.8f))));

    public static final DeferredItem<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 9.0f, -3.2f))));

    public static final DeferredItem<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 1.5f, -3.0f))));

    public static final DeferredItem<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 0.5f, -3.0f))));

    public static final DeferredItem<Item> DIAMOND_STICK = ITEMS.register("diamond_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RUBY_HAMMER = ITEMS.register("ruby_hammer",
            () -> new HammerItem(Tiers.IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.IRON, 5f, -3.0f))));
    public static final DeferredItem<Item> OBSIDIAN_HAMMER = ITEMS.register("obsidian_hammer",
            () -> new HammerItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 9f, -3.4f))));

    public static final DeferredItem<Item> NICKEL = ITEMS.register("nickel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IRIDIUM = ITEMS.register("iridium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AMBER = ITEMS.register("amber",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}