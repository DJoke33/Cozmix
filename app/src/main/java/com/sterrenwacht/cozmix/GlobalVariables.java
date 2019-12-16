package com.sterrenwacht.cozmix;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class GlobalVariables extends Application {
    private Map<String, Integer> persons = new Map<String, Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsValue(@Nullable Object o) {
            return false;
        }

        @Nullable
        @Override
        public Integer get(@Nullable Object o) {
            return null;
        }

        @Nullable
        @Override
        public Integer put(@NonNull String s, @NonNull Integer integer) {
            return null;
        }

        @Nullable
        @Override
        public Integer remove(@Nullable Object o) {
            return null;
        }

        @Override
        public void putAll(@NonNull Map<? extends String, ? extends Integer> map) {

        }

        @Override
        public void clear() {

        }

        @NonNull
        @Override
        public Set<String> keySet() {
            return null;
        }

        @NonNull
        @Override
        public Collection<Integer> values() {
            return null;
        }

        @NonNull
        @Override
        public Set<Entry<String, Integer>> entrySet() {
            return null;
        }
    };

    public Map<String, Integer> getPersons() {
        // test global veriables
        persons.put("Pa", 80);
        persons.put("Ma", 70);
        persons.put("Zoon", 60);
        persons.put("Dochter", 50);

        return persons;
    }

    public void setPersons(Map<String, Integer> persons) {
        this.persons = persons;
    }
}