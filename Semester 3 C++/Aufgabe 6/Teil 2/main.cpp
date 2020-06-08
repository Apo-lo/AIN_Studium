#include <iostream>
#include "Bruch.h"


template<typename T>
T add(T v) {
    return v;
}

template<typename T, typename... Args>
T add(T first, Args... args) {
    return first + add(args...);
}

int main() {
    long sum = add(1, 2, 3, 8, 7, 5);

    std::string s1 = "x", s2 = "aa", s3 = "bb", s4 = "yy";
    std::string ssum = add(s1, s2, s3, s4);

    Bruch x(5,6);
    Bruch y(7,8);
    Bruch z(add(x,y));
    std::cout << z << std::endl;

    std::cout << sum << " " <<ssum << std::endl;
    return 0;
}