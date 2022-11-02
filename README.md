# Drone_API_Service

## Drones


:scroll: **START**


### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Task description

We have a fleet of **10 drones**. A drone is capable of carrying devices, other than cameras, and capable of delivering small loads. For our use case **the load is medications**.

A **Drone** has:
- serial number (100 characters max);
- model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
- weight limit (500gr max);
- battery capacity (percentage);
- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has: 
- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).

Develop a service via REST API that allows clients to communicate with the drones (i.e. **dispatch controller**). The specific communicaiton with the drone is outside the scope of this task. 

The service should allow:
- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone; 
- checking available drones for loading;
- check drone battery level for a given drone;

> Feel free to make assumptions for the design approach. 

---

### Requirements

While implementing your solution **please take care of the following requirements**: 

#### Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

---

#### Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

---



How to build
Requirements
Java 11
Java IDE (IntelliJ IDEA)
H2 Database (Optional you can use in-memory databse)
Postman(For testing )
Steps by step for building and runing the project locally


Clone the project from the link https://github.com/Legacy721/Drone_API_Service.git



Testing the API

Open Postman to test the API

Registering a drone:

Register a drone using the endpoint localhost:8085/api/v1/drone/register The payload should be in json format like this

{

    "serialNumber": "Q23RT5676697",
    "model": "Lightweight",
    "weightLimit": 500.00,
    "batteryCapacity": 0.60
    
}

The response should be in this json format:

{
    "result": "success",
    "serialNumber": "Q23RT5676697",
    "message": "Drone registered successfully",
    "timeStamp": "2022-11-02T22:10:40.969986"
}




Checking available drones in order to load Medications;

Here is the endpoint- localhost:8085/api/v1/drone/getAvailableDrones

The response should be in this json format:

{
    "result": "success",
    "timeStamp": "2022-11-02T22:10:46.403088",
    "availableDrones": [
        {
            "serialNumber": "Q23RT5676697",
            "model": "Lightweight",
            "weightLimit": 500.0,
            "batteryCapacity": 0.60,
            "state": "IDLE"
        }
    ]
}


Loading a drone with medications;

Here is the endpoint: localhost:8085/api/v1/drone/loadDrone

The request body should be in this json format:

{
    "source":"Benin",
    "serialNumber":"Q23RT5676697",
    "destination":"Abuja",
    "code":"LX3451"
}

The response should be in this json format:

{
    "result": "success",
    "serialNumber": "Q23RT5676697",
    "message": "Drone Loaded Successfully",
    "timeStamp": "2022-11-02T22:11:05.373165"
}


Checking loaded medication items for a given drone;

Here is the endpoint: localhost:8085/api/v1/drone/getLoadedMedicationDetails

For the request body, you will need to pass in the unique serial number of the drone that was loaded with medications.
So the request body should be in this json format:

{
    "serialNumber":"Q23RT5676697"
}

The response body would be in this format below:

{
    "result": "success",
    "serialNumber": "Q23RT5676697",
    "medication": {
        "code": "LX3452",
        "name": "Cepthrin",
        "weight": 150.0,
        "image": "legacy80Z"
    },
    "timeStamp": "2022-11-02T22:11:11.306648"
}


Check drone battery level for a given drone;

Here is the endpoint: localhost:8085/api/v1/drone/checkBatteryLevel

The request body should be in this format:
{
    "serialNumber":"Q23RT5676697"
}

The response body should be in this format:

{
    "status": "success",
    "serialNumber": "Q23RT5676697",
    "batteryLevel": "60%",
    "timeStamp": "2022-11-02T22:10:54.182214"
}


Deliver Load;

Here is the endpoint: localhost:8085/api/v1/drone/deliverLoad

The request body should be in this format:

{
    "serialNumber":"Q23RT5676697"
}

The response body should be in this format:

{
    "result": "success",
    "serialNumber": "Q23RT5676697",
    "message": "Drone delivered successfully",
    "timeStamp": "2022-11-02T22:11:18.254363"
}


Get Loaded drones:

Here is the endpoint: localhost:8085/api/v1/drone/getLoadedDrones

The response body should be in this format

{
    "result": "success",
    "timeStamp": "2022-11-02T22:11:30.393711",
    "availableDrones": []
}


Get Delivered Drones:

Here is the endpoint: localhost:8085/api/v1/drone/getDeliveredDrones

The response should be in this format;

{
    "result": "success",
    "timeStamp": "2022-11-02T22:11:23.962635",
    "availableDrones": [
        {
            "serialNumber": "Q23RT5676697",
            "model": "Lightweight",
            "weightLimit": 500.0,
            "batteryCapacity": 0.60,
            "state": "DELIVERED"
        }
    ]
}



:scroll: **END**
