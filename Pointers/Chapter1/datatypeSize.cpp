#include <iostream>

using namespace std;

int main() {
    int a;
    float b;
    double c;
    long d;
    char e;
    cout << sizeof(a) << endl; // (int) 4 bytes
    cout << sizeof(b) << endl; // (float) 4 bytes
    cout << sizeof(c) << endl; // (double) 8 bytess
    cout << sizeof(d) << endl; // (long) 8 bytes
    cout << sizeof(e) << endl; // (char) 1 bytes
}