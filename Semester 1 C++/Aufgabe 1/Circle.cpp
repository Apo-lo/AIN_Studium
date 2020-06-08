//
// Created by FH on 06.01.20.
//

#include "Circle.h"
#include <cmath>

Circle::Circle() = default;

double Circle::calculateArea() {
    return M_PI * pow(getRadius(), 2);
}

double Circle::calculateCircumference() {
    return (2 * M_PI) * getRadius();
}

void Circle::setRadius(double radius) {
    this->radius = radius;
}

double Circle::getRadius() {
    return radius;
}

