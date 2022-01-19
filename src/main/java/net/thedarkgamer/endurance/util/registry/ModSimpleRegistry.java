package net.thedarkgamer.endurance.util.registry;

import com.google.common.collect.*;
import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenCustomHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.RegistryKey;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ModSimpleRegistry<T> extends ModMutableRegistry<T> {
        protected static final Logger LOGGER = LogManager.getLogger();
        private final ObjectList<T> rawIdToEntry = new ObjectArrayList<T>(256);
        private final Object2IntMap<T> entryToRawId = new Object2IntOpenCustomHashMap<T>(Util.identityHashStrategy());
        private final BiMap<Identifier, T> idToEntry;
        private final BiMap<ModRegistryKey<T>, T> keyToEntry;
        private final Map<T, Lifecycle> entryToLifecycle;
        private Lifecycle lifecycle;
        protected Object[] randomEntries;
        private int nextId;

        public ModSimpleRegistry(RegistryKey<? extends ModRegistry<T>> registryKey, Lifecycle lifecycle) {
            super(registryKey, lifecycle);
            this.entryToRawId.defaultReturnValue(-1);
            this.idToEntry = HashBiMap.create();
            this.keyToEntry = HashBiMap.create();
            this.entryToLifecycle = Maps.newIdentityHashMap();
            this.lifecycle = lifecycle;
        }

        @Override
        public <V extends ModMutableRegistry<T>> V set(int rawId, ModRegistryKey<T> key, V entry, Lifecycle lifecycle) {
            return this.set(rawId, key, entry, lifecycle, true);
        }

        private <V extends ModMutableRegistry<T>> V set(int rawId, ModRegistryKey<T> key, ModMutableRegistry<T> entry, Lifecycle lifecycle, boolean checkDuplicateKeys) {
            Validate.notNull(key);
            Validate.notNull(entry);
            this.rawIdToEntry.size(Math.max(this.rawIdToEntry.size(), rawId + 1));
            this.rawIdToEntry.set(rawId, (T) entry);
            this.entryToRawId.put((T)entry, rawId);
            this.randomEntries = null;
            if (checkDuplicateKeys && this.keyToEntry.containsKey(key)) {
                LOGGER.debug("Adding duplicate key '{}' to registry", (Object)key);
            }
            if (this.idToEntry.containsValue(entry)) {
                LOGGER.error("Adding duplicate value '{}' to registry", (Object)entry);
            }
            this.idToEntry.put(key.getValue(), (T) entry);
            this.keyToEntry.put(key, (T) entry);
            this.entryToLifecycle.put((T) entry, lifecycle);
            this.lifecycle = this.lifecycle.add(lifecycle);
            if (this.nextId <= rawId) {
                this.nextId = rawId + 1;
            }
            return (V) entry;
        }

        @Override
        public <V extends ModMutableRegistry<T>> V add(ModRegistryKey<T> key, V entry, Lifecycle lifecycle) {
            return this.set(this.nextId, key, entry, lifecycle);
        }

        @Override
        public <V extends T> V replace(OptionalInt rawId, ModRegistryKey<T> key, V newEntry, Lifecycle lifecycle) {
            int i;
            Validate.notNull(key);
            Validate.notNull(newEntry);
            Object object = this.keyToEntry.get(key);
            if (object == null) {
                i = rawId.isPresent() ? rawId.getAsInt() : this.nextId;
            } else {
                i = this.entryToRawId.getInt(object);
                if (rawId.isPresent() && rawId.getAsInt() != i) {
                    throw new IllegalStateException("ID mismatch");
                }
                this.entryToRawId.removeInt(object);
                this.entryToLifecycle.remove(object);
            }
            return (V) this.set(i, key, (ModMutableRegistry<T>) newEntry, lifecycle, false);
        }

        @Override
        @Nullable
        public Identifier getId(T entry) {
            return (Identifier)this.idToEntry.inverse().get(entry);
        }

        @Override
        public Optional<ModRegistryKey<T>> getModKey(T entry) {
            return Optional.ofNullable((ModRegistryKey)this.keyToEntry.inverse().get(entry));
        }

        @Override
        public int getRawId(@Nullable T entry) {
            return this.entryToRawId.getInt(entry);
        }

        @Override
        @Nullable
        public T get(@Nullable RegistryKey<T> key) {
            return (T)this.keyToEntry.get(key);
        }

        @Override
        @Nullable
        public T get(int index) {
            if (index < 0 || index >= this.rawIdToEntry.size()) {
                return null;
            }
            return (T)this.rawIdToEntry.get(index);
        }

        @Override
        public Lifecycle getEntryLifecycle(T entry) {
            return this.entryToLifecycle.get(entry);
        }

        @Override
        public Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public Iterator<T> iterator() {
            return Iterators.filter(this.rawIdToEntry.iterator(), Objects::nonNull);
        }

        @Override
        @Nullable
        public T get(@Nullable Identifier id) {
            return (T)this.idToEntry.get(id);
        }

        @Override
        public Set<Identifier> getIds() {
            return Collections.unmodifiableSet(this.idToEntry.keySet());
        }

        @Override
        public Set<Map.Entry<ModRegistryKey<T>, T>> getModEntries() {
            return Collections.unmodifiableMap(this.keyToEntry).entrySet();
        }

        @Override
        public boolean isEmpty() {
            return this.idToEntry.isEmpty();
        }

        @Override
        @Nullable
        public T getRandom(Random random) {
            if (this.randomEntries == null) {
                Collection collection = this.idToEntry.values();
                if (collection.isEmpty()) {
                    return null;
                }
                this.randomEntries = collection.toArray(new Object[collection.size()]);
            }
            return (T)Util.getRandom(this.randomEntries, random);
        }

        @Override
        public boolean containsId(Identifier id) {
            return this.idToEntry.containsKey(id);
        }

        @Override
        public boolean contains(ModRegistryKey<T> key) {
            return this.keyToEntry.containsKey(key);
        }
}
