#include <utility>

//
// Created by FH on 2019-06-17.
//

#ifndef UEBUNG6_1_VIELLEICHT_H
#define UEBUNG6_1_VIELLEICHT_H

#include <iostream>
#include <string>
#include <sstream>
#include "Bruch.h"

template <class T >
class Vielleicht {
    T wert;
    bool empty;

    friend Vielleicht<T> operator+(Vielleicht<T> &temp1, Vielleicht<T> &temp2){
        if(temp1.leer() || temp2.leer()) {
            Vielleicht<T> temp3(0, true);
            return temp3;
        }

        T x = temp1.derWert();
        T y = temp2.derWert();
        T z = x + y;
        Vielleicht<T> temp(z);
        return temp;
    }

    friend Vielleicht<T> operator/(Vielleicht<T> &temp1, Vielleicht<T> &temp2){
        if(temp1.leer() || temp2.leer()) {
            Vielleicht<T> temp3(0, true);
            return temp3;
        }

        T x = temp1.derWert();
        T y = temp2.derWert();
        T z = x / y;
        Vielleicht<T> temp(z);
        return temp;
    }

public:
    Vielleicht(T wert, bool x = false) {
        this->wert = wert;
        empty = x;
    }


    T returnWert() {
        if(!leer())
            return wert;
        else
            std::cout << "Das Objekt ist leer";
        return 0;
    }

    bool leer() {
        return empty;
    }

    const T derWert() const {
        if(empty)
            exit(57);
        return wert;
    }

    std::string text() const {
        if(empty)
            return "Das Objekt ist leer";

        std::stringstream buffer;
        buffer << wert << std::endl;
        return buffer.str();
    }
};

template<>
class Vielleicht<std::string> {
    std::string wert;
    bool empty;

    friend Vielleicht<int> operator/(Vielleicht<std::string> &temp1, Vielleicht<std::string> &temp2) {
        std::string x = temp1.text();
        std::string y = temp2.text();
        unsigned int z = x.length() - y.length();

        Vielleicht<int> temp(z);
        return temp;
    }

public:
    Vielleicht(std::string wert, bool x = false) {
        this->wert = wert;
        empty = x;
    }

    std::string returnWert() {
        if(!leer())
            return wert;
        else
            std::cout << "Das Objekt ist leer";
        return 0;
    }

    bool leer() {
        return empty;
    }

    const std::string derWert() const {
        if(empty)
            exit(57);
        return wert;
    }

    std::string text() const {
        if(empty)
            return "Das Objekt ist leer";

        std::stringstream buffer;
        buffer << wert << std::endl;
        return buffer.str();
    }
};

template<>
class Vielleicht<Bruch> {
    Bruch wert;
    bool empty;

public:
    Vielleicht(Bruch wert, bool x = false) {
        this->wert = wert;
        empty = x;
    }

    std::string returnWert() {
        if(!leer())
            return text();
        else
            std::cout << "Das Objekt ist leer";
        return 0;
    }

    bool leer() {
        return empty;
    }

    const Bruch derWert() const {
        if(empty)
            exit(57);
        return wert;
    }

    std::string text() const {
        if(empty)
            return "Das Objekt ist leer";

        std::stringstream buffer;
        buffer << wert << std::endl;
        return buffer.str();
    }
};


#endif //UEBUNG6_1_VIELLEICHT_H
