from robolink import *
from robodk import *

# Initialize RoboDK API
RDK = Robolink()

# Define global variables
accel_radss = 100
speed_rads = 100
accel_mss = 1
speed_ms = 0.1

robot = RDK.Item('UR16e')      # retrieve the robot by name
#robot.setJoints([0,-90,-90,90,90,0])      # set all robot axes to zero

# Connect to the robot using default IP
robot_ip = '192.168.56.95'
robot_port = 30002
success = robot.Connect(robot_ip, robot_port)

if not success:
    raise Exception("Failed to connect to the robot")

# Set the run mode to run on the robot
RDK.setRunMode(RUNMODE_SIMULATE)
#RDK.setRunMode(RUNMODE_RUN_ROBOT)

# Run a program named prog_Movement available in the RoboDK station
RDK.RunCode("prog_Movement", True)



print("Rectangle Program for testing with Web Application ")



'''
from robolink import *
from robodk import *

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

#RUN_ON_ROBOT = True

# Important: by default, the run mode is RUNMODE_SIMULATE
# If the program is generated offline manually the runmode will be RUNMODE_MAKE_ROBOTPROG,
# Therefore, we should not run the program on the robot

if RDK.RunMode() != RUNMODE_SIMULATE:
    RUN_ON_ROBOT = False

if RUN_ON_ROBOT:
    # Update connection parameters if required:
   # robot.setConnectionParams('192.168.56.95',30002,'/', 'anonymous','')

    # Connect to the robot using default IP
    success = robot.Connect()  # Try to connect once
    #success robot.ConnectSafe() # Try to connect multiple times
    status, status_msg = robot.ConnectedState()
    if status != ROBOTCOM_READY:
        # Stop if the connection did not succeed
        print(status_msg)
        raise Exception("Failed to connect: " + status_msg)

    # This will set to run the API programs on the robot and the simulator (online programming)
#RDK.setRunMode(RUNMODE_MAKE_ROBOTPROG)
    # Note: This is set automatically when we Connect() to the robot through the API
#   RDK.setRunMode(RUNMODE_RUN_ROBOT,RUNMODE_MAKE_ROBOTPROG,RUNMODE_SIMULATE)
 # Run a program named Prog1 available in the RoboDK station
RDK.RunCode("prog_Movement", True)
#RDK.setRunMode(RUNMODE_RUN_ROBOT)
print("Rectangle Program for testing with Web Application ")
# specify the program name for program generation
#RDK.ProgramStart('Prog1','C:/MyProgramFolder/', "ur16e", robot)

'''