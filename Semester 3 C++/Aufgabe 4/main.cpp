#include <iostream>
#include "Vektor3D.h"

int main() {
    Vektor3D temp;

    //Test 1)
    std::cout << "Test 1" << std::endl;
    Vektor3D test1(1,-2,3.6);
    std::cout << test1;

    //Test 2)
    std::cout << "\nTest 2" << std::endl;
    Vektor3D test2(2,-1,5.6);
    Vektor3D test21(2,-1,5.6);
    temp = test2 + test21;
    std::cout << temp;

    //Test 3)
    std::cout << "\nTest 3" << std::endl;
    Vektor3D test3(5,-1,11.6);
    Vektor3D test31(6,-2,5.5);
    temp = test3 - test31;
    std::cout << temp;

    //Test 4)
    std::cout << "\nTest 4" << std::endl;
    Vektor3D test4(5,-1,11.6);
    Vektor3D test41(5,-2,5.5);
    float x = test4 * test41;
    std::cout << x << std::endl;

    //Test 5)
    std::cout << "\nTest 5" << std::endl;
    if(test2 == test21)
        std::cout << "Test 5 bestanden" << std::endl;
    if(test4 == test41)
        std::cout << "Test 5 nicht bestanden" << std::endl;

    //Test 6)
    std::cout << "\nTest 6" << std::endl;
    std::cout << temp;
    std::cout << temp++;
    std::cout << temp;

    //Test 7)
    std::cout << "\nTest 7" << std::endl;
    std::cout << temp;
    std::cout << ++temp;

    //Test 8)
    std::cout << "\nTest 8" << std::endl;
    std::cout << temp;
    std::cout << --temp;

    return 0;
}