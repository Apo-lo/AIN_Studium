#include <iostream>
#include <math.h>
#include <stdexcept>
#include <stdlib.h>
#include <vector>

class Exeptions {
public:
    const char * msg;
    Exeptions(void){
        msg = "My own Exeption";
    }
};

class NegExeption{
public:
    const char * msg;
    NegExeption(void){
        msg = "Log einer Negativen Zahl nicht möglich";
    }
};

class ZeroExeption{
public:
    const char * msg;
    ZeroExeption(void){
        msg = "Log von Null nicht möglich";
    }
};

class Index0bis5Error : public std::exception{
private:
    const char * m_error;
public:
    Index0bis5Error(const char * error)
        : m_error(error){
    }

    const char * what() const noexcept  { return m_error;}
};

void log(){
    int x = 0;
    std::cin >> x;

    if (x > 0)
        std::cout << log(x);
    else if (x == 0)
        throw ZeroExeption();
    else if (x < 0)
        throw NegExeption();
}

void werfeAusnahme(int nr){
    if(nr == 1)
        throw "BlaBla";
    if(nr == 2)
        throw std::range_error("out of range");
    if(nr == 3)
        throw Exeptions();
}

void index0bis5(int x){
    if(x < 0 || x > 5)
        throw Index0bis5Error("Index out of range");
    else
        std::cout << "In range" << std::endl;
}

void Aufgabe1(){
    int x = 0;
    std::cin >> x;

    try {
        werfeAusnahme(x);
    }   catch (const char * meldung){
        std::cerr << meldung << std::endl;
        exit(1);
    }   catch (std::range_error e){
        std::cerr << e.what() << std::endl;
        exit(1);
    }   catch (Exeptions e){
        std::cerr << e.msg << std::endl;
        exit(1);
    }
}

void Aufgabe2(){
    int x = 5;

    try {
        x /= 0;             //Keine Ausnahme da laut cpp /0 nicht definiert ist
    }   catch (...){
            exit(1);
    }

}

void Aufgabe3(){    //bei neg zahlen "nan" bei null "-inf"
    try {
        log();
    } catch (ZeroExeption e){
        std::cerr << e.msg << std::endl;
        exit(1);
    } catch (NegExeption e){
        std::cerr << e.msg << std::endl;
        exit(1);
    }
}

void Aufgabe4(){
    int x = 0;
    std::cin >> x;

    try{
        index0bis5(x);
    } catch(Index0bis5Error e){
        std::cerr << e.what() << std::endl;
        exit(1);
    }
}

void Aufgabe5(){
    try {
        std::vector<int> v;
        v.resize(v.max_size() + 1);
    }   catch (const std::length_error& e){
            std::cerr << "Length error: " << e.what() << std::endl;
            exit(1);
    }

}

int main() {
    int i = 0;
    std::cin >> i;

    switch (i){
        case 1:
            Aufgabe1();
        case 2:
            Aufgabe2();
        case 3:
            Aufgabe3();
        case 4:
            Aufgabe4();
        case 5:
            Aufgabe5();
        default:
            return 0;
    }
}