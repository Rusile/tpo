package ru.itmo.domain;

public class Planet {
    private boolean isVisible = true;

    public void disappear() {
        isVisible = false;
    }

    public boolean isVisible() {
        return isVisible;
    }
}
