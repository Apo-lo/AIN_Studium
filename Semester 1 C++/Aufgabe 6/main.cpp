#include <iostream>

using namespace std;

struct zahl {                                                                                                   //Festlegung einer struktur
    int leange;
    int x[3000];
};

void ausgabezahl(zahl z)    {
    for (int i = z.leange - 1; i >= 0; i--)                                                                             //Länge wird ausgerechnet
        cout << z.x[i];

    cout << endl;
}

zahl multiplikation(zahl z, zahl& ergebnis, const int n)    {                                    //Call by ref.
    int uebertrag = 0;                                                                      //Multiplikation um jede Ziffer zu berechnen
    int zwischenergebnis;
    for (int i = 0; i <= z.leange || uebertrag > 0; i++)    {                                    //if für übertrag
        if(i >=z.leange) z.x[i] = 0;
        zwischenergebnis = z.x[i] * n + uebertrag;
        ergebnis.x[i] = (zwischenergebnis % 10);                                            //Letzte stelle aurechnen
        uebertrag = (zwischenergebnis - (zwischenergebnis %10)) / 10;

        if(ergebnis.x[i] > 0) ergebnis.leange = i+1;                                        //solage bis höchste zahl 0
    }

    return ergebnis;
}



int main()  {
    int n;
    cout << "Geben sie eine Zahl ein" << endl;
    cin >> n;
    int temp = n;


    zahl ergebnis;                                                                          //Grundstruktur
    ergebnis.x[0] = 1;
    ergebnis.leange = 1;

    while (n > 1)   {
        multiplikation(ergebnis, ergebnis, n);
        n--;
    }

    cout << temp << "! = ";
    ausgabezahl(ergebnis);

}
