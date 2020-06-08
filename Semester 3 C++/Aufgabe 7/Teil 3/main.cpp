#include <iostream>
#include <map>

class key{
public:
    int y = 0;
    key(int x){
        y = x;
    }
    bool operator==(const int x){
        return y == x;
    }

    inline bool operator<(const key & x) const {
        return (this->y < x.y);
    }
    int getName(){
        return y;
    }
};

class value{
public:
    std::string y;
    value(std::string x){
        this-> y  = x;
    }

    inline bool operator<(const value & x) const {
        return this->y < x.y;
    }

    bool operator==(const value x){
        return this->y == x.y;
    }

    const std::string& getName() const {
        return y;
    }
};

int main() {
    //Aufgabe a
    std::map<value, key> test;

    //Aufgabe b
    test.insert(std::make_pair(value("earth"), key(1)));
    test.insert(std::make_pair(value("moon"), key(2)));
    test.insert(std::make_pair(value("saturn"), key(3)));
    test.insert(std::make_pair(value("merkur"), key(4)));
    test.insert(std::make_pair(value("sonne"), key(5)));
    test.insert(std::make_pair(value("sterne"), key(6)));

    //Aufgabe c
    std::map<value, key> test1(test);
    std::map<value, key> test2;
    test2 = test;

    //Aufgabe d
    value x("earth");
    value y("mars");
    if(test.find(x) != test.end())
        std::cout << "earth ist enthalten" << std::endl;
    if(test.find(y) == test.end())
        std::cout<<"word 'mars' not found"<<std::endl;

    //Aufgabe e
    value z("moon");
    test.erase(z);

    //Aufgabe f
    std::map<value, key>::iterator it = test.begin();
    while(it != test.end()){
        std::cout << it->first.getName() << " :: " << it->second.getName() <<  std::endl;
        it++;
    }

    return 0;
}