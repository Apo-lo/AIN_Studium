#include <iostream>
#include <vector>
using namespace std;

class Subject {    // 1. "independent" functionality
    vector < class Observer * > views; // 3. Coupled only to "interface"
    int value;
public:
    virtual void attach(Observer *obs) = 0;
    virtual void setVal(int val) = 0;
    virtual int getVal() = 0;
    void notify();
};

class Observer {
    // 2. "dependent" functionality
    Subject *model;
    int denom;
public:
    Observer(Subject *mod, int div = 0) {
        model = mod;
        denom = div;
        // 4. Observers register themselves with the Subject
        model->attach(this);
    }
    virtual void update() = 0;
protected:
    Subject *getSubject() {
        return model;
    }
    int getDivisor() {
        return denom;
    }
};

class AktienSubjekt: public Subject{
    vector < class Observer * > views; // 3. Coupled only to "interface"
    int value;
public:
    void attach(Observer *obs)  {
        views.push_back(obs);
    }
    void setVal(int val)    {
        value = val;
        if(val < 100)
            notify();
    }
    int getVal(){
        return value;
    }

    void notify();
};

void AktienSubjekt::notify() {
    // 5. Publisher broadcasts
    for (int i = 0; i < views.size(); i++)
        views[i]->update();
}

class DivObserver: public Observer {
public:
    DivObserver(Subject *mod, int div): Observer(mod, div){}
    void update() {
        // 6. "Pull" information of interest
        int v = getSubject()->getVal(), d = getDivisor();
        cout << v << " div " << d << " is " << v / d << '\n';
    }
};

class ModObserver: public Observer {
public:
    ModObserver(Subject *mod, int div): Observer(mod, div){}
    void update() {
        int v = getSubject()->getVal(), d = getDivisor();
        cout << v << " mod " << d << " is " << v % d << '\n';
    }
};


class AktienObserver: public Observer {
public:
    AktienObserver(Subject *mod, int kurs): Observer(mod){}
    void update(){
        int k = getSubject()->getVal();
        cout << "Der Aktien Kurs ist " << k << endl;
    }
};

int main() {/*
    Subject subj;
    DivObserver divObs1(&subj, 4); // 7. Client configures the number and
    DivObserver divObs2(&subj, 3); //    type of Observers
    ModObserver modObs3(&subj, 3);
    DivObserver divIbs4(&subj, 6);
    subj.setVal(18);
*/
    AktienSubjekt aktie;
    AktienObserver aktienObserver1(&aktie, 5);
    AktienObserver aktienObserver2(&aktie, 5);
    aktie.setVal(50);
    aktie.setVal(150);
    aktie.setVal(99);

}