#include <iostream>
#include "Rechteck.h"
#include "Quader.h"

int main() {
    //Test 1
    std::cout << "\nTest 1" << std::endl;
    Rechteck test;
    test.setBreite(5);
    test.setLeange(10);
    std::cout << test.getBreite() << " " << test.getLeange() << std::endl;

    //Test 2
    std::cout << "\nTest 2" << std::endl;
    Quader test2;
    test2.setLeange(5);
    test2.setBreite(10);
    test2.setHoehe(15);
    std::cout << test2.getLeange() << " " << test2.getBreite() << " " << test2.getHoehe() << std::endl;

    //Test 3
    std::cout << "\nTest 3" << std::endl;
    std::cout << test.umfang() << std::endl;

    //Test 4
    std::cout << "\nTest 4" << std::endl;
    std::cout << test.rFlache() << std::endl;

    //Test 5
    std::cout << "\nTest 5" << std::endl;
    std::cout << test2.volumen() << std::endl;

    //Test 6
    std::cout << "\nTest 6" << std::endl;
    std::cout << test2.qFlache() << std::endl;

    //Test 7
    std::cout << "\nTest 7" << std::endl;
    std::cout << test2.rFlache() << " " << test2.umfang() << std::endl;

    return 0;
}