#include <iostream>
#include <stdlib.h>

using namespace std;

class dyna   {
    int *p;
private:
    dyna(const dyna& x);
public:
    dyna(int i);

    ~dyna() {
        delete p;
    }
    int get(){
        return *p;
    }
};

dyna::dyna(int i) {
    p = new int;
    *p = i;
}

int neg(dyna& ob){                  //davor int neg(dyna ob) -> Problem - jetzt int neg(dyna &ob) -> Richtig
    return -ob.get();
}

int main() {

    cout << "Ausgabe -10" << endl;
    dyna o (-10);
    cout << o.get() << endl;
    cout << neg(o) << endl;

    cout << "Ausgabe 20" << endl;
    dyna o2(20);
    cout << o2.get() << endl;
    cout << neg(o2) << endl;

    cout << "Ausgabe -10" << endl;
    cout << o.get() << endl;
    cout << neg(o) << endl;

    return 0;
}