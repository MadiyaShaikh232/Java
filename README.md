 Achieved by using Hibernate.
- Data hiding and secured indirect access given to the members also used getters and setters method .
- Application of Encapsulation approach and Logical program Implementation achieved.


*how to connect sql to java-
by using persistence.xml file i am giving database properties Like db name ,user and password.

eg-<property name="javax.persistence.jdbc.driver"
    value="org.postgresql.Driver" /> <!-- DB Driver -->
   <property name="javax.persistence.jdbc.url"
    value="jdbc:postgresql://localhost:5432/PasswordManagement" /> <!-- DB Name -->
   <property name="javax.persistence.jdbc.user"
    value="postgres" /> <!-- DB User -->
   <property name="javax.persistence.jdbc.password"
    value="root" /> <!-- DB Password -->

*tell me about project-
it is used to collabrate with project and task with employee.

in my project i used to gathere information about and which task assign to employee.
and perform crud operation to crate ,remove,update employee or task according to condition



*how to create project-
by using hibernate there are so many inbuilt method using create employee and task entity i am assign some attributes like employee entity name,sal,id,doj etc or task entity task name,startdate and due date using mapping

* how to create employee-
in controller class i am creating different method save employee in method i am taking employee object by userend and stored in db.
in hibernate there are inbuild class in which having methods like persist to save object,for deleting remove method for updating merge methods are present.

public boolean saveEmp(Employee employee) {

  transaction.begin();
  manager.persist(employee);
  transaction.commit();

  return true;

 }
