#include <iostream>

#include "Circle.h"
#include "Sphere.h"
#include "Rectangle.h"


using namespace std;

bool checkInputCorrect(int input)   {
    return (0 < input && input <= 3);
}

bool checkRadiusPositive(double radius)  {
    return radius >= 0;
}

bool checkSidesPositive(double sideA, double sideB) {
    return sideA > 0 && sideB > 0;
}

int main() {
    int input = 0;
    double radius = 0;

    while(!checkInputCorrect(input)) {
        cout << "Enter the Number of the shape to calculate\n 1 - Circle\n 2 - Sphere\n 3 - Rectangle\n (to confirm press enter)\n";
        cin >> input;
    }

    switch (input) {
        case 1 : {
            cout << "Enter a positive radius" << endl;
            cin >> radius;

            if(checkRadiusPositive(radius))  {
                Circle circle;
                circle.setRadius(radius);

                cout << "The area of the circle is: " << circle.calculateArea() << "cm^2" << endl;
                cout << "The circumference of the circle is: " << circle.calculateCircumference() << "cm" << endl;
                break;
            }
            else {
                cout << "Negative radius!" << endl;
                break;
            }
        }

        case 2: {
            cout << "Enter a positive radius" << endl;
            cin >> radius;

            if(checkRadiusPositive(radius))  {
                Sphere sphere;
                sphere.setRadius(radius);

                cout << "The Area of the sphere is: " << sphere.calculateSurfaceArea() << "cm^2" << endl;
                cout << "The Volume of the sphere is: " << sphere.calculateVolume() << "cm^3" << endl;
                break;
            }
            else {
                cout << "Negative radius!" << endl;
                break;
            }
        }

        case 3: {
            double sideA = 0;
            double sideB = 0;

            cout << "Enter side a and b" << endl;
            cin >> sideA >> sideB;
            
            if(checkSidesPositive(sideA, sideB)) {
                Rectangle rectangle;
                rectangle.setSideA(sideA);
                rectangle.setSideB(sideB);

                cout << "The Area of the rectangle is: " << rectangle.calculateArea() << "cm^2" << endl;
                break;
            }
            else {
                cout << "Negative side!" << endl;
                break;
            }
        }
    }
    return 0;
}