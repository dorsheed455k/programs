/*
* b)
*/

#include <iostream>

using namespace std;

  int main() {
    int num;

    cout << "Enter an number: ";

    cin >> num;
    cout << "Prime numbers between 1 and " << num << ":\n";

    for (int i = 2; i < num; i++) {
        bool prime = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                prime = false;
                break;
            }
        }
        if (prime) cout << i << endl;
    }

    return 0;

}  

