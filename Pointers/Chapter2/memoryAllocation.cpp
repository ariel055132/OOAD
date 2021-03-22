#include <iostream>

using namespace std;

int main() {
    int *pi = (int*) malloc(sizeof(int));
    *pi = 5;
    cout << *pi << endl; 
    free(pi);
    return 0;
}