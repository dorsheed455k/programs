/*
*
*  Problem 2. Integer Sum
*  Feb 15 2022
*/


#include <iostream>
#include <cmath>

using namespace std;

 int main() {
	int a, n;

	cout << "Enter a: ";
	cin >> a;

	cout << "Enter n: ";
	cin >> n;

	int d = 1;


	int sum = (n / 2) * (2 * a + (n - 1)*d);

	cout << "The integer sum between the two numbers is " << sum << endl;

	return 0;

}  