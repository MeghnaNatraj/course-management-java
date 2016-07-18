# Elective Management

This application is an efficient way to allot various department elective subjects to students. Students can register for electives by assigning preferences (up to 4) to subjects in an elective group. On a first come first serve basis (an assignment queue), our algorithm allots a subject to each student in an unbiased manner. An elective coordinator (administrator) needs to only click a few buttons and within seconds, all students will be notified of their allotment via email.

## Working of the application (based on user type)

* Students:

Students login to the system based on their User Id (their unique college ID/SSN) and a special password that is given to them prior to registration. After they login, a list of electives are displayed as group A and group B (assuming 2 groups here). From each of these groups, a student assigns preferences to 4 subjects (1 to 4) such that 1 has the highest priority and 4 has the least priority. 

After the students have selected their choices and submit, they can modify their preferences until the deadline, but they would get pushed to the end of the assignment queue. Additionally, students can also view the subjects and their details such as coursework, professor assigned, credits alloted, etc and the allotted subject once it has been assigned.

* Elective coordinator: 

Elective coordinator manages the content of the database and the allotment of subjects for each student. He/She can assign constraints as well. (eg. the minimum/maximum number of students for a class)

## Algorithm

If the student’s first preference cannot be allotted (i.e, limit of a class has been reached) then the second, third or fourth preference is allotted. If none of the choices as selected by the student matches the subjects offered, then the one selected by most students is assigned as a default.