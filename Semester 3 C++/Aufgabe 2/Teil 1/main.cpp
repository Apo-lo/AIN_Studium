#include <iostream>
#include <string>
#include "Karteikarte.h"

int main() {
    Karteikarte Test;
    Test.setAnzahl(5);
    Test.setAuthor("Niklas");
    Test.setBuchtitel("Beispiel");

    Karteikarte Test2;
    Test2.setAnzahl(12);
    Test2.setAuthor("Max");
    Test2.setBuchtitel("Mustermann");

    Test.show();

    std::cout << std::endl;

    Test2.show();
}