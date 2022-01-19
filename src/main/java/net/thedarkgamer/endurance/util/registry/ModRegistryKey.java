package net.thedarkgamer.endurance.util.registry;

import com.google.common.collect.Maps;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

public class ModRegistryKey<T> {
    private static final Map<String, ModRegistryKey<?>> INSTANCES = Collections.synchronizedMap(Maps.newIdentityHashMap());
    private final Identifier registry;
    private final Identifier value;

    public ModRegistryKey(Identifier registry, Identifier value) {
        this.registry = registry;
        this.value = value;
    }

    public static <T> ModRegistryKey<T> of(ModRegistryKey<? extends ModRegistry<T>> registry, Identifier value) {
        return ModRegistryKey.modOf(registry.getValue(), value);
    }

    public static <T> ModRegistryKey<ModRegistry<T>> ofModRegistry(Identifier registry) {
        return ModRegistryKey.modOf(ModRegistry.ROOT_KEY, registry);
    }

    private static <T> ModRegistryKey<T> modOf(Identifier registry, Identifier value) {
        String string2 = (registry + ":" + value).intern();
        return (ModRegistryKey<T>) INSTANCES.computeIfAbsent(string2, string -> new ModRegistryKey(registry, value));
    }

    public String toString() {
        return "ResourceKey[" + this.registry + " / " + this.value + "]";
    }

    /**
     * Returns whether this registry key belongs to the given registry (according to its type, not whether the registry actually contains this key).
     *
     * @param registry the key of the registry that this registry key should be inside
     */
    public boolean isOf(RegistryKey<? extends Registry<?>> registry) {
        return this.registry.equals(registry.getValue());
    }

    public Identifier getValue() {
        return this.value;
    }

    /**
     * Creates a function that converts an identifier to a registry key for the
     * registry that {@code registry} refers to in the root registry.
     *
     * @param registry the reference to the value-holding registry in the root registry
     */
    public static <T> Function<Identifier, ModRegistryKey<T>> createKeyFactory(Identifier registry) {
        return id -> ModRegistryKey.modOf(registry, id);
    }
}
