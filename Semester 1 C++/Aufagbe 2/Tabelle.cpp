#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main()
{
    double a, b, n, x, y, z, c;

    cout << "Bitte geben sie die Werte für a, b und n an" << endl;
    cin >> a >> b >> n;

    cout << "+----------+----------+" << endl;
    cout << "|    x     +  y=f(x)  |" << endl;
    cout << "+----------+----------+" << endl;

    x = a;

    double rechnung = (b - a) / (n - 1);

    for (int i = 1; i <= n; i++)
    {
        z = x*x;
        cout << "|  " << left << setw(8) << x << "+  " << left << setw(8) << z << "|" << endl;
        x = x + rechnung;
    }
    cout << "+---------------------+" << endl;
}
