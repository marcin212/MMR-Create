# Modular Machinery Reborn Create

Modular Machinery Reborn Create is an addon of Modular Machinery Reborn mod

This mod can be used to add kinetic power on the Modular Machinery Reborn custom multiblock machines.

## KubeJS Example

```
ServerEvents.recipes(event => {
    event.recipes.modular_machinery_reborn.machine_recipe("mmr:testing", 150)
        .requireItem("1x minecraft:oak_log", 16, 16)
        .produceItem('1x minecraft:oak_planks', 16+ 22,  16 )
        .requireKinetic(1024, 16, 42)
})


MMREvents.machines(event => {
    event.create("mmr:testing")
        .name('Testing Kinetic machineJS')
        .structure(
            MMRStructureBuilder.create()
                .pattern(
                    [
                        ["mklio"],
                    ]
                )
                .keys(
                    {
                        "k": "#mmrcreate:kinetic_input_hatch/medium",
                        "l": "minecraft:iron_block",
                        "i": "#modular_machinery_reborn:inputbus",
                        "o": "#modular_machinery_reborn:outputbus"
                    }
                )
        )
        .controllerModel(ControllerModel.of("minecraft:furnace"))
})
```

## Available Tags

```
#mmrcreate:kinetic_hatch
#mmrcreate:kinetic_input_hatch
#mmrcreate:kinetic_input_hatch/slow
#mmrcreate:kinetic_input_hatch/medium
#mmrcreate:kinetic_input_hatch/fast
```

## Download

Download this mod on **TODO**

Btw you are free to use this mod in any modpack.