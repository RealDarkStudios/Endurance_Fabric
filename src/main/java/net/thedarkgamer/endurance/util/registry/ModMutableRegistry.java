package net.thedarkgamer.endurance.util.registry;
import com.mojang.serialization.Lifecycle;

import java.util.Optional;
import java.util.OptionalInt;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public abstract class ModMutableRegistry<T>
        extends ModRegistry<T> {
    public ModMutableRegistry(RegistryKey<? extends ModRegistry<T>> registryKey, Lifecycle lifecycle) {
        super(registryKey, lifecycle);
    }

public abstract <V extends ModMutableRegistry<T>> V set(int var1, ModRegistryKey<T> var2, V var3, Lifecycle var4);

    public abstract <V extends ModMutableRegistry<T>> V add(ModRegistryKey<T> var1, V var2, Lifecycle var3);

    /**
     * If the given key is already present in the registry, replaces the entry associated with the given
     * key with the new entry. This method asserts that the raw ID is equal to the value already in
     * the registry. The raw ID not being present may lead to buggy behavior.
     *
     * <p>If the given key is not already present in the registry, adds the entry to the registry. If
     * {@code rawId} is present, then this method gives the entry this raw ID. Otherwise, uses the
     * next available ID.
     */
    public abstract <V extends T> V replace(OptionalInt var1, ModRegistryKey<T> var2, V var3, Lifecycle var4);

    public abstract boolean isEmpty();
}