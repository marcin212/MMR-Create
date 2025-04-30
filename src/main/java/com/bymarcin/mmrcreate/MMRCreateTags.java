package com.bymarcin.mmrcreate;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MMRCreateTags {
    private static TagKey<Block> blockTag(String name, boolean isNeoForge) {
        return BlockTags.create(isNeoForge ? ResourceLocation.fromNamespaceAndPath("c", name) : MMRCreate.rl(name));
    }

    private static TagKey<Item> itemTag(String name, boolean isNeoForge) {
        return ItemTags.create(isNeoForge ? ResourceLocation.fromNamespaceAndPath("c", name) : MMRCreate.rl(name));
    }

    private static class Tag<T> {
        private final TagKey<T> tag;
        protected Tag(TagKey<T> tag) {
            this.tag = tag;
        }

        public TagKey<T> get() {
            return tag;
        }
    }

    public static class Blocks extends Tag<Block> {
        public static final TagKey<Block> KINETIC = new Blocks(false, "kinetic_hatch").get();
        public static final TagKey<Block> KINETIC_INPUT = new Blocks(false, "kinetic_input_hatch").get();
        public static final TagKey<Block> KINETIC_INPUT_SLOW = new Blocks(false, "kinetic_input_hatch/slow").get();
        public static final TagKey<Block> KINETIC_INPUT_MEDIUM = new Blocks(false, "kinetic_input_hatch/medium").get();
        public static final TagKey<Block> KINETIC_INPUT_FAST = new Blocks(false, "kinetic_input_hatch/fast").get();

        private Blocks(boolean isNeoForge, String name) {
            super(blockTag(name, isNeoForge));
        }
    }

    public static class Items extends Tag<Item> {
        public static final TagKey<Item> KINETIC = new Items(false, "kinetic_hatch").get();
        public static final TagKey<Item> KINETIC_INPUT = new Items(false, "kinetic_input_hatch").get();
        public static final TagKey<Item> KINETIC_INPUT_SLOW = new Items(false, "kinetic_input_hatch/slow").get();
        public static final TagKey<Item> KINETIC_INPUT_MEDIUM = new Items(false, "kinetic_input_hatch/medium").get();
        public static final TagKey<Item> KINETIC_INPUT_FAST = new Items(false, "kinetic_input_hatch/fast").get();
        private Items(boolean isNeoForge, String name) {
            super(itemTag(name, isNeoForge));
        }
    }
}
