package com.epam.oval.repository;

import com.epam.oval.entity.OvalObservable;

public class IdOvalSpecification implements OvalSpecification {
    private final Integer id;

    public IdOvalSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(OvalObservable ovalObservable) {
        int id = ovalObservable.getId();
        return equals(id);
    }
}
