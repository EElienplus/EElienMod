package me.eelien.eelienmod.item;

import me.eelien.eelienmod.EElienMod;
import me.eelien.eelienmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EElienMod.MODID);

    // Kdybych pridaval dalsi tab tak: .widthTabsBefore(RecourseLocation.fromNamespaceAndPath(EElienMod.MODID), <previousTabString in the register satreing>)
    public static final Supplier<CreativeModeTab> EElienMOD_TAB = CREATIVE_MODE_TAB.register("eelienmod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN.get()))
            .title(Component.translatable("creativetab.eelienmod.eelienmod"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.TIN);
                output.accept(ModItems.SCREWDRIVER);
                output.accept(ModBlocks.TIN_BLOCK);
                output.accept(ModBlocks.TIN_ORE);
                output.accept(ModItems.STARLIGHT_ASHES);
                output.accept(ModBlocks.LAMP);
                output.accept(ModItems.RUBY);
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
