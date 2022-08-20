/*
 Question 1
*/

#include <iostream>
#include <string>

using namespace std;

int main() {

    double large = 5.99;
    double medium = 4.99;
    double small = 3.99;

    cout << "Coffe Size Options: " << endl;
    cout << "l - large" << endl;
    cout << "m - medium" << endl;
    cout << "l - large" << endl;

    cout << "Enter a coffee size: ";
    string size;
    cin >> size;

    if (size == "l") {
        cout << "Price: $";
        cout << large;
    }
    else if (size == "m") {
        cout << "Price: $";
        cout << large;
    }
    else if (size == "s") {
        cout << "Price: $";
        cout << small;
    }
    else {
        cout << "Invalid Input";
    }

    return 0;
}