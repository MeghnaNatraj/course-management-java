# Course Management

This application is an efficient way to allot various department course subjects to students. Students can register for courses by assigning preferences (up to 4) to subjects in a course group. On a first come first serve basis (an assignment queue), our algorithm allots a subject to each student for each course group,in an unbiased manner. a course coordinator (administrator) needs to only click a few buttons and within seconds, all students will be notified of their allotment via email.

## Working of the application (based on user type)

* Students

Students login to the system based on their User Id (their unique college ID/SSN) and a special password that is given to them prior to registration. After they login, a list of courses are displayed as group A and group B (assuming 2 groups here). From each of these groups, a student assigns preferences to 4 subjects (1 to 4) such that 1 has the highest priority and 4 has the least priority. 

After the students have selected their choices and submit, they can modify their preferences until the deadline, but they would get pushed to the end of the assignment queue. Additionally, students can also view the subjects and their details such as coursework, professor assigned, credits allotted, etc and the allotted subject once it has been assigned.

* Course coordinator

Course coordinator manages the content of the database and the allotment of subjects for each student. He/She can assign constraints as well. (eg. the minimum/maximum number of students for a class)

## Algorithm

Based on a first come first serve basis, in the first iteration, the first preference of a student is allotted, if a seat is available in a class, and left unassigned if not. In the second iteration, the second preference is checked, only if the student has still not been allotted a subject, and the second preference is allotted if a seat is available in that class. This process continues until all 4 preferences are checked or until all students are allotted subjects. If a student still has no subject allotted, the subject taken by the maximum number of students is assigned as a default.