#include <iostream>

using namespace std;

void berechne_b(bool a [], bool b[])    {
    b[0] = !a[0];
    b[1] = (a[0] && !a[1]) || (!a[0] && a[1]);
    b[2] = ((a[0] && a[1]) || a[2]) && !(a[0] && a[1] && a[2]);
}

void berchene_c(bool b[], bool c[]) {
    c[0] = b[0] * !b[2] + !b[0] * b[2];
    c[1] = !b[0] * !b[1] * b[2];
    c[2] = !b[0] * b[2];
    c[3] = b[2] * !(b[0] * b[1]) + b[0] * !b[1] * !b[2];
    c[4] = !(b[0] * b[1] * b[2] + !b[0] * !b[1] * !b[2]);
    c[5] = b[2] * !(b[0] * b[1]) + b[0] * !b[2];
    c[6] = !b[2] * (b[0] + b[1]) + !b[0] * b[1] * b[2];
}

void LCD(bool c[])  {
    if (c[0])
        cout << "* * * * *" << endl;
    else
        cout << "         " << endl;

    if (c[5] && c[1])
        cout << "*       *" << endl << "*       *" << endl;
    else if (c[5])
        cout << "*" << endl << "*" << endl;
    else if (c[1])
        cout << "        *" << endl << "       *" << endl;
    else
        cout << "         " << endl << "        " << endl;

    if (c[6])
        cout << "* * * * *" << endl;
    else
        cout << "         " << endl;

    if (c[4] && c[2])
        cout << "*       *" << endl << "*       *" << endl;
    else if (c[4])
        cout << "*" << endl << "*" << endl;
    else if (c[2])
        cout << "       *" << endl << "       *" << endl;
    else
        cout << "        " << endl << "        " << endl;

    if (c[3])
        cout << "* * * * *" << endl;
    else
        cout << "         " << endl;
}


int main()  {
    bool a[3] = {0, 0 ,0};
    bool b[3], c[7];

    for (int x = 0;x < 6;x++)   {
        berechne_b(a, b);
        berchene_c(b, c);
        LCD(c);

        for (int i = 0; i < 3; i++)
            a[i] = b[i];
    }

}
