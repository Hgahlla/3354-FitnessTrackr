public class User {
    private String first, last, pw, email, height, weight, gender, dob;
    
    public User(){}
    public User(String firstName, String lastName, String username, String password, String h, String w, String sex, String bd)
    {
        first = firstName;
        last = lastName;
        email = username;
        height = h;
        weight = w;
        gender = sex;
        dob = bd;
    }
    
    //setters
    public void setUsername(String username){email = username;}
    public void setFirstName(String firstName){first = firstName;}
    public void setLastName(String lastName){last = lastName;}
    public void setPW(String password){pw = password;}
    public void setHeight(String h){height = h;}
    public void setWeight(String w){weight = w;}
    public void setGender(String sex){gender = sex;}
    public void setDOB(String bd){dob = bd;}
    
    //getters
    public String getEmail(){return email;}
    public String getFirstName(){return first;}
    public String getLastName(){return last;}
    public String getPW(){return pw;}
    public String getHeight(){return height;}
    public String getWeight(){return weight;}
    public String getGender(){return gender;}
    public String getDOB(){return dob;}
    
    @Override
    public String toString() {
        return new StringBuffer(email).append(" ").append(first).append(" ").append(last).append(" ").append(pw).append(" ").append(height).append(" ").append(weight).append(" ").append(gender).append(" ").append(dob).toString();
    }
}