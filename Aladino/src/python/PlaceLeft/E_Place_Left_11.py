from robolink import *
from robodk import *

# Initialize RoboDK API
RDK = Robolink()
'''
# Define global variables
accel_radss = 100
speed_rads = 50
accel_mss = 1
speed_ms = 0.1
'''
robot = RDK.Item('UR16e')      # retrieve the robot by name
'''
robot.setJoints([0,-90,-90,90,90,0])      # set all robot axes to zero

# Retrieve a robot
#robot = RDK.ItemUserPick('Select a UR robot to retrieve current position', ITEM_TYPE_ROBOT)
if not robot.Valid():
    quit()
'''
 # Run a program named Prog1 available in the RoboDK station
RDK.RunCode("E_Place_Left_11", True)
print("Placing the Box ")
# specify the program name for program generation
#RDK.ProgramStart('Prog1','C:/MyProgramFolder/', "ABB_RAPID_IRC5", robot)

