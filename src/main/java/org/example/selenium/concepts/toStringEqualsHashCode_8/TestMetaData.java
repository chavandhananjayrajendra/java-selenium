package org.example.selenium.concepts.toStringEqualsHashCode_8;


public class TestMetaData {
    private String testName;
    private String testUrl;

    public TestMetaData(String testName, String testUrl) {
        this.testName = testName;
        this.testUrl = testUrl;
    }

    // ✅ toString() for readable logging
    @Override
    public String toString() {
        return "Test: " + testName + ", URL: " + testUrl;
    }

    // ✅ equals() for comparing test metadata
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TestMetaData)) return false;
        TestMetaData other = (TestMetaData) obj;
        return this.testName.equals(other.testName) &&
                this.testUrl.equals(other.testUrl);
    }

    // ✅ hashCode() for collection use (like HashSet)
    @Override
    public int hashCode() {
        return testName.hashCode() + testUrl.hashCode();
    }
}
