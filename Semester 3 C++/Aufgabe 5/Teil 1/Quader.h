//
// Created by FH on 2019-05-14.
//

#ifndef UEBUNG5_1_QUADER_H
#define UEBUNG5_1_QUADER_H

#include "Rechteck.h"

class Quader: public Rechteck  {
private:
    float hoehe = 0;
public:
    Quader(){
    }

    void setHoehe(float x){
        hoehe = x;
    }

    float getHoehe(){
        return hoehe;
    }

    float qFlache(){
        return (2 * (getBreite() * getHoehe())) + (2 * (getBreite() * getLeange())) + (2 * (getLeange() * getHoehe()));
    }

    float volumen(){
        return getHoehe() * getLeange() * getBreite();
    }
};


#endif //UEBUNG5_1_QUADER_H
