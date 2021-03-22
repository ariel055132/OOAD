#include <iostream>

using namespace std;

// Percolating up

class Vehicle {
    public:
        Vehicle() {
            //cout << "Vehicle Constructor" << endl;
        }
        virtual ~Vehicle() {
            //cout << "Vehicle Destructor" << endl;
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
            //cout << "Car Constructor" << endl;
        }
        virtual ~Car() {
           // cout << "Car Destructor" << endl;
        }
        virtual void accelerate() const {
            cout << "Car Accelerating" << endl;
        }
        virtual void drive() const {
            cout << "Car Driving" << endl;
        }
        
        // Percolating Up
        virtual void fly() const {
            cout << "Cars can only fall" << endl;
        }
};

class JetCar : public Car {
    public:
        JetCar() {};
        virtual ~JetCar() {}

        virtual void drive() const {
            cout << "JetCar driving" << endl;
        }
        virtual void fly() const {
            cout << "JetCar flying" << endl;
        }
};

// Test function
void analyzePerformance(Car *testVehicle) {
    testVehicle->drive();
    testVehicle->fly();
}

int main() {
    Car myCar;
    JetCar myJetCar;
    analyzePerformance(&myCar);
    analyzePerformance(&myJetCar);
    return 0;
}