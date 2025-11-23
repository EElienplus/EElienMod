package me.eelien.eelienmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.entity.player.Player;

public class ScrewdriverItem extends Item {

    public ScrewdriverItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState currentBlockState = level.getBlockState(blockPos);

        // --- 1. Server-Side Check ---
        // Crucial: Only execute the rotation logic on the server.
        if (level.isClientSide) {
            // We still return SUCCESS on the client to ensure the item swinging animation plays.
            return InteractionResult.SUCCESS;
        }

        // --- 2. Determine Rotation Type ---
        boolean isShiftClick = player != null && player.isCrouching();
        Rotation rotationToApply = isShiftClick ? Rotation.CLOCKWISE_180 : Rotation.CLOCKWISE_90;

        BlockState newBlockState = null;

        // --- 3. Attempt Standard Rotation ---
        // This works for most directional blocks (furnaces, pistons, etc.)
        newBlockState = currentBlockState.rotate(level, blockPos, rotationToApply);

        // --- 4. Fallback for AXIS Blocks (Logs, Pillars) ---
        // If standard rotation failed AND the block has an AXIS property, apply manual cycle logic.
        // Rotation.CLOCKWISE_180 is handled by applying Rotation.CLOCKWISE_90 twice.
        if (newBlockState.equals(currentBlockState) && currentBlockState.hasProperty(BlockStateProperties.AXIS)) {

            // Apply a single 90-degree rotation (X -> Z -> Y -> X)
            newBlockState = cycleAxis(currentBlockState);

            // If it was a 180-degree rotation (shift-click), apply the cycle a second time
            if (isShiftClick) {
                newBlockState = cycleAxis(newBlockState);
            }
        }

        // --- 5. Apply and Finalize ---
        if (!newBlockState.equals(currentBlockState)) {
            // Set the new block state in the world
            level.setBlock(blockPos, newBlockState, 3);

            // Give the player visual feedback
            if (player != null) {
                player.swing(context.getHand());
            }

            return InteractionResult.SUCCESS;
        }

        // If no change occurred (e.g., clicked dirt)
        return InteractionResult.PASS;
    }

    /**
     * Cycles the AXIS property (used by logs and pillars) in the order X -> Z -> Y -> X...
     * @param state The current BlockState.
     * @return The new BlockState with the cycled AXIS.
     */
    private BlockState cycleAxis(BlockState state) {
        Axis currentAxis = state.getValue(BlockStateProperties.AXIS);
        if (currentAxis == Axis.X) {
            return state.setValue(BlockStateProperties.AXIS, Axis.Y);
        } else if (currentAxis == Axis.Y) {
            return state.setValue(BlockStateProperties.AXIS, Axis.Z);
        } else { // Current Axis is Z
            return state.setValue(BlockStateProperties.AXIS, Axis.X);
        }
    }
}