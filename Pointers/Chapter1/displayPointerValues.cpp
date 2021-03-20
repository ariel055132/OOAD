#include <iostream>

using namespace std;

int main() {
    int num = 0;
    int *pi = &num;

    cout << "Address of num " << &num << endl;
    cout << "Address of pi " << &pi << endl;
    return 0;
}