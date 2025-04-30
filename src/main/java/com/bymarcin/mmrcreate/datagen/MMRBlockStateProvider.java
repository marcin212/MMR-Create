package com.bymarcin.mmrcreate.datagen;

import com.bymarcin.mmrcreate.MMRCreate;
import com.bymarcin.mmrcreate.registration.BlockRegistration;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class MMRBlockStateProvider extends BlockStateProvider {

    public MMRBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MMRCreate.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile kineticInputHatchModel = models().getExistingFile(modLoc("block/kinetic_input_hatch"));
        createStateFor(BlockRegistration.KINETIC_INPUT_HATCH_TINY_SLOW, kineticInputHatchModel);
    }

    private void createStateFor(BlockEntry<?> blockEntry, ModelFile modelFile) {
        getVariantBuilder(blockEntry.get())
                .forAllStates((state) -> switch (state.getValue(BlockStateProperties.FACING)) {
                    case NORTH ->
                            ConfiguredModel.builder().rotationX(90).modelFile(modelFile).build();
                    case SOUTH ->
                            ConfiguredModel.builder().rotationX(90).rotationY(180).modelFile(modelFile).build();
                    case EAST ->
                            ConfiguredModel.builder().rotationX(90).rotationY(90).modelFile(modelFile).build();
                    case WEST ->
                            ConfiguredModel.builder().rotationX(90).rotationY(270).modelFile(modelFile).build();
                    case DOWN ->
                            ConfiguredModel.builder().rotationX(180).modelFile(modelFile).build();
                    default ->
                            ConfiguredModel.builder().modelFile(modelFile).build();
                });

        simpleBlockItem(blockEntry.get(), modelFile);
    }

}
