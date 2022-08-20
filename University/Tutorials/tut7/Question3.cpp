/*
*  c)
*/

#include <iostream>

using namespace std;

int main() {


    double amount;
    double coins[] = { 2, 1, 0.25, 0.1, 0.05, 0.01 };
    string name[] = { "Toonie(s)", "Dollar(s)", "Quarter(s)", "Dime(s)", "Nickel(s)", "Penny(s)" };

    cout << "Enter an amount of money: ";

    cin >> amount;


    for (int i = 0; i < 6; i++) {
        int count = 0;
        double temp = amount;
        while (temp >= coins[i]) {
            temp -= coins[i];
            count++;
        }
        if (count == 0) continue;
        cout << count << " " << name[i] << endl;

        amount = temp;
    }
    return 0;
} 