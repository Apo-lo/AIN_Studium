#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main()  {
    double xi, a, myCalculatedPi, ug1, og1, xi2, n, n1, i, i1, og, ug;
    double e;
    int decimalPlaces;

    i = 1;
    i1 = 0;
    n = 4;
    og = 0;
    ug = 0;
    a = 1;
    myCalculatedPi = 0;
    n1 = n - 1;

    cout << "How many decimal places you want to calculate?" << endl;
    cin >> decimalPlaces;
    e = pow(10, -decimalPlaces);

    while (a - myCalculatedPi >= e)  {
        while (i <= n)  {
            xi = i / n;
            og1 = 1 / n * sqrt(1 - (xi * xi));
            og = og + og1;
            myCalculatedPi = og * 4;
            i = i + 1;
        }
        while (i1 <= n1)    {
            xi2 = i1 / n;
            ug1 = 1 / n * sqrt(1 - ( xi2 * xi2));
            ug = ug + ug1;
            a = ug * 4;
            i1 = i1 + 1;
        }
        n = n * 2;
        n1 = n - 1;
        og = 0;
        ug = 0;
        i = 1;
        i1 = 0;
    }
    cout << "Pi ≈ " << std::setprecision(decimalPlaces + 1) << myCalculatedPi << endl;
}
