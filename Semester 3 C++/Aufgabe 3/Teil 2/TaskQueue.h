//
// Created by FH on 2019-04-24.
//

#include "Task.h"

#ifndef UEBUNG3_AUFGABE2_TASKQUEUE_H
#define UEBUNG3_AUFGABE2_TASKQUEUE_H


class TaskQueue {
    int dim = 5;
    int anz = 0;
    int front = 0;
    int rear = 0;
    Task* taskarray;

private:
    TaskQueue(const TaskQueue& a);

    TaskQueue operator=(const TaskQueue &x){}

public:
    TaskQueue(){
        taskarray = new Task[dim];
    }

    void addTask(std::string x = "")    {
        if(istVoll()){
            std::cout << "Queue ist Voll" << std::endl;
        }
        else {
            Task temp(x);
            taskarray[rear] = temp;
            anz++;
            rear++;
        }
    }

    void editTask(std::string x) {
        taskarray[front].addText(x);
    }

    void deleteTask(){
        if(anz == 0){
            std::cout << "Queue ist leer" << std::endl;
        }   else {
            front++;
            anz--;
        }
    }

    void anzahl(){
        std::cout << "Die anzahl der Elemente der queue " << anz << std::endl;
    }

    const Task & getTask(){
        return taskarray[front];
    }

    void queueAusgeben(){
        for(int i = front; i < rear;i++){
            taskarray[i].printTask();
        }
    }

    void queueloeschen(){
        Task temp;
        for(int i = 0;i < anz;i++){
            taskarray[i] = temp;
        }
        rear = 0;
        front = 0;
        anz = 0;
    }

    bool istVoll(){
        if(anz < dim){
            return false;
        }
        return true;
    }
    void vergrößern(){
        Task* arraycpy = new Task[dim * 2];

        for(int i = front;i < dim;i++){
            arraycpy[i] = taskarray[i];
        }
        delete[] taskarray;
        taskarray = arraycpy;
        dim += dim;
    }

    ~TaskQueue(){
        //delete[] taskarray;
    }
};

#endif //UEBUNG3_AUFGABE2_TASKQUEUE_H