//
// Created by FH on 06.01.20.
//

#include <cmath>
#include "Sphere.h"

Sphere::Sphere() = default;

double Sphere::calculateSurfaceArea() {
    return (4 * M_PI) * pow(getRadius(), 2);
}

double Sphere::calculateVolume() {
    return pow(getRadius(), 3) * 4 / 3 * M_PI;
}

double Sphere::getRadius() {
    return radius;
}

void Sphere::setRadius(double radius) {
    this->radius = radius;
}
