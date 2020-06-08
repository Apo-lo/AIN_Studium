#include <iostream>
#include "bruch.h"
using namespace std;

void aufgabe1() {
    bruch x(1,2);
    bruch y(2,3);
    y.add(x);
    cout << "y = " << y << endl;
}

void aufgabe2() {
    int n;
    cout << "n = ?" << endl;
    cin >> n;
    bruch s(0);
    for(int i = 1; i <= n; i++) {
        s.add(bruch(1,i));
    }
    cout << "s = " << s << endl;
}

int fakultaet(int n) {
    if(n==0) return 1;
    else {
        int ergebnis = n;
        int i = 1;
        while (i < n) {
            ergebnis *= i;
            i++;
        }
        return ergebnis;
    }
}

bruch e(int n) {
    bruch s(0);
    for(int i = 0; i <= n; i++) {
        int fak_i = fakultaet(i);
        s.add(bruch(1,fak_i));
    }
    cout << "s= " << s << endl;
    return s;
}

void aufgabe3() {
    int n;
    cout << "n = ?" << endl;
    cin >> n;

    bruch x = e(n);
    cout << x;
}

int main() {
    int i = 0;
    cout << "Welchen Aufgabenteil?" << endl;
    cin >> i;

    if (i == 1)
        aufgabe1();
    if(i == 2)
        aufgabe2();
    if(i == 3)
        aufgabe3();

    return 0;
}