package main;
        
public class RALfunction {
    public String[] validPerson(String[] data) {
        String[] result = {"true", ""};
        return result;
    }
    public Boolean validAccount(String[] data) {
        return true;
    }
    public Boolean validQA(String[] QA) {
        return true;
    }
    public Boolean loginSuccess(String[] data) {
        return true;
    }
    public String[] checkPerson(String[] data) {
        String[] result = {"true", "someone"};
        return result;
    }
    public void resetPassword(String Password){
        
    }
    public String[] getQuestion(String Username){
        String[] questions = {"Q1","Q2","Q3"};
        return questions;
    }
    public String[] getAnswer(String Username){
        String[] answers = {"A1","A2","A3"};
        return answers;
    }
}
