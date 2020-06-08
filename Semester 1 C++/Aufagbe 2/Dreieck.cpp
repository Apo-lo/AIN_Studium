#include <iostream>
#include <cmath>

using namespace std;

//Berechnung eines Dreiecks

int main()  {
    double sideA = 0;
    double sideB = 0;
    double sideC = 0;
    double s = 0;
    double flaeche = 0;
    int i = 1;

    cout << "Bitte geben sie die Seitenlängen des Dreicks an (sideA, sideB, sideC)" << endl;
    cin >> sideA >> sideB >> sideC;

    s = (sideA + sideB + sideC) / 2;

    flaeche = (s * (s - sideA) * (s - sideB) * (s - sideC));

    if (flaeche > 0)    {
        flaeche = sqrt(flaeche);
        cout << "Der Flächeninhalt beträgt " << flaeche << " cm^2" << endl;

    }

    else
        cout << "Mit diesen Zahlen erhält die Rechnung kein Ergebniss bitte andere Zahlen wählen" << endl;

}


