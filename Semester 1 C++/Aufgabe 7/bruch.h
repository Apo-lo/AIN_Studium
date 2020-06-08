#include<iostream>
#ifndef UEBUNG7_BRUCH_H
#define UEBUNG7_BRUCH_H

class bruch {
    private:
        int zaehler;
        int nenner;
        void kuerzen() {
            const int temp = ggT(zaehler, nenner);
            zaehler /= temp;
            nenner /= temp;
        }
        //Berechnet den größten gemeinsamen Teiler von a und b
        int ggT(int a, int b) {
            if (b>a)
                return (ggT(b,a));
            else
                return ( (b==0) ? a : ggT(b, a % b) );
        }

        //Berechnet das kleinste gemeinsame Vielfache von a und b
        int kgV(int a, int b) {
            return (a * b) / ggT(a, b);
        }

    public:
        bruch(int z, int n = 1) {
            zaehler = z;
            nenner = n;
            kuerzen();
        }

    void add(bruch x) {
        const int temp = kgV(nenner, x.nenner);
        zaehler = zaehler * (temp / nenner) + x.zaehler * (temp / x.nenner);
        nenner = temp;
        kuerzen();
    };

    void sub(bruch x) {
        const int temp = kgV(nenner, x.nenner);
        zaehler = zaehler * (temp / nenner) - x.zaehler * (temp / x.nenner);
        nenner = temp;
        kuerzen();
    }

    void multi(bruch x) {
        zaehler *= x.zaehler;
        nenner *= x.nenner;
        kuerzen();
    }

    void div(bruch x) {
        zaehler *= x.nenner;
        nenner *= x.zaehler;
        kuerzen();
    }

    int get_z() {return zaehler; };                             //Funktionen nur für zähler oder nenner
    int get_n() {return nenner; };


};

std::ostream& operator << (std::ostream &os, bruch &b) {          //Überladung des ausgabeoperators
    return os << b.get_z() << '/' << b.get_n();
}

#endif //UEBUNG7_BRUCH_H