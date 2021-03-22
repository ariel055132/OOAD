#include<iostream>

using namespace std;

void swapWithReferences(int &num1,int &num2) {
    int tmp;
    tmp = num1;
    num1 = num2;
    num2 = tmp;
}

int main() {
    int n1 = 5;
    int n2 = 10;
    cout << n1 << " " << n2 << endl;
    swapWithReferences(n1, n2);
    cout << n1 << " " << n2 << endl;
}