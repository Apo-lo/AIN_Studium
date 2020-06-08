#include <iostream>
#include <cmath>

using namespace std;

int main()  {
    double p, q, x1, x2, y, z, a ;

    cout << "Bitte geben sie p und q ihrer quatratischen Gleichung ein" << endl;
    cin >> p >> q;

    y = (p/2) * (p/2);
    z = y - q;
    a = sqrt(z);
    x1 = -(p/2) + a;
    x2 = -(p/2) - a;

    if (z == 0)
        cout << "± " << x1 << endl;

    if (z < 0)
        cout << "Die Gleichung ergibt keine lösung" << endl;

    if (z > 0)  {
        cout << "x 1 = " << x1 << endl;
        cout << "x 2 = " << x2 << endl;
    }
}
