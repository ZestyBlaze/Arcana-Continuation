package dev.zestyblaze.arcana.datagen.provider;

import dev.zestyblaze.arcana.data.State;
import dev.zestyblaze.arcana.data.Structure;
import dev.zestyblaze.arcana.datamap.ArcanaDataHolder;
import dev.zestyblaze.arcana.datamap.ArcanaDataMaps;
import dev.zestyblaze.arcana.event.ArcanaRegistries;
import dev.zestyblaze.arcana.world.States;
import dev.zestyblaze.arcana.world.Structures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("deprecation")
public class ArcanaDataMapGenerator extends DataMapProvider {
    public ArcanaDataMapGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        HolderGetter<State> states = provider.lookupOrThrow(ArcanaRegistries.STATE_KEY);
        HolderGetter<Structure> structures = provider.lookupOrThrow(ArcanaRegistries.STRUCTURE_KEY);

        Builder<ArcanaDataHolder, Item> holders = builder(ArcanaDataMaps.DATA_HOLDER);

        holders.add(Items.COBBLESTONE.builtInRegistryHolder(), new ArcanaDataHolder(
                List.of(states.getOrThrow(States.SOLID)),
                List.of(structures.getOrThrow(Structures.AMORPHOUS).value())
        ), false);
        holders.add(Items.STONE.builtInRegistryHolder(), new ArcanaDataHolder(
                List.of(states.getOrThrow(States.SOLID)),
                List.of(structures.getOrThrow(Structures.AMORPHOUS).value())
        ), false);
        holders.add(Items.GRASS_BLOCK.builtInRegistryHolder(), new ArcanaDataHolder(
                List.of(states.getOrThrow(States.SOLID))
        ), false);
        holders.add(Items.DIRT.builtInRegistryHolder(), new ArcanaDataHolder(
                List.of(states.getOrThrow(States.SOLID))
        ), false);
    }
}
