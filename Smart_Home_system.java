// Simple Smart home System
class Device{
    void turnOn()
    {
        System.out.println("Turn on the appliances..");
    }
    void turnOff()
    {
        System.out.println("Turn of the appliances");
    }
}

class Thermostat extends Device{
    void setTemperature(int temperature)
    {
        System.out.println("The temperature of the room is :"+temperature+"C");
    }
}

class Smartlight extends Device
{
    void changecolor(String color)
    {
        System.out.println("The color of the light gets changed on based on the temperature"+color);
    }
}

interface WifiEnabled{
    void connectToWifi();
}

interface BlueTooth{
    void pairWithDevice();
}

class Smartspeaker extends Device implements WifiEnabled,BlueTooth{
    public void connectToWifi()
    {
        System.out.println("Connect the iot to wifi");
    }
    public void pairWithDevice()
    {
        System.out.println("And pair to the  Bluetooth Device");
    }
    void playMusic(String song)
    {
        System.out.println("Plays a very Energetic song : "+song);
    }
}

class Main{
    public static void main(String[] args) {
        Device dev=new Device();
        Thermostat th=new Thermostat();
        Smartlight st=new Smartlight();
        Smartspeaker sm=new Smartspeaker();

        dev.turnOn();
        dev.turnOff();

        th.setTemperature(36);
        st.changecolor("Yellow");

        sm.connectToWifi();
        sm.pairWithDevice();
        sm.playMusic("Master the Blaster song...");
        System.out.println("Happy Ending");

    }
}
