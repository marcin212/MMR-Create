package com.bymarcin.mmrcreate.datagen;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.MMRCreateTags;
import com.bymarcin.mmrcreate.registration.BlockRegistration;
import es.degrassi.mmreborn.data.MMRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MMRItemTagProvider extends ItemTagsProvider {
    public MMRItemTagProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> completableFuture2, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, completableFuture, completableFuture2, MMRCreate.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(MMRTags.Items.ALL_CASINGS).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get().asItem()
        );

        tag(MMRCreateTags.Items.KINETIC).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get().asItem()
        );

        tag(MMRCreateTags.Items.KINETIC_INPUT).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get().asItem(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get().asItem()
        );

        tag(MMRCreateTags.Items.KINETIC_INPUT_SLOW).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get().asItem()
        );
        tag(MMRCreateTags.Items.KINETIC_INPUT_MEDIUM).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get().asItem()
        );

        tag(MMRCreateTags.Items.KINETIC_INPUT_FAST).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get().asItem(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get().asItem(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get().asItem(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get().asItem(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get().asItem(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get().asItem(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get().asItem(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get().asItem()
        );
    }
}
