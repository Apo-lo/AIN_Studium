#include <iostream>
#include "Queue.h"

int main() {

    int dim = 5;
    int feld[] = {0,1,2,3,4};

    Queue * q1 = new Queue(dim);
    Queue * q2 = new Queue(dim,feld);
//    Queue q2(dim,feld);

    int x = 1;
    for(int i = 0; i < 10; i++) {
        q1->insert(x);
        q1->print();
        x++;
    }

    for(int i = 0;i <= dim; i++) {
        q2->remove();
        q2->print();
    }


    return 0;
}