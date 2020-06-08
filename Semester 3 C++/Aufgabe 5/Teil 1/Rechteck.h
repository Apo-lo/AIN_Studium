//
// Created by FH on 2019-05-14.
//

#ifndef UEBUNG5_1_RECHTECK_H
#define UEBUNG5_1_RECHTECK_H


class Rechteck {
protected: //protected wegen getter und setter im Quader
    float laenge = 0;
    float breite = 0;

public:
    Rechteck(){
    }

    float getBreite(){
        return breite;
    }

    float getLeange(){
        return laenge;
    }

    void setBreite(float x){
        breite = x;
    }

    void setLeange(float x){
        laenge = x;
    }

    float umfang(){
        return (2 * laenge) + (2 * breite);
    }

    float rFlache(){
        return laenge * breite;
    }
};


#endif //UEBUNG5_1_RECHTECK_H
