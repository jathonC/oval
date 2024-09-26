package com.epam.oval.logic;

public interface Observer<T> {
    void update(T event);
}
