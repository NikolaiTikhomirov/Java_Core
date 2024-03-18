public class Task {
    String shortDescription;
    String detailedDescription;
    public Task(String shortDescription, String detailedDescription) {
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
    }

    @Override
    public String toString (){
        return "Task: " + shortDescription + " Description: " + detailedDescription;
    }

}
