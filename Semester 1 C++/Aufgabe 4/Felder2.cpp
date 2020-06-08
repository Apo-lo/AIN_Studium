#include <iostream>

using namespace std;

int max(int v[], int n) {
    int maximum = v[0];

    for (int i = 0;i < n;i++)
    {
        if(v[i] > maximum)
        {
            maximum = v[i];
        }
    }
    return maximum;
}

int main()  {
    int v[9] = {12, 123, 51, 72, 4, 8, 19, 44, 105};

    cout << "Das größte Element im Array ist " << max(v,9) << endl;
}

