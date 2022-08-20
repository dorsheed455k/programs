/*
* a)
*/
#include <iostream>

using namespace std;

int main() {

    int grade;

    int max = 0;
    int min = 100;
    int n = 0;
    int sum = 0;
    cout << "Enter Grades: " << endl;
    cin >> grade;
    do {
        if (grade > 100 || grade < 0) {
            cout << "Invalid Grade" << endl;
            break;
        }
        sum += grade;
        if (grade < min) {
            min = grade;
        }
        if (grade > max) {
            max = grade;
        }
        n++;
        cin >> grade;
    } while (grade != -1);

    double avg;



    cout << "Minimum Grade: " << min << endl;
    cout << "Maximum Grade: " << max << endl;

    if (n > 0) {
        avg = sum / n;
        cout << "Average Grade: " << avg << endl;
    }
    else {
        cout << "No Grades Available" << endl;
    }

    return 0;

}