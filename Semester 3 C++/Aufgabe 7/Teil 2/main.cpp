#include <iostream>
#include <fstream>
#include <string>
#include <regex>

class NoArgumentExeption{
public:
    std::string msg;
    NoArgumentExeption(){
        msg = "Keine Argumente übergeben";
    }
};

namespace std{
    //from https://www.geeksforgeeks.org/remove-extra-spaces-string/
    void removeSpaces(string &str)
    {
        int n = str.length();
        int i = 0, j = -1;

        bool spaceFound = false;

        while (++j < n && str[j] == ' ');

        while (j < n)
        {
            if (str[j] != ' ')
            {
                if ((str[j] == '.' || str[j] == ',' ||
                     str[j] == '?') && i - 1 >= 0 &&
                    str[i - 1] == ' ')
                    str[i - 1] = str[j++];

                else
                    str[i++] = str[j++];

                spaceFound = false;
            }

            else if (str[j++] == ' ')
            {
                if (!spaceFound)
                {
                    str[i++] = ' ';
                    spaceFound = true;
                }
            }
        }
        if (i <= 1)
            str.erase(str.begin() + i, str.end());
        else
            str.erase(str.begin() + i - 1, str.end());
    }
}

void paraH(std::ifstream & myfile, std::ofstream & file){
    std::string line;

    if (myfile.is_open()) {
        while (getline(myfile, line)) {
            for(int i = 0; i < line.length(); i++) {
                file << std::hex << (int)line[i] << " ";
            }
        }
        myfile.close();
        file.close();
    } else std::cout << "Unable to open file";
}

void paraZ(std::ifstream & myfile, std::ofstream & file){
    std::string line;
    int i = 1;

    if (myfile.is_open()) {
        while (getline(myfile, line)) {
            std::removeSpaces(line);
            file << line << std::endl;
            }
        myfile.close();
        file.close();
    }else std::cout << "Unable to open file";
}


void paraL(std::ifstream & myfile, std::ofstream & file){
    std::string line;

    if (myfile.is_open()) {
        while (getline(myfile, line)) {
            for(int i = 0; i < line.length(); i++) {
                file << std::hex << (int)line[i] << " ";
            }
        }
        myfile.close();
        file.close();
    } else std::cout << "Unable to open file";
}

int main(int argc, char * argv[]) {
    
    try {
        if (argc < 2) {
            throw NoArgumentExeption();
        }
    } catch (NoArgumentExeption e) {
        std::cerr << e.msg << std::endl;
        exit(1);
    }

    if (argc == 2) {
        std::ifstream myfile("/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/bsp.txt");
        std::ofstream file("/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/example.txt");

        if (std::string(argv[1]) == "-H") {
            paraH(myfile, file);
        }
        if (std::string(argv[1]) == "-Z") {
            paraZ(myfile, file);
        }
        if (std::string(argv[1]) == "-L") {
            paraL(myfile, file);
        }
    }

    if (argc == 3) {
        std::string lesedatei = std::string(argv[2]);
        std::ifstream myfile(
                "/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/" + lesedatei);
        std::ofstream file(
                "/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/example.txt");

        if (std::string(argv[1]) == "-H") {
            paraH(myfile, file);
        }
        if (std::string(argv[1]) == "-Z") {
            paraZ(myfile, file);
        }
        if (std::string(argv[1]) == "-L") {
            paraL(myfile, file);
        }
    }


    if (argc == 4) {
        std::string lesedatei = std::string(argv[2]);
        std::string schreibedatei = std::string(argv[3]);

        std::ifstream myfile("/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/" + lesedatei);
        std::ofstream file("/Users/fh/CLionProjects/Objektorientierte Programmierung/Uebung7/Uebung7_2/" + schreibedatei);

        if (std::string(argv[1]) == "-H") {
            paraH(myfile, file);
        }
        if (std::string(argv[1]) == "-Z") {
            paraZ(myfile, file);
        }
        if (std::string(argv[1]) == "-L") {
            paraL(myfile, file);
        }
    }
}
