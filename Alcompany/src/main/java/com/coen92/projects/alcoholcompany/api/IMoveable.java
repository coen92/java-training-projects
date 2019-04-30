package com.coen92.projects.alcoholcompany.api;

import com.coen92.projects.alcoholcompany.model.places.Place;

public interface IMoveable {

    void move(Place departure, Place destination);
}
