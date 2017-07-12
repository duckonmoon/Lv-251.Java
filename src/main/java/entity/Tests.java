package entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by kilopo on 11.07.2017.
 */
@Entity
public class Tests extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "tests")
    private List<TestsResults> testsResults;

    public Tests() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestsResults> getTestsResults() {
        return testsResults;
    }

    public void setTestsResults(List<TestsResults> testsResults) {
        this.testsResults = testsResults;
    }

}
