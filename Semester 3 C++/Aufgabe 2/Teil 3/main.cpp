#include <iostream>
#include "TestObjekt.h"


TestObjekt testGlobal;

    void testFunk(TestObjekt x) {

    }

    void testFunk2(TestObjekt& x) {

    }

    TestObjekt testFunk3(){
        TestObjekt temp;
        return temp;
    }

    void testFunk4()    {
        static TestObjekt temp;
    }

int main() {
    TestObjekt testLokal;

    std::cout << "aufgabe c" << std::endl;
    testFunk(testGlobal);
    testFunk(testLokal);

    std::cout << "aufgabe d" << std::endl;
    testFunk2(testGlobal);
    testFunk2(testLokal);

    TestObjekt temp1;

    std::cout << "aufgabe e" << std::endl;
    temp1 = testFunk3();
    testFunk3();

    std::cout << "aufgabe f" << std::endl;
    testFunk4();
    testFunk4();
}