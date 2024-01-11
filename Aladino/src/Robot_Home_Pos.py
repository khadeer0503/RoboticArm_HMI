from robolink import *
from robodk import *

'''
# Enter RoboDK IP and Port
ROBOT_IP = None  #'192.168.2.31'
ROBOT_PORT = 30003

# Retrieve Robot's IP:
if ROBOT_IP is None:
    ip, port, path, ftpuser, ftppass = robot.ConnectionParams()
    ROBOT_IP = ip

ROBOT_JOINTS = None
last_joints_target = None
last_joints_refresh = None
'''

# Initialize RoboDK API
RDK = Robolink()

# Define global variables
accel_radss = 100
speed_rads = 50
accel_mss = 1
speed_ms = 0.1


robot = RDK.Item('UR16e')      # retrieve the robot by name
robot.setJoints([0,-90,-90,90,90,0])      # set all robot axes to zero

# Retrieve a robot
#robot = RDK.ItemUserPick('Select a UR robot to retrieve current position', ITEM_TYPE_ROBOT)
if not robot.Valid():
    quit()
 # Run a program named Prog1 available in the RoboDK station
RDK.RunCode("Robot_Home_Pos", True)

print("Setting robot to the Home Position")

# specify the program name for program generation
#RDK.ProgramStart('Prog1','C:/MyProgramFolder/', "ur16e", robot)
