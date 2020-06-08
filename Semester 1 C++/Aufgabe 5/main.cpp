#include <algorithm>
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

const char* tablealphabet[256];                                                                                         //erstellung der Tabelle

void tabellezumorse() {                                                                                                 //Allen int werten ein Leerzeichen
    for(int i = 0; i <= 256; i++) {
        tablealphabet[i] = " ";
    }
    tablealphabet['A'] = "*-";
    tablealphabet['B'] = "-***";
    tablealphabet['C'] = "-*-*";
    tablealphabet['D'] = "-**";
    tablealphabet['E'] = "*";
    tablealphabet['F'] = "**-*";
    tablealphabet['G'] = "--*";
    tablealphabet['H'] = "****";
    tablealphabet['I'] = "**";
    tablealphabet['J'] = "*---";
    tablealphabet['K'] = "-*-";
    tablealphabet['L'] = "*-**";
    tablealphabet['M'] = "--";
    tablealphabet['N'] = "-*";
    tablealphabet['O'] = "---";
    tablealphabet['P'] = "*--*";
    tablealphabet['Q'] = "--*-";
    tablealphabet['R'] = "*-*";
    tablealphabet['S'] = "***";
    tablealphabet['T'] = "-";
    tablealphabet['U'] = "**-";
    tablealphabet['V'] = "***-";
    tablealphabet['W'] = "*--";
    tablealphabet['X'] = "-**-";
    tablealphabet['Y'] = "-*--";
    tablealphabet['Z'] = "--**";
    tablealphabet['0'] = "-----";
    tablealphabet['1'] = "*----";
    tablealphabet['2'] = "**---";
    tablealphabet['3'] = "***--";
    tablealphabet['4'] = "****-";
    tablealphabet['5'] = "*****";
    tablealphabet['6'] = "-****";
    tablealphabet['7'] = "--***";
    tablealphabet['8'] = "---**";
    tablealphabet['9'] = "----*";
}

const char* tablemorse[256];                                                                                            //Tabelle zu Morse

void tabellevonmorse() {
    for(int i = 0; i <= 256; i++) {
        tablemorse[i] = " ";
    }
    tablemorse[7] = "A";
    tablemorse[41] = "B";
    tablemorse[50] = "C";
    tablemorse[14] = "D";
    tablemorse[1] = "E";
    tablemorse[49] = "F";
    tablemorse[17] = "G";
    tablemorse[40] = "H";
    tablemorse[4] = "I";
    tablemorse[79] = "J";
    tablemorse[23] = "K";
    tablemorse[43] = "L";
    tablemorse[8] = "M";
    tablemorse[5] = "N";
    tablemorse[26] = "O";
    tablemorse[52] = "P";
    tablemorse[71] = "Q";
    tablemorse[16] = "R";
    tablemorse[13] = "S";
    tablemorse[2] = "T";
    tablemorse[22] = "U";
    tablemorse[67] = "V";
    tablemorse[25] = "W";
    tablemorse[68] = "X";
    tablemorse[77] = "Y";
    tablemorse[44] = "Z";
    tablemorse[242] = "0";
    tablemorse[241] = "1";
    tablemorse[238] = "2";
    tablemorse[229] = "3";
    tablemorse[202] = "4";
    tablemorse[121] = "5";
    tablemorse[122] = "6";
    tablemorse[125] = "7";
    tablemorse[134] = "8";
    tablemorse[161] = "9";
}

string zuMorse(string input)    {                                                                                       //string input
    string result;
    for (int i = 0; i < input.length(); i++)    {
        char c = input.at(i);                                                                                           //Immer den char von string zuweisen
        int a = int(c);
        result = result + " " + tablealphabet[a];                                                                       //a <- c Tabelle auslesen
    }
    return result;
}

void vonMorse(string input) {
    int anzahl = 0;
    for(int i = 0; i < input.length(); i++) {
        char c = input.at(i);
        if (c == ' ')                                                                                                   //Für Leerzeichen - unterscheidung von Buchstaben
            anzahl++;
    }
    int a=0;
    int code=0;
    int k=0;
    for (int i=0; i <= anzahl; i++) {
        string result;
        code = 0;
        k = 0;
        while (a < input.length() && input.at(a) != ' ')    {
            char c = input.at(a);
            if (c == '*')
                code = code + pow(3, k);                                                                                //über Formel code Berechnen
            else
                code = code + 2 * pow(3, k);
            a++;
            k++;
        }
        result = result + " " + tablemorse[code];
        cout << result;
        a++;
    }
}

int main()  {
    int i;
    cout << "A zu M oder M zu A" << endl;
    cin >> i;

    cin.ignore();
    if(i == 1)  {                                                                                                       //von Alphabet zu Morse:
        tabellezumorse();
        cout << "Bitte geben Sie den zu übersetzenden Text ein: " << endl;
        string s;
        getline(cin, s);
        transform(s.begin(), s.end(), s.begin(), ::toupper);                                                            //getline zu string
        cout << zuMorse(s) << endl;
    }
    if(i == 2) {                                                                                                        //von Morse zu Alphabet
        tabellevonmorse();
        cout << "Bitte geben Sie den zu übersetzenden Text ein: " << endl;
        string m;
        getline(cin, m);
        vonMorse(m);
    }
}
