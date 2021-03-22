#include <iostream>

using namespace std;

class Vehicle {
    public:
        Vehicle() {
            cout << "Vehicle Constructor" << endl;
        }
        virtual ~Vehicle() {
            cout << "Vehicle Destructor" << endl;
        }
        virtual void accelerate() const {
            cout << "Vehicle Accelerating" << endl;
        }

        void setAcceleration(double a) {
            acceleration = a;
        }
        double getAcceleration() const {
            return acceleration;
        }
    protected:
        double acceleration;
};

class Car : public Vehicle {
    public:
        Car() {
            cout << "Car Constructor" << endl;
        }
        virtual ~Car() {
            cout << "Car Destructor" << endl;
        }
        virtual void accelerate() const {
            cout << "Car Accelerating" << endl;
        }
        void drive() const {
            cout << "Car Driving" << endl;
        }
};

int main() {
    Car myCar;
    myCar.setAcceleration(9.81);
    cout << "Accelerating at " << myCar.getAcceleration() << " m/(s*s)" << endl;
    myCar.accelerate();
    myCar.drive();
    return 0;
}