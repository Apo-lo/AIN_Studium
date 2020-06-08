#ifndef UEBUNG_2_KARTEIKARTE_H
#define UEBUNG_2_KARTEIKARTE_H


class Karteikarte {

private:
    std::string Author;
    std::string Buchtitel;
    int Anzahl;

    std::string getAuthor() {return Author; }

    std::string getBuchtitel()  {return Buchtitel; }

    int getAnzahl() { return Anzahl; }

public:
    void setAuthor(std::string x)   { Author = std::move(x); }

    void setBuchtitel(std::string x)    { Buchtitel = std::move(x); }

    void setAnzahl(int x)   { Anzahl = x; }

    void show() {
        std::cout << "Der Name des Authors ist: " << getAuthor() << std::endl << "Der Buchtitel lautet: " << getBuchtitel() << std::endl
        << "Die Anzahl vorhandener Buchexemplare ist: " << getAnzahl() << std::endl;
    }
};

#endif //UEBUNG_2_KARTEIKARTE_H
