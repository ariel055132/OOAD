#include <iostream>

using namespace std;

void swapWithPointers(int *num1, int *num2) {
    int tmp;
    tmp = *num1;  //  dereference
    *num1 = *num2;
    *num2 = tmp;
}

int main() {
    int n1 = 5;
    int n2 = 10;
    cout << n1 << " " << n2 << endl;
    swapWithPointers(&n1, &n2);
    cout << n1 << " " << n2 << endl;
    return 0;
}