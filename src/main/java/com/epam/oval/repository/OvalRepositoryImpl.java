package com.epam.oval.repository;

import com.epam.oval.entity.OvalObservable;

import java.util.*;

public class OvalRepositoryImpl implements OvalRepository {
    Map<Integer, OvalObservable> ovals = new HashMap<>();

    public OvalRepositoryImpl(){

    }

    @Override
    public void add(final OvalObservable ovalObservable) {
        ovals.put(ovalObservable.getId(), ovalObservable);
    }

    @Override
    public void delete(final OvalObservable ovalObservable) {
        ovals.remove(ovalObservable.getId());
    }

    @Override
    public List<OvalObservable> query(final OvalSpecification ovalSpecification) {
        List<OvalObservable> result = new ArrayList<>();
        for (OvalObservable oval : ovals.values()) {
            if (ovalSpecification.specified(oval)) {
                result.add(oval);
            }
        }
        return result;
    }

    @Override
    public void update(final OvalObservable ovalObservable) {
        ovals.put(ovalObservable.getId(), ovalObservable);
    }

    @Override
    public List<OvalObservable> sort(final Comparator<OvalObservable> comparator) {
        List<OvalObservable> result = new ArrayList<>(ovals.values());
        result.sort(comparator);
        return result;
    }
}
