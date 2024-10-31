package dev.zestyblaze.arcana.datamap;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.zestyblaze.arcana.data.State;
import dev.zestyblaze.arcana.data.Structure;
import dev.zestyblaze.arcana.event.ArcanaRegistries;
import net.minecraft.core.Holder;

import java.util.ArrayList;
import java.util.List;

public record ArcanaDataHolder(List<Holder<State>> states, List<Holder<Structure>> structures) {
    public static final Codec<ArcanaDataHolder> CODEC = RecordCodecBuilder.create(func -> func.group(
            ArcanaRegistries.STATE_REGISTRY.listOf().fieldOf("states").forGetter(ArcanaDataHolder::states),
            ArcanaRegistries.STRUCTURE_REGISTRY.listOf().optionalFieldOf("structures", new ArrayList<>()).forGetter(ArcanaDataHolder::structures)
    ).apply(func, ArcanaDataHolder::new));

    public ArcanaDataHolder(List<Holder<State>> states) {
        this(states, new ArrayList<>());
    }
}
