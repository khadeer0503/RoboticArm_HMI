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
 # Run a program named Prog1 available in the RoboDK station
RDK.RunCode("Pick_Approach_Basic", True)
# specify the program name for program generation
#RDK.ProgramStart('Prog1','C:/MyProgramFolder/', "ABB_RAPID_IRC5", robot)

'''
# Enter RoboDK IP and Port
ROBOT_IP = None  #'192.168.2.31'
ROBOT_PORT = 30003

# Retrieve Robot's IP:
if ROBOT_IP is None:
    ip, port, path, ftpuser, ftppass = robot.ConnectionParams()
    ROBOT_IP = ip

# Define main function
def main():
    Robot_Home_Pos()
    Replace_Objects()
    Pick_Approach()

# Define sub-functions
    def Robot_Home_Pos():
        ref_frame = Pose([0.000000, 0.000000, 0.000000, 0.000000, 0.000000, 0.000000])
        set_tcp(Pose([0.000000, 0.000000, 0.120000, 0.000000, 0.000000, 0.000000]))
        movej([0.000000, -1.570796, -1.570796, 0.000000, 1.570796, 0.000000], accel_radss, speed_rads, 0, 0)
        movej([0.000000, -1.570796, -1.570796, 0.000000, 1.570796, 0.000000], accel_radss, speed_rads, 0, 0) # end trace

    def Replace_Objects():
    # Implement Replace_Objects functionality here

     def Pick_Approach():
        Rail_Pos_1()
        movel([0.000000, -1.570796, -1.570796, 1.570796, 1.570796, -0.000000], accel_mss, speed_ms, 0, 0)
        movel([-1.570796, -1.570796, -1.570796, 1.570796, 1.570796, 0.042164], accel_mss, speed_ms, 0, 0)
        movel([-3.141593, -1.570622, -1.570796, 1.570796, 1.570796, -0.000000], accel_mss, speed_ms, 0, 0) # end trace
        Rail_Pos_0()
        Open_Gripper()

    def Rail_Pos_0():
    # Implement Rail_Pos_0 functionality here

     def Rail_Pos_1():
    # Implement Rail_Pos_1 functionality here

      def Open_Gripper():
    # Implement Open_Gripper functionality here


# Call main function
       if __name__ == "__main__":
         main()

'''


