package net.thedarkgamer.endurance.util.registry;

import com.mojang.serialization.Lifecycle;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Random;

/*public class ModDefaultedRegistry<T>
        extends ModSimpleRegistry<T> {
    private final Identifier defaultId;
    private T defaultValue;

    public ModDefaultedRegistry(String defaultId, ModRegistryKey<? extends ModRegistry<T>> key, Lifecycle lifecycle) {
        super(key, lifecycle);
        this.defaultId = new Identifier(defaultId);
    }

    @Override
    public <V extends T> V set(int rawId, ModRegistryKey<T> key, V entry, Lifecycle lifecycle) {
        if (this.defaultId.equals(key.getValue())) {
            this.defaultValue = entry;
        }
        return super.set(rawId, key, entry, lifecycle);
    }

    @Override
    public int getRawId(@Nullable T entry) {
        int i = super.getRawId(entry);
        return i == -1 ? super.getRawId(this.defaultValue) : i;
    }

    @Override
    @NotNull
    public Identifier getId(T entry) {
        Identifier identifier = super.getId(entry);
        return identifier == null ? this.defaultId : identifier;
    }

    @Override
    @NotNull
    public T get(@Nullable Identifier id) {
        Object object = super.get(id);
        return object == null ? this.defaultValue : (T) object;
    }

    public Optional<T> getOrEmpty(@Nullable Identifier id) {
        return Optional.ofNullable(super.get(id));
    }

    @Override
    @NotNull
    public T get(int index) {
        Object object = super.get(index);
        return object == null ? this.defaultValue : (T) object;
    }

    @Override
    @NotNull
    public T getRandom(Random random) {
        Object object = super.getRandom(random);
        return object == null ? this.defaultValue : (T) object;
    }

    public Identifier getDefaultId() {
        return this.defaultId;
    }
}*/

