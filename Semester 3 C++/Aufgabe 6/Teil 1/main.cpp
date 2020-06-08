#include <iostream>
#include <string>
#include <sstream>
#include "Bruch.h"
#include "Vielleicht.h"

int main() {
    //Test 1
    //Erwartete Ausgabe "Hello"
    Vielleicht<std::string> test1("Hallo");
    std::cout << test1.returnWert() << std::endl;

    //Test 2
    //Erwartete Ausgabe "Das Objekt ist leer" <- Nachfragen
    Vielleicht<int> test2(0, true);
    std::cout << test2.returnWert() << std::endl;

    //Test 3
    //Erwartete Ausgabe "Ist leer"
    if(test2.leer())
        std::cout << "Ist leer" << std::endl;

    //Test 4
    //Erwartete Ausgabe "Hello"
    std::cout << test1.derWert() << std::endl;

    //Test 5
    //Erwartete Ausgabe "4.13"
    Vielleicht<float> test5(4.13);
    std::cout << test5.text();

    //Test 6
    //Erwartete Ausgabe "14.86"
    Vielleicht<double> test62(2.3);
    Vielleicht<double> test6(12.56);
    Vielleicht<double> test61(test6 + test62);
    std::cout << test61.text();

    //Test 7
    //Erwartete Ausgabe "10"
    Vielleicht<int> test7(50);
    Vielleicht<int> test71(5);
    Vielleicht<int> test72(test7 / test71);
    std::cout << test72.text();

    //Test 8
    //Erwartete Ausgabe "2"
    Vielleicht<std::string> test8("Blaasd");
    Vielleicht<std::string> test81("aBlu");
    Vielleicht<int> test82 = test8 / test81;
    std::cout << test82.text();

    //Test 9
    //Erwartete Ausgabe "(5/12)\n (17/6)"
    Bruch test9(5,6);
    Bruch test91(12,6);

    Vielleicht<Bruch> test92(test9);
    Vielleicht<Bruch> test93(test91);

    Vielleicht<Bruch> test94(test9 / test91);
    Vielleicht<Bruch> test95(test9 + test91);

    std::cout << test94.text() << test95.text();

    return 0;
}
