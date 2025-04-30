package com.bymarcin.mmrcreate.datagen;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.MMRCreateTags;
import com.bymarcin.mmrcreate.registration.BlockRegistration;
import es.degrassi.mmreborn.data.MMRTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MMRBlockTagProvider extends BlockTagsProvider {
    public MMRBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MMRCreate.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(MMRTags.Blocks.ALL_CASINGS).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get()
        );

        tag(MMRCreateTags.Blocks.KINETIC).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get()
        );

        tag(MMRCreateTags.Blocks.KINETIC_INPUT).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get(),
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get()
        );

        tag(MMRCreateTags.Blocks.KINETIC_INPUT_SLOW).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW.get()
        );
        tag(MMRCreateTags.Blocks.KINETIC_INPUT_MEDIUM).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM.get()
        );

        tag(MMRCreateTags.Blocks.KINETIC_INPUT_FAST).add(
                // TINY
                BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST.get(),

                // SMALL
                BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST.get(),

                // NORMAL
                BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST.get(),

                // REINFORCED
                BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST.get(),

                // BIG
                BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST.get(),

                // HUGE
                BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST.get(),

                // LUDICROUS
                BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST.get(),

                // VACUUM
                BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST.get()
        );
    }
}
