#include <iostream>
#include "Task.h"
#include "TaskQueue.h"

int main() {
    //Test 1
    std::cout << "Test 1" << std::endl;
    Task test1("Test");
    test1.printTask();

    //Test 2
    std::cout << "\nTest 2" << std::endl;
    test1.addText("Test 2 Bestanden");
    test1.printTask();

    //Test 3
    std::cout << "\nTest 3" << std::endl;
    TaskQueue temp;
    temp.queueAusgeben();

    //Test 4
    std::cout << "\nTest 4" << std::endl;
    temp.deleteTask();

    //Test 5
    std::cout << "\nTest 5" << std::endl;
    temp.addTask("Test 5");
    temp.queueAusgeben();

    temp.addTask("Temp 1");
    temp.addTask("Temp 2");

    //Test 6
    std::cout << "\nTest 6" << std::endl;
    temp.queueAusgeben();
    temp.editTask("Test 6");
    temp.queueAusgeben();

    //Test 7
    std::cout << "\nTest 7" << std::endl;
    temp.queueAusgeben();
    temp.deleteTask();
    temp.queueAusgeben();

    temp.addTask("Temp 3");
    temp.addTask("Temp 4");
    temp.addTask("Temp 5");

    //Test 8
    std::cout <<"\nTest 8" << std::endl;
    temp.addTask("Temp 6");

    //Test 9
    std::cout << "\nTest 9" << std::endl;
    temp.anzahl();

    //Test 10
    std::cout << "\nTest 10" << std::endl;
    temp.queueAusgeben();
    temp.queueloeschen();
    temp.queueAusgeben();
    temp.anzahl();

    //Test 11
    std::cout << "\nTest 11" << std::endl;
    for (int i = 0; i < 5; i++){
        temp.addTask();
    }
    temp.addTask();
    temp.vergrößern();

    for (int i = 0; i < 5; i++){
        temp.addTask();
    }
    temp.queueAusgeben();

    //Test 12
    std::cout << "\nTest 12" << std::endl;
    TaskQueue temp2;
    //temp = temp2;

    return 0;
}