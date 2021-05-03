#include <iostream>

using namespace std;

class A {
    public:
        // Constructor
        A() {
            cout << "A's constructor called" << endl;
        }
};

class B {
    public:
        // Constructor
        B() {
            cout << "B's constructor called" << endl;
        }
};

// inheritance from B first, then A
// call B constructor first
// then call A
// finally call C
class C: public B, public A {
    public:
        C() {
            cout << "C's constructor called" << endl;
        }
};

int main() {
    C C;
    return 0;
}