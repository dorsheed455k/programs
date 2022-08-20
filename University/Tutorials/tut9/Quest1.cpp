#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

float sum(float[]);
float avg(float[]);
float min(float[]);
float max(float[]);
float* bsort(float[]);
float* reverse(float[]);
int bsearch(float[], float, int);
void display(float[]);

int main() {
    string name = "temprature.txt";
    ifstream input_file;
    input_file.open(name.c_str());

    float temp[22];
    char junk;
    double a;


    input_file >> temp[0];
    int i = 1;

    while (!input_file.eof()) {
        if (!input_file) {
            input_file.clear();
            input_file.get(junk);
        }

        input_file >> temp[i];
        i++;
    }

    cout << "Displaying Temperatures: ";
    display(temp);

    cout << "Sum of temperatures: ";
    cout << sum(temp) << endl;

    cout << "Average of temperatures: ";
    cout << avg(temp) << endl;

    cout << "Minimum temperatures: ";
    cout << min(temp) << endl;

    cout << "Maximum temperatures: ";
    cout << max(temp) << endl;

    cout << "Sort temperatures in ascending order: ";
    display(bsort(temp));

    float n;
    cout << "Find the index of a certain temperature: ";
    cin >> n;
    cout << "Index: " << bsearch(temp, n, 22) << endl;

    cout << "Reversed list of temperatures: ";
    display(reverse(temp));

    input_file.close();

    return 0;
}

float sum(float arr[]) {
    float sumArray = 0;
    for (int i = 0; i < 22; i++) {
        sumArray += arr[i];
    }

    return sumArray;
}

float avg(float arr[]) {
    float avg = sum(arr) / 22;

    return avg;
}

float min(float arr[]) {
    float min = 100;
    for (int i = 0; i < 22; i++) {
        if (min > arr[i]) {
            min = arr[i];
        }
    }

    return min;
}

float max(float arr[]) {
    float max = 0;
    for (int i = 0; i < 22; i++) {
        if (max < arr[i]) {
            max = arr[i];
        }
    }

    return max;
}

float* bsort(float arr[]) {
    float* arr2 = arr;
    for (int i = 0; i < 22; i++) {
        for (int j = i + 1; j < 22; j++) {
            if (arr2[j] < arr2[i]) {
                float temp = arr2[i];
                arr2[i] = arr2[j];
                arr2[j] = temp;
            }
        }
    }
    return arr2;
}

float* reverse(float arr[]) {
    float* arr2 = arr;
    int j = 21;
    for (int i = 0; i < j; i++, j--) {
        float temp = arr2[i];
        arr2[i] = arr2[j];
        arr2[j] = temp;
    }
    return arr2;
}

int bsearch(float arr[], float value, int size) {
    int top(0), bottom(size - 1), mid;
    while (top <= bottom) {
        mid = (top + bottom) / 2;
        if (arr[mid] == value) {
            return mid;
        }
        else if (arr[mid] > value) {
            bottom = mid - 1;
        }
        else
            top = mid + 1;
    }
    return -1;
}


void display(float arr[]) {
    for (int i = 0; i < 22; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}





