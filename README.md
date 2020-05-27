![Santorini logo](https://github.com/marco-weger/ing-sw-2020-weger-paterna-saulle/blob/master/src/main/resources/it.polimi.ingsw/view/gui/img/scene/top.png)

# Final project of Software Engineering - 2020

This project was made between March and July 2020 as our final thesis project at Politecnico di Milano. <br>
 **Marco Weger** ([@marco-weger](https://github.com/marco-weger)) <br>
 **Francesco Paterna** ([@FrancescoPaterna](https://github.com/FrancescoPaterna)) <br>
 **Giulio Saulle** ([@aGiulioSaulle](https://github.com/GiulioSaulle))


## Quick Index
* [prerequirements](#Prerequirements)
* [get JARs files](#Get-JARs)
* [json config](#Configuration)
* [start Client](#Start-Client)
* [start Server](#Start-Server)
* [specification covered](#Specification-Covered)
* [server status](#Santorini-Official-Server)


## Prerequirements

You need **JavaSE 14** or higher version to run this game.    
https://www.oracle.com/java/technologies/javase-downloads.html

If you use **Windows** and want to run the game in **CLI mode**, we suggest you to use the Bash on [WSL](https://en.wikipedia.org/wiki/Windows_Subsystem_for_Linux) to a better expirience
https://docs.microsoft.com/en-us/windows/wsl/install-win10


## Get JARs

You can find them [here](https://github.com/marco-weger/ing-sw-2020-weger-paterna-saulle/tree/master/deliverables/jars) or you can generate them yourself with Maven

###### JARs with Maven (OPTIONAL)
###### Client
```bash
mvn clean compile assembly:single -PClient
```
###### Server
```bash
mvn clean compile assembly:single -PServer
```


## Configuration (Optional)
<!-- Talk about JSON and saved-match -->
An optional [JSON file](resources/config.json) could be saved in *./resources/config.json*; if the software can't find the file it will use default value, written in square brackets.
<br>
Allowed params:
* ip (used by client) [127.0.0.1] - addres of server
* port (used by cliend and server) [1234] - socket port
* pingPeriod (used by cliend and server) [2] - useed to keep safeily alive the connection
* timeoutSocket (used by cliend and server) [5] - useed to keep safeily alive the connection
* disconnectTimer (used by server) [60] - timer used to handle a diconnection during a match
* turnTimer (used by server) [180] - timer for a singel turn

## Start Game
Enjoy Santorini in GUI mode or try the 90s Experience with CLI mode.<br>
Download and run **client.jar** and **put in the same folder** the directory [resources](https://github.com/marco-weger/ing-sw-2020-weger-paterna-saulle/tree/master/deliverables/jars) with the json file.<br>You will play in our Official Server (Check [here](#Santorini-Official-Server) if our Server is available) <br><br>
You can also play Santorini with your own Server, just run **Server.jar** on your pc, and set your ip on JSON file. <br> (if you prefer, **you can avoid to use JSON file**,just don't put the directory resources in client.jar's folder,<br> the game will ask you the ip and the port that you want to use).


#### Start Client
```bash
java -jar Client.jar
```
or
```bash
java -jar Client.jar [CLI/GUI]
```
If you decide to run it withouth the arg, you will play in GUI mode.
#### Start Server
```bash
java -jar Server.jar
```

<!--

PATHTOJAVAFX is the path to JavaFX 12 (the lib folder!!) and changes depending on where you saved your JavaFX on your PC.

#### Testing persistence and reconnection
When reconnecting, remember to vote for the same map the game was being played on before disconnection!
-->

## Specification Covered
| Functionality | State |
|:-----------------------|:------------------------------------:|
| Basic rules | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| Complete rules | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| Socket | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| GUI | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| CLI | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| Multiple games | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |
| Persistence | [![GREEN](https://placehold.it/15/44bb44/44bb44)](#) |

<!--
[![RED](https://placehold.it/15/f03c15/f03c15)](#)
[![YELLOW](https://placehold.it/15/ffdd00/ffdd00)](#)
[![GREEN](https://placehold.it/15/44bb44/44bb44)](#)
-->

## Santorini Official Server 
Powered by Microsoft Azure

| Server |State| State | Turn Timer |
|:-------|:-----|:------|:-----:|
| 52.136.XXX.XXX |🇮🇹|[![GREEN](https://placehold.it/15/44bb44/44bb44)](#) &nbsp; Ready To Game| 03:00 |
| 40.84.XXX.XXX |🇺🇸|[![YELLOW](https://placehold.it/15/ffdd00/ffdd00)](#) &nbsp; On Request| 03:00 |


![Santorini logo](https://github.com/marco-weger/ing-sw-2020-weger-paterna-saulle/blob/master/src/main/resources/it.polimi.ingsw/view/gui/img/scene/bottom.png)
