package com.softserve.edu.lv251.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Marian Brynetskyi on 11.07.2017.
 */
@Entity
public class Test extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "test")
    private List<TestsResults> testsResults;

    public Test() {
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
