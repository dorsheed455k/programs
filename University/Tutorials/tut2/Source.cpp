#define _USE_MATH_DEFINES
#include <iostream> 
#include <cmath>   
using namespace std;

// Declaring variables for circle and sphere radius
int rC, rS;

// Declaring and initializing variables for mass 1, mass 2 and gravity
double m1 = 100.00, m2 = 50.00;
double g = 9.81;


// Defining starting point of program
int main() {

	/* 
	int a(27), b(6), c;
	c = b % a;
	c = 6
	cout << c << endl;
	*/

	/* 
	int a(27), b(6);
	double c;
	c = a / (double) b;
	c = 4.5
	cout << c << endl;  */


	/* 
	int a;
	double b(6), c(18.6);
	a = c / b;
	a = 3
	cout << a << endl; */

	/* 
	int b = 6;
	double a, c(18.6);
	a = (int)c / b;
	a = 3
	cout << a << endl; */


	// Prompting user to enter radius of circle
	cout << "Enter the radius of a circle: ";
	cin >> rC;

	// Prompting user to enter radius of circle
	cout << "Enter the radius of a sphere: ";
	cin >> rS;

	// declaring and initializing variable to hold area of the circle
	double cA = M_PI * ((double) rC * rC);
	// declaring and initializing variable to hold volume the sphere
	double sV = (4 * M_PI * ((double) pow(rS, 3)))/3;

	// Printing area of circle as output
	cout << "Area of the circle: ";
	cout << cA << endl;

	// Printing volume of sphere as output
	cout << "Volume of the sphere: ";
	cout << sV << endl;

	// declaring and storing the tension experienced in a string
	double tension = (2 * m1 * m2 * g) / (m1 + m2);
	// Printing the tension as output
	cout << "Tension in the cord: ";
	cout << tension << endl;


	return 0;
} 