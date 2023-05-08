#include <OneWire.h>
#include <dht.h>


OneWire  ds(10);  // on pin 10 (a 4.7K resistor is necessary)

int bigNTCsensor = A0;
int sensorPin = A1;
int DHT1 = 7;
dht DHT;


void setup(void) {
  Serial.begin(9600);
}

void loop(void) {

/* LM35 sensor
  int reading = analogRead(sensorPin);
  float voltage = reading * (5.0 / 1024.0);
  float temperatureC = voltage * 100;
  Serial.print("LM35 Temperature sensor: ");
  Serial.print(temperatureC);
  Serial.print("\xC2\xB0"); // shows degree symbol
  Serial.println("C");
  */
  
  
/* Thermistor Sensor
  int readVal = analogRead(bigNTCsensor);
  double temp = Thermistor(readVal);
  Serial.print("Thermistor Temperature sensor is = ");
  Serial.print(temp);
  Serial.println(" Celcius, ");
  */

  /* Temperature and humidity sensor
    int chk = DHT.read11(DHT1);
    Serial.print("DHT11 Sensor: Temperature = ");
    Serial.print(DHT.temperature);
    Serial.print(" C");
    Serial.print(" | Humidity = ");
    Serial.println(DHT.humidity);
    Serial.println(); */

    int reading = analogRead(sensorPin);
    float voltage = reading * (5.0 / 1024.0);
    float temperatureC = voltage * 100;

    int readVal = analogRead(bigNTCsensor);
    double temp = Thermistor(readVal);
    Serial.print(temperatureC);
    Serial.print(" ");
    Serial.print(temp);
    Serial.print(" ");
    int chk = DHT.read11(DHT1);
    Serial.println(DHT.temperature);
    delay(1000);
}

double Thermistor(int RawACD) {
  double Temp;
  Temp = log(10000.0*(1024.0/RawACD-1));
  Temp = 1/(0.001129148 + (0.000234125 +(0.0000000876741 * Temp * Temp)) * Temp);
  Temp = Temp - 273.15;
  return Temp;
}
