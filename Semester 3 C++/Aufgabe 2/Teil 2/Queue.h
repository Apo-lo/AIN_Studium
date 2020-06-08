//
// Created by FH on 2019-04-10.
//

#ifndef UEBUNG2_AUFGABE2_QUEUE_H
#define UEBUNG2_AUFGABE2_QUEUE_H

class Queue {
    int dim;
    int *queue;
    int posinert = 0;
    int posremove = 0;
    int anz = 0;
public:
    Queue(int a = 5, int b[] = nullptr)   {
        dim = a;
        queue = new int[dim];
    }

    void insert(int a)  {
        if(posinert == dim) {
            posinert = 0;
//            std::cout << ":" << std::endl;
        }
        if(anz != dim)   {
            queue[posinert] = a;
            anz++;
            posinert++;
        }   else    {
            std::cout << "Voll" << std::endl;
        }
    }

    void remove()  {
        if(posremove == dim)    {
            posremove = 0;
            std::cout << "Pos remove" << std::endl;
            if(anz > 0)    {
                queue[posremove] = 0;
                posremove++;
                anz--;
            }   else    {
                std::cout << "leer" << std::endl;
            }
        }
    }

    void print()    {
        for(int i = 0;i < dim; i++)    {
            std::cout << "i " << queue[i] << std::endl;
        }
    }

    ~Queue() {
        delete(queue);
    }
};



#endif //UEBUNG2_AUFGABE2_QUEUE_H
