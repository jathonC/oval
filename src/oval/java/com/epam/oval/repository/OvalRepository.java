package com.epam.oval.repository;

import com.epam.oval.entity.OvalObservable;

import java.util.Comparator;
import java.util.List;

public interface OvalRepository {

    void add(OvalObservable ovalObservable);

    void delete(OvalObservable ovalObservable);

    void update(OvalObservable ovalObservable);

    List<OvalObservable> query(OvalSpecification ovalSpecification);

    List<OvalObservable> sort(Comparator<OvalObservable> comparator);
}
