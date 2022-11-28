package ca.appolizer.AppolizerJobSearch.model;

public class Job {
    private String title;
    private String description;

    String companyName;

    private String location;

    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Job(String title, String description, String companyName, String location) {
        this.title = title;
        this.description = description;
        this.companyName = companyName;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }
}
