//
// Created by FH on 06.01.20.
//

#ifndef UEBUNG1_CIRCLE_H
#define UEBUNG1_CIRCLE_H


class Circle {
private:
    double radius{};

public:
    explicit Circle();
    void setRadius(double radius);
    double getRadius();
    double calculateArea();
    double calculateCircumference();
};


#endif //UEBUNG1_CIRCLE_H
