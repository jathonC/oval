package com.epam.oval.repository;

import com.epam.oval.entity.OvalObservable;

public interface OvalSpecification {
    boolean specified(OvalObservable ovalObservable);
}
