#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <Servo.h>


Servo myservo; 
int servoAngle;


RF24 radio(7, 8); // CE, CSN on Blue Pill
const uint64_t address = 0xF0F0F0F0E1LL;


 
void setup() {
  Serial.begin(9600);
  radio.begin();
  Serial.print("ADDRESS :");
  radio.openReadingPipe(0, address);   //Setting the address at which we will receive the data
  radio.setPALevel(RF24_PA_MIN);       //You can set this as minimum or maximum depending on the distance between the transmitter and receiver.
  radio.startListening();              //This sets the module as receiver

  myservo.attach(9);  // attaches the servo on pin 9 to the servo object

  servoAngle = 90;

}
void loop() {
  if (radio.available())   {           //Looking for the data. {
   // Serial.println("Radio is sniffing");
  
    radio.read(&servoAngle, sizeof(servoAngle));    //Reading the data
    Serial.println(servoAngle);
  
    myservo.write(servoAngle);
  }
  
  delay(20);
}
