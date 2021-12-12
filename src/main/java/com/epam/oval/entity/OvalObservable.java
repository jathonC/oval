package com.epam.oval.entity;

import com.epam.oval.logic.Observable;
import com.epam.oval.logic.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OvalObservable extends Oval implements Observable<OvalObservable> {

    private final Integer id;
    private final List<Observer<OvalObservable>> observerList = new ArrayList<>();

    public OvalObservable(Point firstpoint, Point secondpoint, Integer id) {
        super(firstpoint, secondpoint);
        this.id = id;
    }

    @Override
    public void setFirstpoint(Point firstpoint) {
        super.setFirstpoint(firstpoint);
        notifyObservers();
    }

    @Override
    public void setSecondpoint(Point secondpoint) {
        super.setSecondpoint(secondpoint);
        notifyObservers();
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void attach(Observer<OvalObservable> observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer<OvalObservable> observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<OvalObservable> observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        OvalObservable that = (OvalObservable) o;
        return id == that.id && observerList.equals(that.observerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
