# Elective Management

This project helps students to register themselves for the various electives offered by the computer science department. Mainly concerned for 5th semester students and above as only they have the option as selecting electives. Students can login using their SIS login and password. Four preferences of each student are taken, and the available subject is allotted to each student on first come first serve basis. Subject allotment to each student is managed by electives coordinator, and the students will be notified through their SIS accounts.

Elective management is an efficient way to allot students various department elective subjects. This is applicable only for students of 5th semester and above. Our database provides different views to students and electives coordinator. 
 
* Students:

Students should use their SIS login and password to choose the elective subjects. Based on the semester of the student, list of elective subjects are displayed as group A and group B. From which students have to choose one subject from each group as first, second, third and fourth preferences. They must also enter their USN, name, and section. 

After the students have selected their choices, each student is given a Transaction Id, they can also update their choice within the last date of submission. This transaction Id is recorded in our database and students are allotted subjects only on first come first serve basis. If the students update their choices, then their waiting order will change. Students can only view, enter their choices and also update their choices. After the last date, students can view the subjects that can be offered as an elective and also the subject allotted to them by the coordinator. 

* Elective coordinator: 

Elective coordinator manages the subject allotment for each student and our database helps in the selection. Coordinator has a view in which list of all subjects and the count of students registered is displayed with the groups. If the number of students registered for that subject exceeds 35, then the subject can be offered as an elective subject. There is a constraint for the maximum number of students in each class, if it exceeds more than 70, a new class is allotted for the rest only if the remaining student strength is above 35. If the student’s first preference cannot be allotted then, second, third or fourth preference is allotted. If none of the choice of student matches the subject chosen for electives then a random subject is allotted by the coordinator. After allotting the subjects to students, the coordinator also allots them their class based on the availability of classrooms and more than 35 students strength. 