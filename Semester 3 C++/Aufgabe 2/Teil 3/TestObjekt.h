//
// Created by FH on 2019-04-14.
//

#ifndef UEBUNG2_AUFGABE3_TESTOBJEKT_H
#define UEBUNG2_AUFGABE3_TESTOBJEKT_H
#include "TestObjektElement.h"

static int zaehler = 0;

class TestObjekt {
    int id = 0;
    TestObjektElement temp;
public:
    TestObjekt()    {
        std::cout << "Kostruktor aufruf:  ";
        zaehler++;
        id = zaehler;
        std::cout << id << std::endl;
    }

    TestObjekt(TestObjekt & testObjekt) {
//        std::cout << "Kopierkostruktor aufruf" << std::endl;
    }

    ~TestObjekt()   {
        std::cout << "Destruktor aufruf:  ";
        std::cout << id << std::endl;
    }
};



#endif //UEBUNG2_AUFGABE3_TESTOBJEKT_H
