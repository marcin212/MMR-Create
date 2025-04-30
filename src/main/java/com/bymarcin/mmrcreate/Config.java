package com.bymarcin.mmrcreate;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;


@EventBusSubscriber(modid = MMRCreate.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    private static final ModConfigSpec.IntValue TINY_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for tiny input hatch with slow speed requirements")
            .defineInRange("tiny_slow_speed_input_stress_impact", 1, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue TINY_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for tiny input hatch with medium speed requirements")
            .defineInRange("tiny_medium_speed_input_stress_impact", 1, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue TINY_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for tiny input hatch with fast speed requirements")
            .defineInRange("tiny_fast_speed_input_stress_impact", 1, 1, Integer.MAX_VALUE);

    // --- SMALL ---
    private static final ModConfigSpec.IntValue SMALL_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for small input hatch with slow speed requirements")
            .defineInRange("small_slow_speed_input_stress_impact", 2, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue SMALL_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for small input hatch with medium speed requirements")
            .defineInRange("small_medium_speed_input_stress_impact", 2, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue SMALL_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for small input hatch with fast speed requirements")
            .defineInRange("small_fast_speed_input_stress_impact", 2, 1, Integer.MAX_VALUE);

    // --- NORMAL ---
    private static final ModConfigSpec.IntValue NORMAL_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for normal input hatch with slow speed requirements")
            .defineInRange("normal_slow_speed_input_stress_impact", 4, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue NORMAL_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for normal input hatch with medium speed requirements")
            .defineInRange("normal_medium_speed_input_stress_impact", 4, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue NORMAL_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for normal input hatch with fast speed requirements")
            .defineInRange("normal_fast_speed_input_stress_impact", 4, 1, Integer.MAX_VALUE);

    // --- REINFORCED ---
    private static final ModConfigSpec.IntValue REINFORCED_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for reinforced input hatch with slow speed requirements")
            .defineInRange("reinforced_slow_speed_input_stress_impact", 8, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue REINFORCED_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for reinforced input hatch with medium speed requirements")
            .defineInRange("reinforced_medium_speed_input_stress_impact", 8, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue REINFORCED_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for reinforced input hatch with fast speed requirements")
            .defineInRange("reinforced_fast_speed_input_stress_impact", 8, 1, Integer.MAX_VALUE);

    // --- BIG ---
    private static final ModConfigSpec.IntValue BIG_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for big input hatch with slow speed requirements")
            .defineInRange("big_slow_speed_input_stress_impact", 16, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue BIG_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for big input hatch with medium speed requirements")
            .defineInRange("big_medium_speed_input_stress_impact", 16, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue BIG_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for big input hatch with fast speed requirements")
            .defineInRange("big_fast_speed_input_stress_impact", 16, 1, Integer.MAX_VALUE);

    // --- HUGE ---
    private static final ModConfigSpec.IntValue HUGE_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for huge input hatch with slow speed requirements")
            .defineInRange("huge_slow_speed_input_stress_impact", 32, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue HUGE_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for huge input hatch with medium speed requirements")
            .defineInRange("huge_medium_speed_input_stress_impact", 32, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue HUGE_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for huge input hatch with fast speed requirements")
            .defineInRange("huge_fast_speed_input_stress_impact", 32, 1, Integer.MAX_VALUE);

    // --- LUDICROUS ---
    private static final ModConfigSpec.IntValue LUDICROUS_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for ludicrous input hatch with slow speed requirements")
            .defineInRange("ludicrous_slow_speed_input_stress_impact", 64, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue LUDICROUS_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for ludicrous input hatch with medium speed requirements")
            .defineInRange("ludicrous_medium_speed_input_stress_impact", 64, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue LUDICROUS_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for ludicrous input hatch with fast speed requirements")
            .defineInRange("ludicrous_fast_speed_input_stress_impact", 64, 1, Integer.MAX_VALUE);

    // --- VACUUM ---
    private static final ModConfigSpec.IntValue VACUUM_SLOW_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for vacuum input hatch with slow speed requirements")
            .defineInRange("vacuum_slow_speed_input_stress_impact", 128, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue VACUUM_MEDIUM_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for vacuum input hatch with medium speed requirements")
            .defineInRange("vacuum_medium_speed_input_stress_impact", 128, 1, Integer.MAX_VALUE);
    private static final ModConfigSpec.IntValue VACUUM_FAST_SPEED_INPUT_STRESS_IMPACT = BUILDER
            .comment("Stress impact for vacuum input hatch with fast speed requirements")
            .defineInRange("vacuum_fast_speed_input_stress_impact", 128, 1, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();

    // --- TINY ---
    public static int tinySlowSpeedInputStressImpact;
    public static int tinyMediumSpeedInputStressImpact;
    public static int tinyFastSpeedInputStressImpact;

    // --- SMALL ---
    public static int smallSlowSpeedInputStressImpact;
    public static int smallMediumSpeedInputStressImpact;
    public static int smallFastSpeedInputStressImpact;

    // --- NORMAL ---
    public static int normalSlowSpeedInputStressImpact;
    public static int normalMediumSpeedInputStressImpact;
    public static int normalFastSpeedInputStressImpact;

    // --- REINFORCED ---
    public static int reinforcedSlowSpeedInputStressImpact;
    public static int reinforcedMediumSpeedInputStressImpact;
    public static int reinforcedFastSpeedInputStressImpact;

    // --- BIG ---
    public static int bigSlowSpeedInputStressImpact;
    public static int bigMediumSpeedInputStressImpact;
    public static int bigFastSpeedInputStressImpact;

    // --- HUGE ---
    public static int hugeSlowSpeedInputStressImpact;
    public static int hugeMediumSpeedInputStressImpact;
    public static int hugeFastSpeedInputStressImpact;

    // --- LUDICROUS ---
    public static int ludicrousSlowSpeedInputStressImpact;
    public static int ludicrousMediumSpeedInputStressImpact;
    public static int ludicrousFastSpeedInputStressImpact;

    // --- VACUUM ---
    public static int vacuumSlowSpeedInputStressImpact;
    public static int vacuumMediumSpeedInputStressImpact;
    public static int vacuumFastSpeedInputStressImpact;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        // --- TINY ---
        tinySlowSpeedInputStressImpact = TINY_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        tinyMediumSpeedInputStressImpact = TINY_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        tinyFastSpeedInputStressImpact = TINY_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- SMALL ---
        smallSlowSpeedInputStressImpact = SMALL_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        smallMediumSpeedInputStressImpact = SMALL_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        smallFastSpeedInputStressImpact = SMALL_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- NORMAL ---
        normalSlowSpeedInputStressImpact = NORMAL_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        normalMediumSpeedInputStressImpact = NORMAL_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        normalFastSpeedInputStressImpact = NORMAL_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- REINFORCED ---
        reinforcedSlowSpeedInputStressImpact = REINFORCED_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        reinforcedMediumSpeedInputStressImpact = REINFORCED_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        reinforcedFastSpeedInputStressImpact = REINFORCED_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- BIG ---
        bigSlowSpeedInputStressImpact = BIG_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        bigMediumSpeedInputStressImpact = BIG_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        bigFastSpeedInputStressImpact = BIG_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- HUGE ---
        hugeSlowSpeedInputStressImpact = HUGE_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        hugeMediumSpeedInputStressImpact = HUGE_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        hugeFastSpeedInputStressImpact = HUGE_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- LUDICROUS ---
        ludicrousSlowSpeedInputStressImpact = LUDICROUS_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        ludicrousMediumSpeedInputStressImpact = LUDICROUS_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        ludicrousFastSpeedInputStressImpact = LUDICROUS_FAST_SPEED_INPUT_STRESS_IMPACT.get();

        // --- VACUUM ---
        vacuumSlowSpeedInputStressImpact = VACUUM_SLOW_SPEED_INPUT_STRESS_IMPACT.get();
        vacuumMediumSpeedInputStressImpact = VACUUM_MEDIUM_SPEED_INPUT_STRESS_IMPACT.get();
        vacuumFastSpeedInputStressImpact = VACUUM_FAST_SPEED_INPUT_STRESS_IMPACT.get();
    }
}
