/*
*  Quadratic Equation
*/

#include <iostream>
#include <cmath>

using namespace std;

/* int main() {
	// a)

	int a, b, c;
	double det;
	double root1, root2;

	cout << "Enter a: ";
	cin >> a;

	cout << "Enter b: ";
	cin >> b;

	cout << "Enter c: ";
	cin >> c;

	det = (pow(b, 2) - (double) 4 * a * c);
	if (det < 0) {
		cout << "No roots exist" << endl;

	} else {
		det = sqrt(det);
		root1 = (double) -1 * b + det;
		root2 =  (double) -1 * b - det;

		root1 /= (double) 2 * a;
		root2 /= (double) 2 * a;

		cout << "Root 1: " << root1 << endl;
		cout << "Root 2: " << root2 << endl;
	}

	/* b) The integer data type should be used in the program to represent coeffiecients
	*      as it does not require as much memory to store values, about 32 bits as opposed to 64 bits with double
	*      meaning it will take up less memory and can be casted to a double later for calculations
	*

	return 0;
}  */