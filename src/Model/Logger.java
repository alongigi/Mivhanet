package Model;

public class Logger {
    String filePath;

    public Logger(String filePath) {
        this.filePath = filePath;
        //open file
    }

    public void write(String s){
        //write to file
    }

    public void close(){
        //close file
        System.out.println("logger shutdown");
    }
}
