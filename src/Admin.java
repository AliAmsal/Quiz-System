
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;



/**
 *
 * @author Dell
 */

interface person {
    public boolean login(int id, String password) throws IOException;
}

class Quizzes {
    RandomAccessFile quizFile;
    
    private int id;
    private int totalQs;
    private String subject;
    private String topic;
    ArrayList<Question> qsArr;
    Question ques = new Question();
    Question[] array;
    
    public Quizzes() throws FileNotFoundException {
        qsArr = new ArrayList<>();
        quizFile  = new RandomAccessFile("quiz.dat","rw");
    }

    public Quizzes(int totalQs, String subject, String topic) throws FileNotFoundException, IOException { 
        this.totalQs = totalQs;
        this.subject = subject;
        this.topic = topic;
        qsArr = new ArrayList<>();
        quizFile = new RandomAccessFile("quiz.dat","rw");
    }

    public Quizzes(int id, int totalQs, String subject, String topic) throws FileNotFoundException {
        this.id = id;
        this.totalQs = totalQs;
        this.subject = subject;
        this.topic = topic;
        qsArr = new ArrayList<>();
        quizFile = new RandomAccessFile("quiz.dat","rw");
    }
    
    
    
    
    public void generateID() throws IOException {
        RandomAccessFile idsFile = new RandomAccessFile("ids.dat","rw");
        int n = (int) idsFile.length()/4;
        id = n + 1;
        idsFile.seek(idsFile.length());

    }

    public void writeQuizDetails() throws IOException {
        quizFile.seek(quizFile.length());
        StringBuffer sb;
        
        quizFile.writeInt(id);
        quizFile.writeInt(totalQs);
        
        
     
        sb = new StringBuffer(subject);
        
        sb.setLength(15);
        quizFile.writeChars(sb.toString());
        
        
        
            sb = new StringBuffer(topic);
       
        sb.setLength(15);
        quizFile.writeChars(sb.toString());
        

     
    }
    public void writeQuestions(Question[] array) throws FileNotFoundException, IOException {
        StringBuffer sb;
        for(int i = 0; i < array.length; i++) {
            if (array[i].getQues() != null)
                sb = new StringBuffer(array[i].getQues());
            else
                sb = new StringBuffer();
            sb.setLength(50);
            quizFile.writeChars(sb.toString());
            
            if (array[i].getDetails() != null)
                sb = new StringBuffer(array[i].getDetails());
            else
                sb = new StringBuffer();
            sb.setLength(50);
            quizFile.writeChars(sb.toString());

            String[] opts = array[i].getOptions();
            for(int j = 0; j < 4; j++) {
                if (opts[j] != null)
                    sb = new StringBuffer(opts[j]);
                else
                    sb = new StringBuffer();
                sb.setLength(15);
                quizFile.writeChars(sb.toString());
            }
            quizFile.writeChar(array[i].getAns());
        }
    }
   
    
    public void read() throws IOException {
        qsArr = new ArrayList<>();
        Question[] arr = new Question[10];
        id = quizFile.readInt();
 
        totalQs = quizFile.readInt();
       
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = quizFile.readChar();
        subject = new String(temp);
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = quizFile.readChar();
        topic = new String(temp);
        array = new Question[totalQs];
        for(int i = 0; i < totalQs; i++) {
                    
                temp = new char[50];
                for (int j = 0; j < temp.length; j++)
                    temp[j] = quizFile.readChar();
                ques.setQues(new String(temp));
                
                temp = new char[50];
                for (int j = 0; j < temp.length; j++)
                    temp[j] = quizFile.readChar();
                ques.setDetails(new String(temp));
                
                String[] options = new String[4]; 
                for(int j = 0; j < 4; j++) {
                    temp = new char[15];
                    for (int k = 0; k < temp.length; k++)
                        temp[k] = quizFile.readChar();
                    options[j] = new String(temp);    
                }
                
                ques.setOptions(options);       
                ques.setAns(quizFile.readChar());
                
                arr[i] = new Question();
                array[i] = ques;
                arr[i].setQues(array[i].getQues());
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(array[i].getOptions());
        }
       
    }
    
    public Question[] read(int a) throws IOException {
        qsArr = new ArrayList<>();
        id = quizFile.readInt();
        System.out.println(id);
        totalQs = quizFile.readInt();
        System.out.println(totalQs);
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = quizFile.readChar();
        subject = new String(temp);
        System.out.println(subject);
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = quizFile.readChar();
        topic = new String(temp);
        System.out.println(topic);
        array = new Question[totalQs];
        Question[] arr = new Question[totalQs];
        for(int i = 0; i < totalQs; i++) {
            
                
                temp = new char[50];
                for (int j = 0; j < temp.length; j++)
                    temp[j] = quizFile.readChar();
                ques.setQues(new String(temp));
                
                temp = new char[50];
                for (int j = 0; j < temp.length; j++)
                    temp[j] = quizFile.readChar();
                ques.setDetails(new String(temp));
                
                String[] options = new String[4]; 
                for(int j = 0; j < 4; j++) {
                    temp = new char[15];
                    for (int k = 0; k < temp.length; k++)
                        temp[k] = quizFile.readChar();
                    options[j] = new String(temp);
                    
                }
                ques.setOptions(options);       
                ques.setAns(quizFile.readChar());
                array[i] = ques;
                arr[i] = new Question();
                arr[i].setQues(array[i].getQues());
                arr[i].setDetails(array[i].getDetails());
                arr[i].setOptions(options);
                arr[i].setAns(array[i].getAns());
                qsArr.add(ques);
                System.out.println(qsArr.get(i).getQues());
        }
        return arr;
       
    }

    public String getQsArr() {
        String ans = "";
        for(int i = 0; i < qsArr.size(); i++) {
            ans += qsArr.get(i).getQues();
        }
        return ans;
    }
    
    

    public int getId() {
        return id;
    }

    public int getTotalQs() {
        return totalQs;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalQs(int totalQs) {
        this.totalQs = totalQs;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
    
    public int size() {
        return 4 + 4 + 2*(15 + 15) + totalQs*qsArr.get(0).size();
    }
    
}


class Admin {
    RandomAccessFile adminFile = new RandomAccessFile("admin.dat","rw");
    private String username;
    private String password;

   

    public Admin(String username, String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
    }

    public Admin() throws FileNotFoundException {
        
    }
    
    public void read() throws IOException {
        adminFile.seek(0);
        char[] temp = new char[15];  // 15 chars for username
        for (int i = 0; i < temp.length; i++)
            temp[i] = adminFile.readChar();
        username = new String(temp).trim();
                
        temp = new char[15];  // 15 chars for pswd
        for (int i = 0; i < temp.length; i++)
            temp[i] = adminFile.readChar();
        password = new String(temp).trim();  // trim function removes empty spaces
    }
 
    public boolean login(String username, String password) throws IOException {
        
        boolean ans = false;
        
            read();
            if(username.equals(this.username) && password.equals(this.password) ) {
                ans = true;
            
            }
            System.out.println(this.username + " " + this.password); // testing username and pswd
      
        return ans;    
    }
    
    public void updatePassword(String password) throws IOException
    {
            adminFile.seek(30);  // 1 char = 2 bytes
            StringBuffer sb;
            
            if (password != null)
                sb = new StringBuffer(password);
            else
                sb = new StringBuffer();
            sb.setLength(15);
            adminFile.writeChars(sb.toString());
        
    }

    public void setId(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int size() {
        return 2*(15 + 15);
    }
}

class Teacher implements person
{
    RandomAccessFile teacherFile = new RandomAccessFile("teacher.dat","rw");
    private String name;
    private String cnic;
    private String qualification;
    private int id;
    private String password;
    private Boolean regStatus;
    public Teacher() throws FileNotFoundException {
        
    }

    public void write() throws IOException {
        StringBuffer sb;
        
        if (name != null)
            sb = new StringBuffer(name);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        teacherFile.writeChars(sb.toString());
        
        if (cnic != null)
            sb = new StringBuffer(cnic);
        else
            sb = new StringBuffer();
        sb.setLength(13);
        teacherFile.writeChars(sb.toString());
        
        if (qualification != null)
            sb = new StringBuffer(qualification);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        teacherFile.writeChars(sb.toString());
        
        
        teacherFile.writeInt(id);

        if (password != null)
            sb = new StringBuffer(password);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        teacherFile.writeChars(sb.toString());
        
        teacherFile.writeBoolean(regStatus);
    }
    
    public void signUp(String name, String cnic, String qualification, int id, String password) throws IOException{
        teacherFile.seek(teacherFile.length());
        this.name = name;
        this.cnic = cnic;
        this.qualification = qualification;
        this.id = id;
        this.password = password;
        this.regStatus = false;
        write();
    }
    
    @Override
    public boolean login(int id, String password) throws IOException {
        int n = (int) (teacherFile.length()/size());
        teacherFile.seek(0);
        boolean ans = false;
        for(int j = 0; j < n; j++) {
            read();
            if(id == this.id && password.equals(this.password.trim()) && regStatus) {
                ans = true;
                break;
            }    
        }
        return ans;    
    }
    
    public void read() throws IOException {
        //System.out.println(teacherFile.getFilePointer());
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = teacherFile.readChar();
        name = new String(temp);
    
        temp = new char[13];
        for (int i = 0; i < temp.length; i++)
            temp[i] = teacherFile.readChar();
        cnic = new String(temp);
    
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = teacherFile.readChar();
        qualification = new String(temp);
    
        id = teacherFile.readInt();
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = teacherFile.readChar();
        password = new String(temp);
    
        regStatus = teacherFile.readBoolean();
       
    }
    
    
    public void deleteTeacher(int id) throws FileNotFoundException, IOException {
        int n = (int) (teacherFile.length()/size());
        for(int i = 0; i < n; i++) {
            read();       
            if(id == getId()) {
                for(int j = i+1; j < n; j++) {
                    read();               
                    teacherFile.seek(teacherFile.getFilePointer() - 2*size());
                    write();
                    teacherFile.seek(teacherFile.getFilePointer() + size());
                }
                break;
            }
              
        }
        teacherFile.setLength(teacherFile.length() - size());
        
    }

    public RandomAccessFile getTeacherFile() {
        return teacherFile;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getQualification() {
        return qualification;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(int id, Boolean regStatus) throws IOException {
        this.regStatus = regStatus;
        int n = (int) (teacherFile.length()/size());
        teacherFile.seek(0);
        for(int i = 0; i < n; i++) {
            read();
            if(id == this.id) {
                teacherFile.seek(teacherFile.getFilePointer() - 1);
                teacherFile.writeBoolean(regStatus);
                break;
            }
        }
    }
    
    
    
    public int size() {
        return 2 * (15 + 13 + 15 + 15) + 1 + 4;
    }
}

class Student implements person {
    RandomAccessFile studentFile = new RandomAccessFile("student.dat","rw");
    private String name;
    private String cnic;
    private String institute;
    private int id;
    private String password;
    private Boolean regStatus;

    public Student() throws FileNotFoundException{
    }
    
    
    public void write() throws IOException {
        StringBuffer sb;
        
        if (name != null)
            sb = new StringBuffer(name);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        studentFile.writeChars(sb.toString());
        
        if (cnic != null)
            sb = new StringBuffer(cnic);
        else
            sb = new StringBuffer();
        sb.setLength(13);
        studentFile.writeChars(sb.toString());
        
        if (institute != null)
            sb = new StringBuffer(institute);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        studentFile.writeChars(sb.toString());
        
        
        studentFile.writeInt(id);

        if (password != null)
            sb = new StringBuffer(password);
        else
            sb = new StringBuffer();
        sb.setLength(15);
        studentFile.writeChars(sb.toString());
        
        studentFile.writeBoolean(regStatus);
    }
    
    public void signUp(String name, String cnic, String institute, int id, String password) throws IOException{
        studentFile.seek(studentFile.length());
        this.name = name;
        this.cnic = cnic;
        this.institute = institute;
        this.id = id;
        this.password = password;
        this.regStatus = false;
        write();
    }
    
    @Override
    public boolean login(int id, String password) throws IOException {
        int n = (int) (studentFile.length()/size());
        studentFile.seek(0);
        boolean ans = false;
        for(int j = 0; j < n; j++) {
            read();
            if(id == this.id && password.equals(this.password.trim()) && regStatus) {
                ans = true;
                break;
            }    
        }
        return ans;    
    }
    
    public void read() throws IOException {
        //System.out.println(teacherFile.getFilePointer());
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = studentFile.readChar();
        name = new String(temp);
    
        temp = new char[13];
        for (int i = 0; i < temp.length; i++)
            temp[i] = studentFile.readChar();
        cnic = new String(temp);
    
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = studentFile.readChar();
        institute = new String(temp);
    
        id = studentFile.readInt();
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = studentFile.readChar();
        password = new String(temp);
    
        regStatus = studentFile.readBoolean();
       
    }
    
    public void deleteStudent(int id) throws FileNotFoundException, IOException {
        int n = (int) (studentFile.length()/size());
        for(int i = 0; i < n; i++) {
            read();       
            if(id == getId()) {
                for(int j = i+1; j < n; j++) {
                    //System.out.println("o");
                    read();               
                    studentFile.seek(studentFile.getFilePointer() - 2*size());
                    write();
                    studentFile.seek(studentFile.getFilePointer() + size());
                }
                break;
            }
              
        }
        studentFile.setLength(studentFile.length() - size());
        
    }


    public RandomAccessFile getStudentFile() {
        return studentFile;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getInstitute() {
        return institute;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getRegStatus() {
        return regStatus;
    }
    
    public void setRegStatus(int id, Boolean regStatus) throws IOException {
        this.regStatus = regStatus;
        int n = (int) (studentFile.length()/size());
        studentFile.seek(0);
        for(int i = 0; i < n; i++) {
            read();
            if(id == this.id) {
                studentFile.seek(studentFile.getFilePointer() - 1);
                studentFile.writeBoolean(regStatus);
                break;
            }
        }
    }
    
     public int size() {
        return 2 * (15 + 13 + 15 + 15) + 1 + 4;
    }
    
}

class Question {
    RandomAccessFile quizFile;
    private String ques;
    private String details;
    private String[] options = new String[4];
    private char ans;

    public Question() throws FileNotFoundException {
        quizFile = new RandomAccessFile("quiz.dat","rw");
        
    }
    
    public void write() throws IOException {
        quizFile.seek(quizFile.length());
        StringBuffer sb;
        if (ques != null)
            sb = new StringBuffer(ques);
        else
            sb = new StringBuffer();
        sb.setLength(50);
        quizFile.writeChars(sb.toString());
        
        for(int i = 0; i < 4; i++) {
            if (options[i] != null)
                sb = new StringBuffer(options[i]);
            else
                sb = new StringBuffer();
            sb.setLength(15);
            quizFile.writeChars(sb.toString());
        
        }
        
        quizFile.writeChar(ans);
    }
    public void read(int pointer) throws IOException {
        quizFile.seek(pointer);
        char[] temp = new char[50];
        for (int i = 0; i < temp.length; i++)
            temp[i] = quizFile.readChar();
        ques = new String(temp);
     
        for(int i = 0; i < 4; i++) {
            temp = new char[15];
            for (int j = 0; j < temp.length; j++)
                temp[j] = quizFile.readChar();
            options[i] = new String(temp);
        }
           
        ans = quizFile.readChar();
        
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setAns(char ans) {
        this.ans = ans;
    }

    public String getQues() {
        return ques;
    }

    public String[] getOptions() {
        return options;
    }

    public char getAns() {
        return ans;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    

    @Override
    public String toString() {
        return "Question{" + "ques=" + ques + ", options=" + options + ", ans=" + ans + '}';
    }
    
    
    
    public int size() {
        return 2*(50 + 30 + 4*15 + 1);
    }
    
}
