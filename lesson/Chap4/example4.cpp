#include <iostream>

using namespace std;

// Multiple Inheritance

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
            cout << "Car constructor" << endl;
        }
        virtual ~Car() {
            cout << "Car destructor" << endl;
        }

        virtual void accelerate() const {
            cout << "Car Accelerating" << endl;
        }
        
        virtual void drive() const {
            cout << "Car Driving" << endl;
        }
};

class Jet : public Vehicle {
    public:
        Jet() {
            cout << "Jet constructor" << endl;
        }
        virtual ~Jet() {
            cout << "Jet Destructor" << endl;
        }

        virtual void fly() const {
            cout << "Jet flying" << endl;
        }
};

// Multiple inheritance
class JetCar : public Car, public Jet {
    public:
        JetCar() {
            cout << "JetCar constructor" << endl;
        }
        virtual ~JetCar() {
            cout << "JetCar destructor" << endl;
        }

        // drive method is inheritanced from Car and override it
        virtual void drive() const {
            cout << "JetCar driving" << endl;
        }
        // fly method is inheritanced from Jet and override it
        virtual void fly() const {
            cout << "JetCar flying" << endl;
        }
};

void analyzeCarPerformance(Car *testVehicle) {
    testVehicle->drive();
}

void analyzeJetPerformance(Jet *testVehicle) {
    testVehicle->fly();
}

int main() {
    Car myCar;
    Jet myJet;
    JetCar myJetCar;

    cout << endl << endl;
    cout << "Car testing in progress" << endl;
    analyzeCarPerformance(&myCar);
    analyzeCarPerformance(&myJetCar);
    cout << "Jet testing in progress" << endl;
    analyzeJetPerformance(&myJet);
    analyzeJetPerformance(&myJetCar);
    cout << endl << endl;
    return 0;
}