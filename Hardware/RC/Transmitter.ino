#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <Encoder.h>


#define CLK 2
#define DT 3
#define SW 4

int counter = 0;
int currentStateCLK;
int lastStateCLK;
String currentDir = "";


const int homePosition = 90;
const int stepValue = 5;
const int servoPin = 9;

int servoAngle = homePosition;

Encoder myEnc(CLK, DT);
RF24 radio(7, 8); // CE, CSN on Blue Pill 
const uint64_t address = 0xF0F0F0F0E1LL;
 
void setup() 
{
  radio.begin();                  //Starting the Wireless communication
  radio.openWritingPipe(address); //Setting the address where we will send the data
  radio.setPALevel(RF24_PA_MIN);  //You can set it as minimum or maximum depending on the distance between the transmitter and receiver.
  radio.stopListening();          //This sets the module as transmitter
  
  pinMode(CLK, INPUT);
  pinMode(DT, INPUT);
  pinMode(SW, INPUT_PULLUP);

  Serial.begin(9600);
}

long oldPosition  = -999;

 
void loop()
{
  long newPosition = myEnc.read();
  if (newPosition != oldPosition) {
    if (newPosition > oldPosition) {
      int newStep = abs(newPosition - oldPosition);
      servoAngle -= stepValue;
      if (servoAngle < 0)
        servoAngle = 0;
      
    }

    if (newPosition < oldPosition) {
      servoAngle += stepValue;
      if (servoAngle > 180)
          servoAngle = 180;
    }

    if (digitalRead(SW) == LOW) {
      servoAngle = homePosition;      
    }
    oldPosition = newPosition;
  }
//  Serial.println(servoAngle);
  radio.write(&servoAngle, sizeof(servoAngle)); 
  delay(20); 

}
