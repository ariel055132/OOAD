#include <iostream>
using namespace std;
int main() {
    int vector[] = {28, 41, 7};
    int *pi = vector + 2;
    cout << *pi << endl; // 7
    pi--;
    cout << *pi << endl; // 41
    pi--;
    cout << *pi << endl; // 28
}