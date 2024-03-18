package ru.itmo.domain;

import java.util.ArrayList;
import java.util.List;

public class Reception {
    private List<Furniture> furnitureItems = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();
    private List<Award> awards = new ArrayList<>();

    public void addFurniture(Furniture furniture) {
        furnitureItems.add(furniture);
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void addAward(Award award) {
        awards.add(award);
    }

    public boolean isEmpty() {
        return furnitureItems.isEmpty() && tables.isEmpty() && awards.isEmpty();
    }

    public boolean hasFurniture() {
        return !furnitureItems.isEmpty();
    }

    public boolean hasTables() {
        return !tables.isEmpty();
    }

    public boolean hasAwards() {
        return !awards.isEmpty();
    }
}

