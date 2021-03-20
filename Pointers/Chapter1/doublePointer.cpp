#include <iostream>

using namespace std;

int main() {
    char *titles[] = {"A tale of Two Cities", "Wuthering Heights",
                    "Don Quixote", "Odyssey", "Moby-Dick",
                    "Halmet", "Gulliver's Travels"};
    char **bestBooks[3];
    char **englishBooks[4];

    bestBooks[0] = &titles[0]; // "A tale of Two Cities"
    bestBooks[1] = &titles[3]; // "Odyssey"
    bestBooks[2] = &titles[5]; // "Halmet"

    for (int i = 0; i < 3; i++)
    {
        cout << bestBooks[i] << endl; // address
        cout << *bestBooks[i] << endl; 
    }

    cout << endl;
    englishBooks[0] = &titles[0]; // "A tale of Two Cities"
    englishBooks[1] = &titles[1]; // "Wuthering Heights"
    englishBooks[2] = &titles[5]; // "Halmet"
    englishBooks[3] = &titles[6]; // "Gulliver's Travels"
    
    for (int i = 0; i < 4; i++)
    {
        cout << englishBooks[i] << endl; // address
        cout << *englishBooks[i] << endl; 
    }
}