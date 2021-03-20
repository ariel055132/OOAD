#include <iostream>

using namespace std;

int main() {
    int *pi = (int*) malloc(sizeof(int));
    *pi = 5;
    cout << pi << endl; // memory address
    cout << *pi << endl; // value
    free(pi);
    //free(pi); // double free detected in tcache2 (exception)
    return 0;
}