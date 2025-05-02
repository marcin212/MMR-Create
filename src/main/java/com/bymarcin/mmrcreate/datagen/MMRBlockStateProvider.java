package com.bymarcin.mmrcreate.datagen;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.registration.BlockRegistration;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MMRBlockStateProvider extends BlockStateProvider {
    public static final String TINY = "tiny";
    public static final String SMALL = "small";
    public static final String NORMAL = "normal";
    public static final String REINFORCED = "reinforced";
    public static final String BIG = "big";
    public static final String HUGE = "huge";
    public static final String LUDICROUS = "ludicrous";
    public static final String VACUUM = "vacuum";
    public static final String INPUT = "input";
    public static final String OUTPUT = "output";


    public MMRBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MMRCreate.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // TINY
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW, TINY, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_TINY_MEDIUM, TINY, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_TINY_FAST, TINY, INPUT);

        // SMALL
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_SLOW, SMALL, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_MEDIUM, SMALL, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_SMALL_FAST, SMALL, INPUT);

        // NORMAL
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_SLOW, NORMAL, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_MEDIUM, NORMAL, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_NORMAL_FAST, NORMAL, INPUT);

        // REINFORCED
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_SLOW, REINFORCED, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_MEDIUM, REINFORCED, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_REINFORCED_FAST, REINFORCED, INPUT);

        // BIG
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_BIG_SLOW, BIG, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_BIG_MEDIUM, BIG, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_BIG_FAST, BIG, INPUT);

        // HUGE
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_SLOW, HUGE, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_MEDIUM, HUGE, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_HUGE_FAST, HUGE, INPUT);

        // LUDICROUS
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_SLOW, LUDICROUS, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_MEDIUM, LUDICROUS, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_LUDICROUS_FAST, LUDICROUS, INPUT);

        // VACUUM
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_SLOW, VACUUM, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_MEDIUM, VACUUM, INPUT);
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_VACUUM_FAST, VACUUM, INPUT);

    }

    private ModelFile createHatchModel(String tier, String speed, String direction) {
        return models().withExistingParent(String.format("kinetic_%s_hatch_%s_%s", direction, tier, speed), modLoc(String.format("block/kinetic_%s_hatch", direction)))
                .texture("frame", modLoc(String.format("block/andesite_hatch_frame_%s", tier)))
                .texture("back", modLoc(String.format("block/hatch_%s", direction)))
                .texture("casing", modLoc(String.format("block/casing_plain_%s", speed)));
    }


    private void createStateFor(BlockEntry<?> blockEntry, String tier, String direction) {
        Block block = blockEntry.get();
        IRotate rotate = (IRotate) block;
        ModelFile modelFile = createHatchModel(tier, rotate.getMinimumRequiredSpeedLevel().toString().toLowerCase(), direction);
        getVariantBuilder(block)
                .forAllStates((state) -> switch (state.getValue(BlockStateProperties.FACING)) {
                    case NORTH -> ConfiguredModel.builder().rotationX(90).modelFile(modelFile).build();
                    case SOUTH -> ConfiguredModel.builder().rotationX(90).rotationY(180).modelFile(modelFile).build();
                    case EAST -> ConfiguredModel.builder().rotationX(90).rotationY(90).modelFile(modelFile).build();
                    case WEST -> ConfiguredModel.builder().rotationX(90).rotationY(270).modelFile(modelFile).build();
                    case DOWN -> ConfiguredModel.builder().rotationX(180).modelFile(modelFile).build();
                    default -> ConfiguredModel.builder().modelFile(modelFile).build();
                });

        simpleBlockItem(block, modelFile);
    }

}
