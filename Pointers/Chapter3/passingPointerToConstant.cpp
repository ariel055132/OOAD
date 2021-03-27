#include <iostream>

using namespace std;

void passingAddressToConst(const int *num1, int* num2) {
    *num2 = *num1;
}

int main() {
    const int limit = 100;
    int result = 5;
    cout << limit << " " << result << endl;
    passingAddressToConst(&limit, &result);
    cout << limit << " " << result << endl;
    return 0;
}
