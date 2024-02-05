Palletizing using UR16e cobot 
1. ROBOT :
We can consider the Robot just as a Salve who follows the commands of his Master.
A person should be telling the robot to pick/place/drop  each  Item or Box  individually.
If we want the robot to pick an item just we need to run the command or with a simple click, the robot will follow the pick program and the same as the place and drop. 
In placing the item we just need to be precise, about where the item is to be placed. 
WMS (Database)will be responsible for whether the place is available or not. The Box's dimensions/weight/quantity are already saved in the database and the passes to the Cobot for palletizing. Cobot takes as input and places the boxes accordingly.
Note: The position on the Rack is also coming from the Database,so that cobot check the available position and places the box.
 
2. HMI module (Purpose: to show the operating status, and any anomalies(fault).
The missions received to be fulfilled the possibility of manually controlling the machinery on a display on board the machinery)
FUNCTIONALITY/PARAMETERS WHEN CONFIGURING THE MCU(Main control unit):
Present YES/NO 

3. MCU must always know all the information and the operating status of each subsystem that makes up the architecture.

The Robot program has been created in Robodk and this is the HMI programmed using Java-Springboot(Backend) and Thymleaf(Frontend). 
