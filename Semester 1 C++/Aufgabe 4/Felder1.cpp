#include <iostream>
#include <cmath>

using namespace std;

//Berechnung des Mittelwerts und der standartabweichung mittels Arrays

int main()  {
    int n = 10;

    double mittelWert = 0;
    double eingeleseneZahlen[n];
    double standartAbweichung = 0;
    double summe = 0;

    cout << "Bitte geben sie 10 reelle zahlen ein" << endl;

    for (int i = 0; i < n; i++) {
        cin >> eingeleseneZahlen[i];    //Einlesung der Zahlen über die Tastatur
    }

    for (int y = 0; y < n; y++)
        mittelWert = mittelWert + eingeleseneZahlen[y];       //berechnung des Mittelwertes

    mittelWert = mittelWert / n;

    for (int z = 0; z < n; z++)    //Berechnung der Standardabweichung
        summe = summe + ((eingeleseneZahlen[z] - mittelWert) * (eingeleseneZahlen[z] - mittelWert));

    standartAbweichung = sqrt(1.0 / (n - 1) * summe);

    cout << "Der Mittelwert beträgt "<< mittelWert << endl;
    cout << "Die Standardabweichung beträgt " << standartAbweichung << endl;

}

