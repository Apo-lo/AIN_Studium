#include <iostream>
#include <cmath>
#include <stdlib.h>
#include <algorithm>

struct Punkt {
    long int xKoordinate;
    long int yKoordinate;
};
void printPunkt(Punkt);
void printPunktFels(Punkt **);
double abstand(Punkt, Punkt);
bool gleich(const Punkt &, const Punkt &);
Punkt * neuerPunkt(void);
Punkt ** neuesPunktFeld(int dim);
void clearPunktFeld(Punkt **);
double maxAbstand(Punkt **, Punkt *, Punkt *);
double minWeg(Punkt **, Punkt **);

struct Rechteck {
     Punkt obenRechts;
     Punkt untenLinks;
};
double flaeche(const Rechteck *x);
bool innerhalb(const Rechteck &, const Punkt &);
bool ueberlapp(const Rechteck *, const Rechteck *);

bool wayToSort( Punkt *x, Punkt *y) { return x->yKoordinate < y->yKoordinate && x->xKoordinate < y->xKoordinate; }


int main() {

//  Aufgabe a
//  ----------------------
    Punkt p1;
    p1.xKoordinate = 10;
    p1.yKoordinate = 10;

    printPunkt(p1);
//  ----------------------

//  Aufgabe b
//  ----------------------
    Punkt p2;
    p2.xKoordinate = 100;
    p2.yKoordinate = 100;

    Punkt p3;
    p3.xKoordinate = 200;
    p3.yKoordinate = 200;

    std::cout << "Der abstand zwischen den Punkten beträgt " << abstand(p2, p3) << std::endl;
//  ----------------------

//  Aufgabe c
//  ----------------------
    Punkt p4,p5;
    p4.xKoordinate = 10;
    p4.yKoordinate = 10;

    p5.xKoordinate = 20;
    p5.yKoordinate = 20;

    if (gleich(p4, p5)) {
        std::cout << "Die Punkte sind gleich" << std::endl;
    } else {
        std::cout << "Die Punkte sind nicht gleich" << std::endl;
    }
//  -----------------------

//  Aufgabe e
//  -----------------------

    Rechteck *r1 = new Rechteck;

    Punkt p6,p7;
    p6.xKoordinate = 10;
    p6.yKoordinate = 10;

    p7.xKoordinate = 20;
    p7.yKoordinate = 20;

    r1->untenLinks = p6;
    r1->obenRechts = p7;

    std::cout << flaeche(r1) << " cm^2" << std::endl;
//  -----------------------

//  Aufgabe f
//  -----------------------
    Rechteck r2;

    Punkt p8,p9;
    p8.xKoordinate = 10;
    p8.yKoordinate = 10;

    p9.xKoordinate = 20;
    p9.yKoordinate = 20;

    r2.untenLinks = p8;
    r2.obenRechts = p9;

    Punkt PunktTest3;
    PunktTest3.xKoordinate = 50;
    PunktTest3.yKoordinate = 50;

    if (innerhalb(r2, PunktTest3)) {
        std::cout << "Der Punkt liegt innerhalb des Rechtecks" << std::endl;
    } else {
        std::cout << "Der Punkt liegt nicht innerhalb des Rechtecks" << std::endl;
    }
//  -----------------------

//  Aufgabe g
//  -----------------------
    Rechteck *r3 = new Rechteck;
    Rechteck *r4 = new Rechteck;

    Punkt p10,p11,ptemp,ptemp1;
    p10.xKoordinate = 10;
    p10.yKoordinate = 10;

    p11.xKoordinate = 20;
    p11.yKoordinate = 20;

    ptemp.xKoordinate = 15;
    ptemp.yKoordinate = 5;

    ptemp1.xKoordinate = 25;
    ptemp1.yKoordinate = 25;

    r3->untenLinks = p10;
    r3->obenRechts = p11;

    r4->untenLinks = ptemp;
    r4->obenRechts = ptemp1;

    if (ueberlapp(r3, r4)) {
        std::cout << "Die Rechtecke überlappen" << std::endl;
    } else {
        std::cout << "Die Rechtecke überlappen nicht" << std::endl;
    }
//  -----------------------

//  Aufgabe h
//  -----------------------
    Punkt *p12 = neuerPunkt();
    printPunkt(*p12);
//  -----------------------

//  Aufgabe i
//  -----------------------
    int dim = 4;
    Punkt **pa1;
    pa1 = neuesPunktFeld(dim);

    for(int i = 0; pa1[i] != nullptr;i++)   {
        printPunkt(*pa1[i]);
    }

//  -----------------------
//  Aufgabe j
//  -----------------------
    clearPunktFeld(pa1);
//  -----------------------
//  Aufgabe k
    Punkt **pa2;
    pa2 = neuesPunktFeld(dim);

    Punkt *p13 = new Punkt;
    Punkt *p14 = new Punkt;

    std::cout << "Max abstand beträgt " << maxAbstand(pa2,p13,p14) << std::endl;

    printPunkt(*p13);
    printPunkt(*p14);
//  -----------------------

//  Aufgabe l
//  -----------------------
    Punkt **pa3;
    pa3 = neuesPunktFeld(dim);

    Punkt **pa4 = pa3;

    std::cout << "Der Minimaleweg beträgt: " <<  minWeg(pa3, pa4) << std::endl;

    for (int i = 0; i <= dim; i++) {
        printPunkt(*pa4[i]);
    }

    return 0;
}

//----------------------------------------------------------------------------------------------------------------------
void printPunkt(Punkt x)    {
    std::cout << "Punkt: " << "x=" << x.xKoordinate << ", y=" << x.yKoordinate << std::endl;
}

double abstand(Punkt x, Punkt y)    {
    double teilergebnis1 = 0;
    double teilergebnis2 = 0;
    double ergebnis = 0;

    teilergebnis1 = pow(y.yKoordinate - x.yKoordinate, 2);
    teilergebnis2 = pow(y.xKoordinate - x.xKoordinate, 2);
    ergebnis = sqrt(teilergebnis1 + teilergebnis2);

    //ergebnis = sqrt((pow(y.yKoordinate - x.yKoordinate, 2)) + (pow(y.xKoordinate - x.xKoordinate, 2)));
    return ergebnis;
}

bool gleich(const Punkt & x, const Punkt & y)   {
    return x.xKoordinate == y.xKoordinate && x.yKoordinate == y.yKoordinate;
}

double flaeche(const Rechteck * x)    {
    Punkt temp1;

    double abstand1 = 0;
    double abstand2 = 0;

    temp1.xKoordinate = x->untenLinks.xKoordinate;
    temp1.yKoordinate = x->obenRechts.yKoordinate;
    
    abstand1 = abstand(x->obenRechts, temp1);
    abstand2 = abstand(x->untenLinks, temp1);

    return (abstand1 * abstand2);
}

bool innerhalb(const Rechteck & x, const Punkt & y) {
    return (y.xKoordinate <= x.obenRechts.xKoordinate && y.yKoordinate <= x.obenRechts.yKoordinate
    && y.xKoordinate >= x.untenLinks.xKoordinate && y.yKoordinate >= x.untenLinks.yKoordinate);
}


bool ueberlapp(const Rechteck *x, const Rechteck *y)  {
    if(innerhalb(*x, y->untenLinks))
        return true;
    else if(innerhalb(*x, y->obenRechts))
        return true;
    else if(x->untenLinks.xKoordinate <= y->obenRechts.xKoordinate && x->untenLinks.xKoordinate >= y->untenLinks.xKoordinate && x->untenLinks.yKoordinate <= y->untenLinks.yKoordinate && x->obenRechts.yKoordinate >= y->untenLinks.yKoordinate)
        return true;
    else if(x->untenLinks.yKoordinate <= y->obenRechts.yKoordinate && x->untenLinks.yKoordinate >= y->untenLinks.yKoordinate && x->untenLinks.xKoordinate <= y->untenLinks.xKoordinate && x->obenRechts.xKoordinate >= x->untenLinks.xKoordinate)
        return  true;

    return false;
}

Punkt * neuerPunkt()    {
    auto *temp = new Punkt;
    std::cin >> temp->xKoordinate >> temp->yKoordinate;

    return temp;
}

Punkt ** neuesPunktFeld(int dim)    {
    auto **PunktArray = new Punkt* [dim + 1];

    for(int i = 0; i < dim; i++)   {
        PunktArray[i] = neuerPunkt();
    }
    PunktArray[dim] = nullptr;
    return PunktArray;
}

void clearPunktFeld(Punkt **x)   {
    int dim = 0;

    while(x[dim] != nullptr)    {
        dim++;
    }

    for(int i = 0; i < dim + 1; i++)  {
        delete x[i];
    }
    delete[] x;
}

double maxAbstand(Punkt ** PunktArray, Punkt * x, Punkt * y) {
    int dim = 0;
    while(PunktArray[dim] != nullptr)    {
        dim++;
    }

    double nMax = 0;
    double nTempCalc;

    for(int i = 0; PunktArray[i] != nullptr; i++)  {
        for(int j = dim - 1; j > 0;j--)    {
            nTempCalc = abstand(*(PunktArray[i]), *(PunktArray[j]));

            if( nMax < nTempCalc)   {
                *x = *PunktArray[i];
                *y = *PunktArray[j];
                nMax = nTempCalc;
            }
        }
    }
    return nMax;
}

double minWeg(Punkt **pa1, Punkt **pa2)   {
    int dim = 0;

    while(pa1[dim] != nullptr)    {
        dim++;
    }

    std::sort(pa1,pa1 + dim, wayToSort);
    double tempAbstand = 0;
    double minAbstand = INT_MAX;

    do  {
        for(int j = 0; j < dim - 1; j++)  {
            tempAbstand = tempAbstand + abstand(*pa1[j],*pa1[j + 1]);
        }
        if(tempAbstand < minAbstand) {
            minAbstand = tempAbstand;
            tempAbstand = 0;

            for(int i = 0; i < dim; i++)   {
                *pa2[i] = *pa1[i];
            }
        }
    } while (std::next_permutation(pa1, pa1 + dim, wayToSort));

    return minAbstand;
}