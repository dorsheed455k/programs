/*
 Question 2
*/

#include <iostream>
#include <cmath>

using namespace std;

int main() {

    cout << "Enter a value: ";
    int x;
    cin >> x;

    double fcn;
    if (x <= 0) {
        fcn = pow(2, -3 * x);
    }
    else {
        fcn = log(x) + 10;
    }

    cout << fcn;


    return 0;
} 