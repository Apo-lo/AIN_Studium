//
// Created by FH on 2019-04-17.
//

#ifndef UEBUNG3_AUFGABE2_TASK_H
#define UEBUNG3_AUFGABE2_TASK_H

static int zaehler = 0; //static Atribute in der Klasse!!!

class Task {
    unsigned int id = 0;
    std::string beschreibung = "";

public:
    Task(std::string x = ""){
        beschreibung = x;
        zaehler++;
        id = zaehler;
    }

    void addText(std::string x){
        beschreibung += x;
    }

    int getId(){
        return id;
    }

    void getText(){
        std::cout << beschreibung << std::endl;
    }

    void printTask();
};

void Task::printTask() {
    std::cout << "Task#" << id << " " << beschreibung << std::endl;
}


#endif //UEBUNG3_AUFGABE2_TASK_H
