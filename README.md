## Passed TestIDs:

- Heroku Alert Automate - KDXWL-AX1XF-ME1FI-QWG6C
- heroku Login Autoamtee - SSX2J-PF8D5-Q3R71-EMO4R


## Pre-requisites

Before you can start performing Lambdatest-QA-Hackathon testing with Selenium, you would need to:

- Install the latest **Java development environment** i.e. **JDK 1.6** or higher. We recommend using the latest version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the [official website](https://www.selenium.dev/downloads/). Latest versions of Selenium Client and WebDriver are ideal for running your automation script on LambdaTest Selenium cloud grid.

- Install **Maven** which supports **JUnit** framework out of the box. **Maven** can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.

### Cloning Repo And Installing Dependencies

**Step 1:** Clone the LambdaTest’s Lambdatest-QA-Hackathon repository and navigate to the code directory as shown below:

```bash
git clone https://github.com/AyushAgarwaal/Lambdatest-QA-Hackathon.git
cd Lambdatest-QA-Hackathon
```

You can also run the command below to check for outdated dependencies.

```bash
mvn versions:display-dependency-updates
```

### Setting Up Your Authentication
**Step 2:** Set LambdaTest **Username** and **Access Key** in environment variables.

* For **Linux/macOS**:
  
  ```bash
  export LT_USERNAME="YOUR_USERNAME" 
  export LT_ACCESS_KEY="YOUR ACCESS KEY"
  ```
  * For **Windows**:
  ```bash
  set LT_USERNAME="YOUR_USERNAME" 
  set LT_ACCESS_KEY="YOUR ACCESS KEY"
  ```

### Configuring Your Test Capabilities

**Step 3:** In the test script, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with LambdaTest Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "120.0");
        capabilities.setCapability("platform", "win11"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "buildName");
        capabilities.setCapability("name", "testtName");
```



### Executing Parallel Tests Using TestNG

To run parallel tests using **TestNG**, we would have to execute the below commands in the terminal:

- For the above example code
  ```bash
  mvn test
  ```
- For the cloned Java-TestNG-Selenium repo used to run our first sample test
  ```bash
  mvn test -D suite=parallel.xml
  ```
