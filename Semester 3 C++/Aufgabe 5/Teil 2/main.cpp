#include <iostream>
using namespace std;

struct Base{
    int a;
};

struct Derived: public Base{
    int b;
};

int main() {
    //Test 1 zuweisung Typ Base an Typ Derived
    cout << "Test 1" << endl;
    Base Test1;
    Derived Test1_1;
    //Test1_1 = Test1; //no viable overloaded '='

    //Test 2 zuweisung Typ Dervied an Typ Base
    cout << "Test 2" << endl;
    Base Test2;
    Derived Test2_1;
    Test2 = Test2_1;

    //Test 3 Base * an Derive *
    cout << "Test 3" << endl;
    Base *Test3;
    Derived *Test3_1;
    //Test3_1 = Test3; //assigning to 'Derived *' from incompatible type 'Base *'

    //Test 4 Derived * an Base *
    cout << "Test 4" << endl;
    Base *Test4;
    Derived *Test4_1;
    Test4 = Test4_1;

    return 0;
}