//
// Created by FH on 2019-04-17.
//

#ifndef UEBUNG2_AUFGABE3_TESTOBJEKTELEMENT_H
#define UEBUNG2_AUFGABE3_TESTOBJEKTELEMENT_H


class TestObjektElement {

public:
    TestObjektElement() {
        std::cout << "Konstruktor aufruf TestObjektElement" << std::endl;
    }

    virtual ~TestObjektElement() {
        std::cout << "Destruktor aufruf TestObjektElement" << std::endl;
    }

};


#endif //UEBUNG2_AUFGABE3_TESTOBJEKTELEMENT_H
