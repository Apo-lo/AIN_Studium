//
// Created by FH on 06.01.20.
//

#include "Rectangle.h"

Rectangle::Rectangle() = default;

double Rectangle::calculateArea() {
    return getSideA() * getSideB();
}

void Rectangle::setSideA(double sideA) {
    this->sideA = sideA;
}

void Rectangle::setSideB(double sideB) {
    this->sideB = sideB;
}

double Rectangle::getSideA() {
    return sideA;
}

double Rectangle::getSideB() {
    return sideB;
}

