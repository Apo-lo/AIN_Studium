//
// Created by FH on 2019-06-17.
//

#ifndef UEBUNG6_2_BRUCH_H
#define UEBUNG6_2_BRUCH_H


class Bruch {
    unsigned int nenner;
    int zähler;
private:
    static unsigned int ggT(unsigned int a, unsigned int b){
        if(b == 0)
            return a;
        else return ggT(b, a % b);
    }

    static unsigned int kgV(unsigned int a, unsigned int b){
        return a/ggT(a,b) * b;
    }

public:
    Bruch(int zähler = 0, int nenner = 0){
        this->zähler = zähler;
        this->nenner = nenner;
    }

    friend Bruch operator+(Bruch temp1, Bruch temp2){
        int ergebnisNenner = kgV(temp1.nenner, temp2.nenner);
        int ergebnisZähler = temp1.zähler * (ergebnisNenner / temp1.nenner) + temp2.zähler * (ergebnisNenner / temp2.nenner);
        Bruch temp(ergebnisZähler, ergebnisNenner);
        return temp;
    }

    friend Bruch operator/(Bruch &temp1, Bruch &temp2) {
        unsigned int ergebnisZeahler = temp1.zähler * temp2.nenner;
        unsigned int ergebnisNenner = temp1.nenner * temp2.zähler;

        Bruch temp(ergebnisZeahler, ergebnisNenner);
        temp.kuerzen();

        return temp;
    }

    friend std::ostream& operator<<(std::ostream &os, Bruch const &bruch){
        return os << '(' << bruch.zähler << '/' << bruch.nenner << ')';
    }

    void kuerzen() {
        unsigned int tmp(ggT(zähler, nenner));
        zähler = zähler / tmp;
        nenner = nenner / tmp;
    }
};

#endif //UEBUNG6_2_BRUCH_H
