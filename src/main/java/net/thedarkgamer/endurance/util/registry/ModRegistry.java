package net.thedarkgamer.endurance.util.registry;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import net.minecraft.Bootstrap;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.thedarkgamer.endurance.item.ModItems;
import net.thedarkgamer.endurance.util.ModItem;
import net.thedarkgamer.endurance.util.rarity.ModRarity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import java.util.*;
import java.util.function.Supplier;


public class ModRegistry<T> extends Registry<T> implements Codec<T> {
    private static final Map<Identifier, Supplier<?>> DEFAULT_ENTRIES = Maps.newLinkedHashMap();
    protected static final ModMutableRegistry<ModMutableRegistry> ROOT = new ModSimpleRegistry(createRegistryKey("root"), Lifecycle.experimental());
    public static final Identifier ROOT_KEY = new Identifier("root");
    public static final ModRegistryKey<ModRegistry<ModItem>> CUSTOM_ITEM_KEY = ModRegistry.createModRegistryKey("modItem");
    public static final RegistryKey<Registry<ModItem>> CUSTOM_ITEM_REGISTRY_KEY = ModRegistry.createRegistryKey("modItem");
    //public static final ModRegistry<ModItem> CUSTOM_ITEM = ModRegistry.createModSimple(CUSTOM_ITEM_KEY, () -> ModItems.RAW_TIN);

    protected ModRegistry(RegistryKey<? extends Registry<T>> key, Lifecycle lifecycle) {
        super(key, lifecycle);
    }

    public static <T> ModRegistryKey<ModRegistry<T>> createModRegistryKey(String registryId) {
        return ModRegistryKey.ofModRegistry(new Identifier(registryId));
    }

    public static <T> RegistryKey<Registry<T>> createRegistryKey(String registryId) {
        return RegistryKey.ofRegistry(new Identifier(registryId));
    }

    /*public static <T> ModRegistry<T> createModSimple(ModRegistryKey<? extends ModRegistry<T>> key, Supplier<ModItem> defaultEntry) {
        return createModSimpleRegistry(key, Lifecycle.experimental(), defaultEntry);
    }

    public static <T> ModDefaultedRegistry<T> createModDefaulted(ModRegistryKey<? extends ModRegistry<T>> key, String defaultId, Supplier<ModItem> defaultEntry) {
        return ModRegistry.createModDefaultedRegistry(key, defaultId, Lifecycle.experimental(), defaultEntry);
    }

    public static <T> ModSimpleRegistry<T> createModSimpleRegistry(ModRegistryKey<? extends ModRegistry<T>> key, Lifecycle lifecycle, Supplier<ModItem> defaultEntry) {
        return create(key, new ModSimpleRegistry(key, lifecycle), lifecycle, defaultEntry);
    }

    public static <T> ModDefaultedRegistry<T> createModDefaultedRegistry(ModRegistryKey<? extends ModRegistry<T>> key, String defaultId, Lifecycle lifecycle, Supplier<ModItem> defaultEntry) {
        return create(key, new ModDefaultedRegistry(defaultId, key, lifecycle), lifecycle, defaultEntry);
    }

    public static void create(ModRegistryKey<? extends ModRegistry<T>> key, ModSimpleRegistry<?> registry, Lifecycle lifecycle, Supplier<ModItem> defaultEntry ) {
        Identifier identifier = key.getValue();
        DEFAULT_ENTRIES.put(identifier, defaultEntry);
        ModMutableRegistry<ModMutableRegistry> mutableRegistry = ROOT;
        //return mutableRegistry.add(key, registry, lifecycle);
    }*/

    @Nullable
    public Identifier getId(T entry) {
        return null;
    }

    @Override
    public Optional<RegistryKey<T>> getKey(T entry) {
        return Optional.empty();
    }

    public Optional<ModRegistryKey<T>> getModKey(T entry) {
        return Optional.empty();
    }

    public int getRawId(@Nullable T entry) {
        return 0;
    }

    @Nullable
    public T get(int index) {
        return null;
    }

    @Nullable
    public T get(@Nullable RegistryKey<T> key) {
        return null;
    }

    @Nullable
    public T get(@Nullable Identifier id) {
        return null;
    }

    protected Lifecycle getEntryLifecycle(T entry) {
        return null;
    }

    public Lifecycle getLifecycle() {
        return null;
    }

    public Set<Identifier> getIds() {
        return null;
    }

    @Override
    public Set<Map.Entry<RegistryKey<T>, T>> getEntries() {
        return null;
    }

    public Set<Map.Entry<ModRegistryKey<T>, T>> getModEntries() {
        return null;
    }

    @Nullable
    public T getRandom(Random random) {
        return null;
    }

    public boolean containsId(Identifier id) {
        return false;
    }

    @Override
    public boolean contains(RegistryKey<T> key) {
        return false;
    }

    public boolean contains(ModRegistryKey<T> key) {
        return false;
    }

    @NotNull
    public Iterator<T> iterator() {
        return null;
    }
}
