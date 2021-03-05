# vaccine-now
Vaccination Now 

Below are the APIs created :

1.getAllBranches() 
  GET   /vaccine-now/branches
  Description : This APi returns all the branches with address details 
  Response Sample :    {
			    "branches": [
				{
				    "name": "Covid Vaccine Booth",
				    "location": "Patel Nagar Delhi"
				},
				{
				    "name": "Covid Vaccine Booth",
				    "location": "Nizamuddin Delhi"
				},
				{
				    "name": "Covid Vaccine Booth",
				    "location": "Sarita Vihar"
				},
				{
				    "name": "Covid Vaccine Booth",
				    "location": "Ghaziabad"
				}
			    ]
			}

2. getAvailableVaccinesWithBranch()
   GET   /vaccine-now/branch/vaccines
   Description : This API shows the avaialbility of vaccines in each branch
   Response Sample :   {
			    "vaccineAvailability": [
				{
				    "branch": "Covid Vaccine Booth,Patel Nagar Delhi",
				    "availibilityInBranch": 0
				},
				{
				    "branch": "Covid Vaccine Booth,Nizamuddin Delhi",
				    "availibilityInBranch": 10
				},
				{
				    "branch": "Covid Vaccine Booth,Sarita Vihar",
				    "availibilityInBranch": 5
				},
				{
				    "branch": "Covid Vaccine Booth,Ghaziabad",
				    "availibilityInBranch": 5
				}
			    ]
			}

3. getAvailableVaccinesForBranch(@PathVariable("branchId") Integer branchId)
   GET  /vaccine-now/branch/1/vaccines
   Description : This API pulls avaialble Vaccines for branch id passed as path param
   Response sample : {
			    "vaccineAvailability": [
				{
				    "branch": "Covid Vaccine Booth,Patel Nagar Delhi",
				    "availibilityInBranch": 0
				}
			    ]
			}

4. getTimeAvailableForBranch(@PathVariable("branchId") Integer branchId)
   GET /vaccine-now/branch/1/availability
   Description: This API shows time availabiluity for vaccine for specific branch passed as param
   Response sample : {
			    "branch": "Covid Vaccine Booth,Nizamuddin Delhi",
			    "availibilityInBranch": "2021-03-28T18:30:00.000+00:00"
			} 

5. scheduleVaccinationForUserWithAvailableTimeSlot(@RequestBody VaccineRequest vaccineRequest)
   POST /vaccine-now/schedule/vaccine
   {
    "userID": "1",
    "branchId": "1",
    "timeSlot": "2021-03-15",
    "paymentMode": "Cash"
   }

   Description : This API books time slot for above request sample with time bandwidth of 15 mins. Notification is also send to respective user
                 regarding confired time slot. If any exception is encountered then response is Internal Server Error.

   Response Sample :    200 OK  Vaccine Scheduled is successful
