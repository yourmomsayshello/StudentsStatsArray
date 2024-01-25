public class StudentStatsArray
{

    // Add private final variable to hold Students array
    private final Student[] students;

    public StudentStatsArray(Student[] students)
    {
        // Constructor code
        this.students = students;
    }

    // Returns the average gpa of the students
    public double averageGpa()
    {
        double sum=0;
        for(int i=0; i< students.length; i++){
            sum+=students[i].getGpa();
        }
        return sum/students.length;
    }

    // Returns the gpa range of the students
    public double getGpaRange()
    {
       double max=students[0].getGpa();
       double min=students[0].getGpa();
       double gpa;
       for(int i=1; i<students.length; i++){
           gpa=students[i].getGpa();
           if(gpa<min){
               min=gpa;
           }
           if(gpa>max){
               max=gpa;
           }
       }
        return max-min;
    }

    // Returns the name of the student that has the longest length
    public String getLongestName()
    {
       String longest=students[0].getName();
       for(int i =1; i<students.length; i++){
           if(students[i].getName().length()>longest.length()){
               longest = students[i].getName();
           }
       }

        return longest;
    }

    // Returns a count of the number freshman students
    public int getNumFreshman()
    {
        int count=0;
        for(int i=0; i< students.length;i++){
            if(students[i].getYear()==1){
                count++;
            }
        }
        return count;
    }

    // Returns the index of the first student with a name equal to name.
    // Returns -1 if not found
    public int search(String name)
    {
        for(int i=0;i< students.length;i++){
            if(students[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    // Returns the index of the first student with a gpa greater than or equal to the gpa
    // Returns -1 if not found
    public int search(double gpa)
    {
        for(int i=0;i< students.length;i++){
            if(students[i].getGpa() == gpa){
                return i;
            }
        }
        return -1;
    }

    // Returns 1 if the students are sorted in ascending order by their gpa; -1 if they
    // are sorted in descending order; 0 otherwise.
    public int sortStatus() {
        if (isAscending()) {
            return 1;
        }
        if (isDescending()) {
            return -1;
        } else {
            return 0;
        }
    }
        private boolean isAscending(){
            for (int i = 0; i < students.length; i++) {

                if (this.students[0].getGpa() > this.students[i].getGpa()) {
                    return false;
                }
            }
            return true;
        }
        private boolean isDescending(){
            for(int i=0; i<students.length; i++){
                if(students[0].getGpa()< students[1].getGpa()){
                    return false;
                }

            }
            return true;
        }



        // Returns the array of students in JSON like format
        public String toString () {
            String result = "\n";
            for (int i = 0; i < students.length; i++) {
                result += students[i].toString();
            }
            return result;
        }

    }