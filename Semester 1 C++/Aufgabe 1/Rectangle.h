//
// Created by FH on 06.01.20.
//

#ifndef UEBUNG1_RECTANGLE_H
#define UEBUNG1_RECTANGLE_H


class Rectangle {
private:
    double sideA{};
    double sideB{};
public:
    Rectangle();
    void setSideA(double sideA);
    void setSideB(double sideB);
    double getSideA();
    double getSideB();
    double calculateArea();
};


#endif //UEBUNG1_RECTANGLE_H
