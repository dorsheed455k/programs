#include <SPI.h>
#include <nRF24L01.h>
#include <RF24.h>
#include <Servo.h>


int dataToReceive[2];

int buttonState = 0;
int servoAngle;

Servo servos[6]; 
// baseServo, joint1Servo, joint2Servo;  // create servo object to control a servo
// Servo wristServo, pitchServo, grapplerServo;  // create servo object to control a servo

int pos[6] = { 90, 180, 20, 490, 90, 180 };

RF24 radio(9, 10); // CE, CSN on Blue Pill
const uint64_t address = 0xE7E7E7E7E7;

 
void setup() {
  Serial.begin(9600);
  radio.begin();
  Serial.print("ADDRESS :");
  radio.openReadingPipe(0, address);   //Setting the address at which we will receive the data
  radio.setPALevel(RF24_PA_MIN);       //You can set this as minimum or maximum depending on the distance between the transmitter and receiver.
  radio.startListening();              //This sets the module as receiver

  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  
  servos[0].attach(8);
  servos[1].attach(7);
  servos[2].attach(6);
  servos[3].attach(5);
  servos[4].attach(4);
  servos[5].attach(3);

  for (int i = 0; i < 6; i++) {
    servos[i].write(pos[i]); 
  }

  //armPosUpdate();

}

void armPosUpdate()
{
    String poses = "";

    for(int i = 0; i<6; i++)
  {
    poses += String(String(pos[i]) + " ");
  }
  
  Serial.println(poses);
}


String readServoPositions()
{
  int i;
  String poses = "";
  pos[0] = (servos[0].read()); //270/180 = 1.5
  pos[1] = (servos[1].read());
  pos[2] = (servos[2].read());
  pos[3] = (servos[3].read());
  pos[4] = (servos[4].read());
  pos[5] = (servos[5].read());

  for(i = 0; i<6; i++)
  {
    poses += String(String(pos[i]) + " ");
  }
  return poses;
}


void loop() {
    delayMicroseconds(100);

    if (radio.available())  {           //Looking for the data. {
       Serial.println("Radio is sniffing");
        radio.read(dataToReceive, sizeof(dataToReceive));    //Reading the data

        servoAngle = dataToReceive[0];
        buttonState = dataToReceive[1];
        Serial.print(servoAngle);
        Serial.print(" ");
        Serial.println(buttonState);

      armPosUpdate();
    //  readServoPositions();

        for (int i = 0; i < 6; i++) {
          if (i == buttonState) {
            if (servoAngle) {
              pos[i] += 5;
            } else  {
              pos[i] -= 5;
            } 

            if (pos[i] < 0) {pos[i] = 0;}
            if (pos[i] > 180) {pos[i] = 180;}
            servos[i].write(pos[i]);
          //  delay(100);
          }
        } 
    

     //   Serial.print(pos[buttonState]);
      //  Serial.print(" ");
     //   Serial.println(buttonState);       
    //  readServoPositions();
  }
}
