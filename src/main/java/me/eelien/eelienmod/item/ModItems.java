package me.eelien.eelienmod.item;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.item.custom.ScrewdriverItem;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
