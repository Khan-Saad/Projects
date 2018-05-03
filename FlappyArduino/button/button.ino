
int switchState = 0;
void setup() 
{
//initialize serial communications at a 9600 baud rate
Serial.begin(9600);
pinMode(7, INPUT);
int switchsState = 0;
}

void loop()
{
  switchState = digitalRead(7);
  if(switchState == LOW){
    Serial.write(1);
  }
  else{
    Serial.write(0);
    
  }
  delay(40);
}
