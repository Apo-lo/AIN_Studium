//
// Created by FH on 06.01.20.
//

#ifndef UEBUNG1_SPHERE_H
#define UEBUNG1_SPHERE_H


class Sphere {
private:
    double radius{};
public:
    explicit Sphere();
    void setRadius(double radius);
    double getRadius();
    double calculateSurfaceArea();
    double calculateVolume();
};


#endif //UEBUNG1_SPHERE_H
