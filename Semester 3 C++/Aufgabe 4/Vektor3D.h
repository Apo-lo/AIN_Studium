//
// Created by FH on 2019-05-07.
//

#ifndef UEBUNG4_VEKTOR3D_H
#define UEBUNG4_VEKTOR3D_H


class Vektor3D {
    float x, y, z;

private:
    friend bool operator==(Vektor3D & temp1, Vektor3D & temp2){
        return (temp1.x == temp2.x) && (temp1.y == temp2.y) && (temp1.z == temp2.z);
    }
public:
    Vektor3D(float a = 0, float b = 0, float c = 0):
        x(a), y(b), z(c){
    }

    friend Vektor3D operator+(Vektor3D temp1, Vektor3D temp2) {
        Vektor3D temp;

        temp.x = temp1.x + temp2.x;
        temp.y = temp1.y + temp2.y;
        temp.z = temp1.z + temp2.z;

        return temp;
    }

    friend Vektor3D operator-(Vektor3D temp1, Vektor3D temp2){
        Vektor3D temp;

        temp.x = temp1.x - temp2.x;
        temp.y = temp1.y - temp2.y;
        temp.z = temp1.z - temp2.z;

        return temp;
    }

    float operator*(Vektor3D temp1){
        float temp = 0;

        temp = (x * temp1.x) + (y * temp1.y) + (z * temp1.z);

        return temp;
    }

    Vektor3D operator++(){  //Prefix
        x++;
        y++;
        z++;

        return *this;
    }

    Vektor3D operator++(int d){ //Postfix
        Vektor3D temp = *this;
        x++;
        y++;
        z++;

        return temp;
    }

    Vektor3D operator--(){  //Prefix
        x--;
        y--;
        z--;

        return *this;
    }

    friend std::ostream& operator<<(std::ostream& out, Vektor3D temp){
        out << '(' << temp.x << '/' << temp.y << '/' << temp.z << ')' << std::endl;

        return out;
    }

//    friend std::istream& operator>>(std::istream& in, Vektor3D temp1){
//        in >> temp1.x >> temp1.y >> temp1.z;
//        return in;
//   }
};


#endif //UEBUNG4_VEKTOR3D_H
